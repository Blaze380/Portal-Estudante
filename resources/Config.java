package resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import resources.student.Student;
import resources.teacher.Teacher;

public abstract class Config {
    protected static Student student[] = new Student[30];
    protected static Teacher teacher[] = new Teacher[5];
    protected static String dadosLogin = "";
    protected static String dados = "";
    protected static Scanner scanner = new Scanner(System.in);
    protected static int opcao = 0;
    protected static boolean hasAnimationDelay = true;
    protected static boolean threadHasFinishedWorking = false;
    protected static boolean threadHasSuspended = true;
    protected static boolean quitLoop = false;
    protected static String usuario = "";
    protected static String senha = "";
    protected static Archive archive = new Archive();

    protected static void regEstudantePessoais(int position) {
        student[position].registerStudent();
        System.out.println("\nAguarde...Salvando os seus arquivos!\n");
        estudanteSavePoint(student[position].getName(), position);

        saveStudentPersonalData(position);
        saveStudentLoginData(position);
        saveStudentFinancialData(position);
        saveStudentShoolData(position);
        saveStudentSubjectData(position);
    }

    /**
     * Saves The changes of the student data
     * 
     * @param position The position of the current student
     */
    protected static void saveStudentSubjectData(int position) {
        for (int i = 0; i < student[position].subject.length; i++) {
            dados = student[position].saveSubjectData(i);
            archive.createFile(student[position].subject[i].getName(),
                    dados,
                    archive.createDiretoryPath(
                            archive.getStudentPath(student[position].getName().toLowerCase() + "\\disciplinas\\")));

        }
    }

    /**
     * Este método serve para registrar o nome e a posição em que o estudante ocupou
     * na array "Estudante
     */
    protected static void estudanteSavePoint(String nome, int i) {
        String caminho = "\n\"nome\":";
        dados = "";
        int limiteLinhas = 1
                + archive.contadorLinha(archive.createDiretoryPath(".\\dados"), "\\log_estudantes.txt", "log");
        String dadoEstudante = "";
        for (int j = 2; j <= limiteLinhas; j++) {
            // dadoEstudante = content.toString().substring(linha.indexOf(":") + 1);
            dadoEstudante = archive.loadAndReadFile(j,
                    archive.createDiretoryPath(".\\dados"), "\\log_estudantes.txt");
            dadoEstudante = dadoEstudante.substring(dadoEstudante.indexOf(":") + 1);
            dados += caminho + dadoEstudante;
            System.out.println(dadoEstudante);
            loadEstudante(dadoEstudante);
        }
        dados += caminho + nome.toLowerCase() + "/" + i;
        archive.createFile("log_estudantes", dados, archive.createDiretoryPath(".\\dados"));
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
     * Saves The student login data in its file path
     *
     * @param position the Position Of the Current Student
     * @see METHODS:
     * @see createFile
     * @see createDiretoryPath
     * @see getStudentPath
     * @see saveLoginData
     */
    protected static void saveStudentLoginData(int position) {
        dados = student[position].saveLoginData();
        archive.createFile("login", dados,
                archive.createDiretoryPath(archive.getStudentPath(student[position].getName().toLowerCase())));
    }

    /**
     * Saves The student financial data in its file path
     *
     * @param position the Position Of the Current Student
     * @see Archive#createFile
     * @see Archive#createDiretoryPath
     * @see Archive#getStudentPath
     * @see Archive#saveFinancialData
     */
    protected static void saveStudentFinancialData(int position) {
        dados = student[position].saveFinancialData();
        archive.createFile("financas", dados,
                archive.createDiretoryPath(archive.getStudentPath(student[position].getName().toLowerCase())));
    }

    /**
     * Saves The student school data in its file path
     *
     * @param position the Position Of the Current Student
     * @see METHODS:
     * @see createFile
     * @see createDiretoryPath
     * @see getStudentPath
     * @see saveSchoolData
     */
    protected static void saveStudentShoolData(int position) {
        dados = student[position].saveSchoolData();
        archive.createFile("escola", dados,
                archive.createDiretoryPath(archive.getStudentPath(student[position].getName().toLowerCase())));
    }

    /******************************************************
     * Saves The student personal data in its file path
     *
     * @param position the Position Of the Current Student
     * @see METHODS:
     * @see createFile
     * @see createDiretoryPath
     * @see getStudentPath
     * @see savePersonalData
     */
    protected static void saveStudentPersonalData(int position) {
        dados = student[position].savePersonalData();
        archive.createFile("pessoal", dados,
                archive.createDiretoryPath(archive.getStudentPath(student[position].getName().toLowerCase())));
    }

    /**
     * This is the Fake constructor
     * 
     * @Functionality it Creates objects in student's array and teacher's array
     */
    protected static void construtor() {
        for (byte i = 0; i < student.length; i++) {
            student[i] = new Student();
            if (i < teacher.length) {
                teacher[i] = new Teacher();
            }
        }
    }

    /**
     * Cleans the console
     * 
     * @throws IOException
     * @throws InterruptedException
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
     * @param milliseconds the time(in milliseconds) to make delay
     * @throws InterruptedException
     */
    protected static void makeDelay(long milliseconds) {
        try {
            if (hasAnimationDelay) {
                Thread.sleep(milliseconds);
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
        while (!threadHasFinishedWorking) {
            System.out.print("Carregando");
            for (int j = 1; j < 5; j++) {
                System.out.print(".");
                makeDelay(200);
            }
            cleanConsole();
        }
    }

    /**
     * updates the current student data
     * 
     * @param postion the position of the current student
     */

    protected static void updateStudentData(int postion) {
        saveStudentPersonalData(postion);
        saveStudentLoginData(postion);
        saveStudentFinancialData(postion);
        saveStudentShoolData(postion);
        saveStudentSubjectData(postion);
    }
}
