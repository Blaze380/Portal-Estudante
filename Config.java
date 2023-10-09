import estudante.Estudante;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import docente.Docente;

public abstract class Config {
    protected static Estudante estudante[] = new Estudante[30];
    protected static Docente docente[] = new Docente[5];
    // protected static String caminhoEstudante = "";
    // protected static String caminhoDocente = "";
    protected static String dadosLogin = "";
    protected static String dados = "";
    protected static Scanner scanner = new Scanner(System.in);
    protected static int opcao = 0;
    protected static boolean isDelay = false;
    protected static boolean sair = false;
    protected static String usuario = "";
    protected static String senha = "";

    static void regEstudantePessoais(int i) {
        // NOME:
        System.out.print("Nome: ");
        estudante[i].setNome(scanner.next());

        // SOBRENOME:
        System.out.print("Sobrenome: ");
        estudante[i].setSobreNome(scanner.next());

        // DATA DE NASCIMENTO:
        System.out.print("Data de nascimento(dd/mm/aaaa): ");
        estudante[i].setDataNascimento(scanner.next());

        // NOME DO ENCARREGADO:
        System.out.print("Nome do encarregado: ");
        estudante[i].setNomeEncarregado(scanner.next());

        // NÚMERO DO CELULAR
        System.out.print("Celular: ");
        estudante[i].setCelular(scanner.nextInt());

        // GÊNERO:
        System.out.print("1 - Masculino \n2 - Femenino \n:");
        switch (scanner.nextInt()) {
            case 1:
                estudante[i].setGenero('M');
                break;
            case 2:
                estudante[i].setGenero('F');
                break;
        }

        // E-MAIL:
        System.out.print("E-mail: ");
        estudante[i].setEmail(scanner.next());

        // SENHA:
        while (!sair) {
            String senha, confSenha;
            System.out.print("Senha: ");
            senha = scanner.next();
            System.out.print("Confirmar Senha: ");
            confSenha = scanner.next();
            if (senha.equals(confSenha)) {
                estudante[i].setSenha(confSenha);
                sair = !sair;
            } else {
                cleanConsole();
                System.out.println("Senha Incorrecta!");
            }
        }
        System.out.println("\nAguarde...Salvando os seus arquivos!\n");
        logEstudantes(estudante[i].getNome(), i);
        estudantePessoalSalv(i);
        estudanteLoginSalv(i);
        estudanteFinancaSalv(i);
        estudanteEscolarSalv(i);
        estudanteDisciplinaSalv(i);
    }

    static void estudanteDisciplinaSalv(int i) {
        for (int j = 0; j < estudante[i].disciplina.length; j++) {
            dados = "\"nome\":" + estudante[i].disciplina[j].getNome() +
                    "\n\"nota1\":" + estudante[i].disciplina[j].getNota1() +
                    "\n\"nota2\":" + estudante[i].disciplina[j].getNota2() +
                    "\n\"trabalho\":" + estudante[i].disciplina[j].getTrabalho() +
                    "\n\"media\":" + estudante[i].disciplina[j].getMedia() +
                    "\n\"exame\":" + estudante[i].disciplina[j].getExame() +
                    "\n\"mediafinal\":" + estudante[i].disciplina[j].getMediaFinal() +
                    "\n\"observacao\":" + estudante[i].disciplina[j].getObservacao();
            criarArquivo(estudante[i].disciplina[j].getNome(),
                    diretorio(pathEstudante(estudante[i].getNome().toLowerCase() + "\\disciplinas\\")));

        }
    }

    static void logEstudantes(String nome, int i) {
        String caminho = "\n\"nome\":";
        dados = "";
        try (FileReader leitorArquivo = new FileReader(diretorio(".\\dados") + "\\log_estudantes.txt")) {
            BufferedReader leitorLinha = new BufferedReader(leitorArquivo);
            String linha;
            leitorLinha.readLine();
            while ((linha = leitorLinha.readLine()) != null) {
                dados += caminho + linha.substring(linha.indexOf(":") + 1);
            }
            // RESOLVER BUG!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            System.out.println(linha.indexOf(":"));
        } catch (Exception e) {
            // TODO: handle exception'
        }
        dados += caminho + nome + "/" + i;
        criarArquivo("log_estudantes", diretorio(".\\dados"));
    }

