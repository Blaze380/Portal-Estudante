package resources.configurations;

import java.io.File;
import java.io.IOException;

import resources.student.Student;
import resources.teacher.Teacher;
import resources.utilities.Archive;
import resources.utilities.Variables;

public abstract class Configuration {
    protected static Student student[] = new Student[30];
    protected static Teacher teacher[] = new Teacher[5];
    protected static Archive file = new Archive();
    protected static Variables var = new Variables();

    protected static void registerStudentData(int position) {
        student[position].registerStudent();
        estudanteSavePoint(student[position].getName(), position);
        updateStudentData(position);
    }

    /**
     * Este método serve para registrar o nome e a posição em que o estudante ocupou
     * na array "Estudante
     */
    protected static void estudanteSavePoint(String nome, int i) {
        // String caminho = "\n\"nome\":";
        // dados = "";
        // int limiteLinhas = 1
        // + file.contadorLinha(file.createDiretoryPath(".\\dados"),
        // "\\log_estudantes.txt", "log");
        // String dadoEstudante = "";
        // for (int j = 2; j <= limiteLinhas; j++) {
        // // dadoEstudante = content.toString().substring(linha.indexOf(":") + 1);
        // dadoEstudante = file.loadAndReadFile(j,
        // file.createDiretoryPath(".\\dados"), "\\log_estudantes.txt");
        // dadoEstudante = dadoEstudante.substring(dadoEstudante.indexOf(":") + 1);
        // dados += caminho + dadoEstudante;
        // System.out.println(dadoEstudante);
        // loadEstudante(dadoEstudante);
        // }
        // dados += caminho + nome.toLowerCase() + "/" + i;
        // file.createFile("log_estudantes", dados,
        // file.createDiretoryPath(".\\dados"));
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
     * Saves The changes of the subjects data
     * 
     * @param position The position of the current student
     * @see Student#saveSubjectData
     */
    protected static void saveStudentSubjectData(int position) {
        String studentPosition = "_" + position;
        String studentPath = file.getStudentPath(student[position].getName() + studentPosition);
        File directoyPath = file.createDiretoryPath(studentPath + "\\subjects\\");
        String subjectDataContent = "";
        String subjectName = "";

        for (int i = 0; i < student[position].subject.length; i++) {

            subjectName = student[position].subject[i].getName();
            subjectDataContent = student[position].saveSubjectData(i);
            file.createFile(subjectName, subjectDataContent, directoyPath);

        }
    }

    /**
     * Saves The student login data in its file path
     *
     * @param position the Position Of the Current Student
     */
    protected static void saveStudentLoginData(int position) {
        String loginDataContent = student[position].saveLoginData();
        String studentPosition = "_" + position;
        String studentPath = file.getStudentPath(student[position].getName() + studentPosition);
        File directoyPath = file.createDiretoryPath(studentPath);
        file.createFile("login", loginDataContent, directoyPath);
    }

    /**
     * Saves The student financial data in its file path
     *
     * @param position the Position Of the Current Student
     */
    protected static void saveStudentFinancialData(int position) {
        String finantialDataContent = student[position].saveFinancialData();
        String studentPosition = "_" + position;
        String studentPath = file.getStudentPath(student[position].getName() + studentPosition);
        File directoryPath = file.createDiretoryPath(studentPath);
        file.createFile("finances", finantialDataContent, directoryPath);
    }

    /**
     * Saves The student school data in its file path
     *
     * @param position the Position Of the Current Student
     * @see Archive#createFile
     * @see Archive#createDiretoryPath
     * @see Archive#getStudentPath
     * @see Student#saveSchoolData
     */
    protected static void saveStudentShoolData(int position) {
        String schoolDataContent = student[position].saveSchoolData();
        String studentPosition = "_" + position;
        String studentPath = file.getStudentPath(student[position].getName() + studentPosition);
        File directoyPath = file.createDiretoryPath(studentPath);
        file.createFile("school", schoolDataContent, directoyPath);
    }

    /******************************************************
     * Saves The student personal data in its file path
     *
     * @param position the Position Of the Current Student
     */
    protected static void saveStudentPersonalData(int position) {
        String personalDataContent = student[position].savePersonalData();
        String studentPosition = "_" + position;
        String studentPath = file.getStudentPath(student[position].getName() + studentPosition);
        File directoyPath = file.createDiretoryPath(studentPath);
        file.createFile("personal", personalDataContent, directoyPath);
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
            if (var.isHasAnimationDelay()) {
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
        // MISSING FIX THREADS
        // while (!var.getThreadHasFinishedWorking()) {
        // System.out.print("Carregando");
        // for (int j = 1; j < 5; j++) {
        // System.out.print(".");
        // makeDelay(200);
        // }
        // cleanConsole();
        // }
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
