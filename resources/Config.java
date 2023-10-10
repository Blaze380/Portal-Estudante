package resources;

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
    protected static String dadosLogin = "";
    protected static String dados = "";
    protected static Scanner scanner = new Scanner(System.in);
    protected static int opcao = 0;
    protected static boolean hasDelay = true;
    protected static boolean hasFinished = false;
    protected static boolean sair = false;
    protected static boolean suspend = true;
    protected static String usuario = "";
    protected static String senha = "";
    protected static Arquivos arquivo = new Arquivos();

    protected static void regEstudantePessoais(int i) {
        estudante[i].registrar();
        System.out.println("\nAguarde...Salvando os seus arquivos!\n");
        estudanteSavePoint(estudante[i].getNome(), i);

        estudantePessoalSalv(i);
        estudanteLoginSalv(i);
        estudanteFinancaSalv(i);
        estudanteEscolarSalv(i);
        estudanteDisciplinaSalv(i);
    }

    /**
     * Este método serve para salvar os dados das disciplinas dos estudantes
     * 
     * @param i
     */
    protected static void estudanteDisciplinaSalv(int i) {
        for (int j = 0; j < estudante[i].disciplina.length; j++) {
            dados = estudante[i].salvarDisciplina(j);
            arquivo.criarArquivo(estudante[i].disciplina[j].getNome(),
                    dados,
                    arquivo.diretorio(arquivo.pathEstudante(estudante[i].getNome().toLowerCase() + "\\disciplinas\\")));

        }
    }

    /**
     * Este método serve para registrar o nome e a posição em que o estudante ocupou
     * na array "Estudante
     */
    protected static void estudanteSavePoint(String nome, int i) {
        String caminho = "\n\"nome\":";
        dados = "";
        int limiteLinhas = 1 + arquivo.contadorLinha(arquivo.diretorio(".\\dados"), "\\log_estudantes.txt", "log");
        String dadoEstudante = "";
        for (int j = 2; j <= limiteLinhas; j++) {
            // dadoEstudante = content.toString().substring(linha.indexOf(":") + 1);
            dadoEstudante = arquivo.lerArquivo(j,
                    arquivo.diretorio(".\\dados"), "\\log_estudantes.txt");
            dadoEstudante = dadoEstudante.substring(dadoEstudante.indexOf(":") + 1);
            dados += caminho + dadoEstudante;
            System.out.println(dadoEstudante);
            loadEstudante(dadoEstudante);
        }
        dados += caminho + nome.toLowerCase() + "/" + i;
        arquivo.criarArquivo("log_estudantes", dados, arquivo.diretorio(".\\dados"));
    }

    /**
     * MÉTODO CARREGAR ESTUDANTE
     */
    protected static void loadEstudante(String dado) {
        int posicao = Integer.parseInt(dado.substring(dado.indexOf("/") + 1)); // Atribui a posição do estudante
        dado = dado.substring(0, dado.indexOf("/"));
        System.out.println(dado);
    }

    /**
     * MÉTODO SALVAR LOGIN DO ESTUDANTE
     */
    protected static void estudanteLoginSalv(int i) {
        dados = estudante[i].salvarLogin();
        arquivo.criarArquivo("login", dados,
                arquivo.diretorio(arquivo.pathEstudante(estudante[i].getNome().toLowerCase())));
    }

    /**
     * MÉTODO SALVAR DADOS FINANCEIROS DO ESTUDANTE
     */
    protected static void estudanteFinancaSalv(int i) {
        dados = estudante[i].salvarFinancas();
        arquivo.criarArquivo("financas", dados,
                arquivo.diretorio(arquivo.pathEstudante(estudante[i].getNome().toLowerCase())));
    }

    /**
     * MÉTODO SALVAR DADOS ESCOLARES DO ESTUDANTE
     */
    protected static void estudanteEscolarSalv(int i) {
        dados = estudante[i].salvarEscolar();
        arquivo.criarArquivo("escola", dados,
                arquivo.diretorio(arquivo.pathEstudante(estudante[i].getNome().toLowerCase())));
    }

    /**
     * MÉTODO SALVAR DADOS PESSOAIS DO ESTUDANTE
     */
    protected static void estudantePessoalSalv(int i) {
        dados = estudante[i].salvarPessoal();
        arquivo.criarArquivo("pessoal", dados,
                arquivo.diretorio(arquivo.pathEstudante(estudante[i].getNome().toLowerCase())));
    }

    /**
     * Este método é o construtor fake kkkk
     * Ele instancia as classes "Estudante" e "Docente" em suas
     * Respectivas arrays
     */
    protected static void construtor() {
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
    protected static void delayTime(long miliSegundos) {
        try {
            if (hasDelay) {
                Thread.sleep(miliSegundos);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sistema de loading bar fake
     * Sistema de Loading Bar genérica dependendo de thread secundária
     */
    protected static void loadingBar() {
        while (!hasFinished) {
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

    /**
     * Este método permite Fazer a criação dos arquivo,ao mesmo tempo modificar ele
     * se já criados
     * 
     * @param tipo  "login,pessoal,finaneiro,escolar"
     * @param pasta
     * @param i
     */

    protected static void atualizarEstudante(int i) {
        estudantePessoalSalv(i);
        estudanteLoginSalv(i);
        estudanteFinancaSalv(i);
        estudanteEscolarSalv(i);
        estudanteDisciplinaSalv(i);
    }
}
