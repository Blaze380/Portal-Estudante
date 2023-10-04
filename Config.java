import estudante.Estudante;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import docente.Docente;

public abstract class Config {
    protected static Estudante estudante[] = new Estudante[30];
    protected static Docente docente[] = new Docente[5];
    protected static String caminho = "";
    protected static String dadosLogin = "";
    protected static String dados = "";
    protected static Scanner scanner = new Scanner(System.in);

    static void registrarEstudante() {
        System.out.println("* * * *   R E G I S T R O   E S T U D A N  T E   * * * *");
        System.out.print("Nome: ");
        estudante[0].setNome(scanner.next());
        System.out.print("Sobrenome: ");
        scanner.next();
        estudante[0].setSobreNome(scanner.nextLine());
        System.out.print("Data de nascimento: ");
        estudante[0].setDataNascimento(scanner.nextLine());
        System.out.print("Nome do encarregado: ");
        estudante[0].setNomeEncarregado(scanner.nextLine());
        System.out.print("Celular: ");
        estudante[0].setCelular(scanner.nextInt());
        System.out.print("E-mail: ");
        scanner.next();
        estudante[0].setEmail(scanner.nextLine());
        System.out.print("Senha: ");
        estudante[0].setSenha(scanner.nextLine());
        /**
         * Caminho pasta
         */
        caminho = ".\\estudante\\dados_estudantes\\" + estudante[0].getNome();
        File pasta = new File(caminho);
        if (!pasta.exists()) {
            pasta.mkdirs();
        }
        dados = "\"nome\":" + estudante[0].getNome() + "\n\"sobrenome\":" + estudante[0].getSobreNome()
                + "\n\"datanascimento\":" + estudante[0].getDataNascimento()
                + "\n\"nomeencarregado\":" + estudante[0].getNomeEncarregado()
                + "\n\"celular\":" + estudante[0].getCelular()
                + "\n\"genero\":" + estudante[0].getGenero()
                + "\n\"email\":" + estudante[0].getEmail();
        try (FileWriter arquivo = new FileWriter(
                pasta + File.separator + estudante[0].getNome().toLowerCase() + "_dados.txt")) {
            arquivo.write(dados);
            System.out.println("Arquivo criado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
}