    /**
     * Salvar Dados de Login do estudante
     *
     * @param i
     */
    static void estudanteLoginSalv(int i) {
        dados = "\"nome\":" + estudante[i].getNome() + "\n\"senha\":" + estudante[i].getSenha();
        criarArquivo("login", diretorio(pathEstudante(estudante[i].getNome().toLowerCase())));
    }

    /**
     * Salvar Dados Financeiros do estudante
     *
     * @param i
     */
    static void estudanteFinancaSalv(int i) {
        dados = "\"saldoatual\":" + estudante[i].getSaldoAtual() + "\n\"saldodivida\":" + estudante[i].getSaldoDivida();
        criarArquivo("financas", diretorio(pathEstudante(estudante[i].getNome().toLowerCase())));
    }

    /**
     * Salvar Dados Escolares do estudante
     *
     * @param i
     */
    static void estudanteEscolarSalv(int i) {
        dados = "\"curso\":" + estudante[i].getCurso() +
                "\n\"ano\":" + estudante[i].getAno() +
                "\n\"numero\":" + estudante[i].getNumero() +
                "\n\"turma\":" + estudante[i].getTurma() +
                "\n\"codigoestudante\":" + estudante[i].getCodigoEstudante();
        criarArquivo("escola", diretorio(pathEstudante(estudante[i].getNome().toLowerCase())));
    }

    /**
     * Este método cria um objecto que permite manipular arquivos
     * de um diretório específico
     *
     * @param caminho
     * @return {path object kkk}
     */
    static File diretorio(String caminho) {
        File pasta = new File(caminho);
        /**
         * Verifica se a pasta com o nome específico(seja docente ou estudante)
         * Esxiste no diretório, caso não exista...a pasta será criada
         */
        if (!pasta.exists()) {
            pasta.mkdirs();
        }
        return pasta;
    }

    /**
     * Salvar Dados Pessoais do estudante
     *
     * @param i
     */
    static void estudantePessoalSalv(int i) {
        dados = "\"nome\":" + estudante[i].getNome() +
                "\n\"sobrenome\":" + estudante[i].getSobreNome() +
                "\n\"datanascimento\":" + estudante[i].getDataNascimento() +
                "\n\"nomeencarregado\":" + estudante[i].getNomeEncarregado() +
                "\n\"celular\":" + estudante[i].getCelular() +
                "\n\"genero\":" + estudante[i].getGenero() +
                "\n\"email\":" + estudante[i].getEmail();
        criarArquivo("pessoal", diretorio(pathEstudante(estudante[i].getNome().toLowerCase())));
    }

    /**
     * Este método é o construtor fake kkkk
     * Ele instancia as classes "Estudante" e "Docente" em suas
     * Respectivas arrays
     */
    static void construtor() {
        for (byte i = 0; i < estudante.length; i++) {
            estudante[i] = new Estudante();
            if (i < docente.length) {
                docente[i] = new Docente();
            }
        }
    }

    /**
     * Limpador de console
     */
    protected static final void cleanConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Este método serve para causar atraso,permitindo animações ao programa
     * 
     * @param miliSegundos
     */
    static void delayTime(long miliSegundos) {
        try {
            if (isDelay) {
                Thread.sleep(miliSegundos);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sistema de loading bar fake
     */
    static void loadingBar() {
        for (int i = 1; i < 5; i++) {
            System.out.print("Carregando");
            for (int j = 1; j < 5; j++) {
                System.out.print(".");
                delayTime(200);
            }
            cleanConsole();
        }
    }

    /**
     * Esse método atribui os caminhos padrão de estudante e docente
     */
    static String pathEstudante(String nome) {
        return ".\\dados\\dados_estudante\\" + nome;
    }

    static String pathDocente(String nome) {
        return ".\\dados\\dados_docente\\" + nome;
    }

    /**
     * Este método permite Fazer a criação dos arquivo,ao mesmo tempo modificar ele
     * se já criados
     * 
     * @param tipo  "login,pessoal,finaneiro,escolar"
     * @param pasta
     * @param i
     */
    static void criarArquivo(String nome, File pasta) {
        try (FileWriter arquivo = new FileWriter(
                pasta + File.separator + nome.toLowerCase() + ".txt")) {
            arquivo.write(dados);
            System.out.println(nome.toUpperCase() + " criado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void atualizarEstudante(int i) {
        estudantePessoalSalv(i);
        estudanteLoginSalv(i);
        estudanteFinancaSalv(i);
        estudanteEscolarSalv(i);
        estudanteDisciplinaSalv(i);
    }
}
