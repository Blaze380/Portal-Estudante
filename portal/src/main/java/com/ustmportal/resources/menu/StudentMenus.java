package com.ustmportal.resources.menu;

import java.io.IOException;
import java.util.Scanner;

import com.ustmportal.resources.configurations.SecondaryThread;
import com.ustmportal.resources.student.Student;
import com.ustmportal.resources.utilities.Conversions;
import com.ustmportal.resources.utilities.JsonFiles;

public class StudentMenus extends Conversions implements Runnable {
    private final static SecondaryThread thread = new SecondaryThread();
    private final Scanner scanner = new Scanner(System.in);
    private final JsonFiles json = new JsonFiles();
    private static Student student = new Student();
    private static String userName = "";
    private static String password = "";
    private int option = 0;

    private String getScanner() {
        return scanner.nextLine();
    }

    /**
     * Prints if the user confirm the register data
     * 
     * @return option
     */
    void confirmRegister() {
        cleanConsole();
        println("Voce deseja confirmar o seu registro? \n1 - Sim \n2 - nao \n\n\n");
        print("Opcao:");
        option = toInt(getScanner());
    }

    /**
     * Sucess Menu
     */
    void sucess() {
        cleanConsole();
        println("Alteracoes feitas com sucesso!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    /**
     * Prints if the user confirm the changes
     * 
     * @return option
     */
    void confirmChanges() {
        cleanConsole();
        println("Voce deseja alterar? \n1 - Sim \n2 - nao \n\n\n");
        print("Opcao:");
        option = toInt(getScanner());
    }

    /**
     * Here the student acess his datade
     * 
     * @return option
     */
    void studentMenu() {
        boolean quit = false;
        while (!quit) {
            cleanConsole();
            println("***** MENU ESTUDANTE *****\n");
            println("Nome: " + student.getName() + "\nCodigo: " + student.getStudentCode() + "\n\n");
            println("1 - Dados Pessoais \n2 - Dados Escolares \n3 - Dados Financeiros \n0 - Sair da conta");
            print("Opcao:");
            option = toInt(getScanner());
            switch (option) {
                case 1:
                    showPersonalData();
                    break;
                case 2:
                    showSchoolData();
                    break;
                case 3:
                    showFinancialData();
                    break;
                case 0:
                    quit = !quit;
                    break;
                default:
                    System.out.println("Opcao incorrecta!");
                    break;
            }
        }
    }

    /**
     * Menu that shows student subject data
     */
    void showSubjectData() {
        cleanConsole();
        println("Disciplina       Nota1   Nota2  Trabalho  Media  Exame  MediaFinal  Observação");

        for (int i = 0; i < 4; i++) {
            println(student.subject[i].getName() + "     " + student.subject[i].getNote1() + "   "
                    + student.subject[i].getNote2() + "   "
                    + student.subject[i].getJob() + "   " + student.subject[i].getAverage() + "   "
                    + student.subject[i].getExam() + "   "
                    + student.subject[i].getFinalAverage() + "    "
                    + student.subject[i].getObservation());
        }

        println("\n\n\n0 - Voltar \nOpcao:");
    }

    /**
     * Menu that shows student personal data
     */
    void showPersonalData() {
        cleanConsole();
        println(" **** DADOS PESSOAIS *****");
        println("Nome completo: " + student.getName() + " " + student.getLastName() +
                "\nData de Nascimento: " + student.getBirthDate() +
                "\nCelular: " + student.getPhone() +
                "\nE-mail: " + student.getEmail() +
                "\nNome do encarregado: " + student.getNameInCharge() +
                "\nSenha: ******");
        println("\n\n\n1 - Alterar Senha \n0 - Voltar \nOpcao:");
        option = toInt(getScanner());
    }

    /**
     * Menu that shows student financial data
     */
    void showFinancialData() {
        cleanConsole();
        println(" **** DADOS FINANCEIROS ****");
        println("Nome: " + student.getName() +
                "\nSaldo: " + student.getCurrentBalance() +
                "\nSaldo em divida: " + student.getDebtBalance());
        println("\n\n1 - Pedir extrato \n0 - Voltar");
        print("Opcao:");
        option = toInt(getScanner());
        // TODO Create extract method
    }

    /**
     * * Menu that shows student school data
     */
    void showSchoolData() {
        cleanConsole();
        println("****   DADOS ESCOLARES ****\n\n\n");
        println("Nome: " + student.getName() +
                "\nCodigo: " + student.getStudentCode() +
                "\nCurso: " + student.getCourse() +
                "\nAno: " + student.getYear());
        println("\n1 - Verificar Notas \n0 - Voltar \nOpcao:");
        option = toInt(getScanner());
        switch (option) {
            case 1:
                showSubjectData();
                break;
        }
    }

    void teste() {
        StudentMenus menu = new StudentMenus();
        thread.setThread(new Thread(menu));
        thread.getThread().start();
    }

    /**
     * Chose between the student make login or register by his self
     * 
     * @return option
     */
    public void chooseSigninOrSignup() {
        teste();
        cleanConsole();
        println("                                   * * * *   L O G A R   E S T U D A N  T E   * * * *\n\n");
        println("                                                   1 - Fazer Login");
        println("                                                   2 - Criar conta");
        println("                                                      0 - Voltar");
        print("Opcao:");
        option = toInt(getScanner());
        switch (option) {
            case 1:
                signIn();
                break;
            case 2:
                signUp();

                break;
        }
    }

    void signIn() {
        cleanConsole();
        boolean userExists = false;
        boolean passwordIscorrect = false;

        while (!(userExists && passwordIscorrect)) {
            System.out.print("Usuário: ");
            userName = getScanner();
            System.out.print("Senha: ");
            password = getScanner();
            userExists = json.thisStudentExist(userName);
            if (userExists) {
                setSecondThreadWork("loadData");
                // login = json.loadStudentData(userName);
                if (student.getPassword().equals(password)) {
                    passwordIscorrect = !passwordIscorrect;
                } else {
                    println("Password incorrecto!");
                    makeDelay(1000);

                }
            } else {
                System.out.println("O usuário nao existe!");
                makeDelay(1000);
            }
        }
        studentMenu();
    }

    void signUp() {
        student.registerStudent(scanner);
        setSecondThreadWork("saveData");
        // TODO REmove this!!! json.saveStudentData(student);
        studentMenu();
    }

    private void setSecondThreadWork(String threadWork) {
        thread.setCurrentWork(threadWork);
        thread.setThreadHasFinishedWorking(false);
        thread.setThreadHasSuspended(false);
        loadingBar();
    }

    private void loadingBar() {
        while (!thread.isThreadHasFinishedWorking()) {
            System.out.print("Carregando");
            for (int j = 1; j < 5; j++) {
                System.out.print(".");
                makeDelay(200);
            }
            cleanConsole();
        }
    }

    @Override
    public void run() {
        while (true) {
            while (thread.threadHasSuspended == true) {

                makeDelay(100);
            }
            threadWork();
        }
    }

    private void threadWork() {
        switch (thread.getCurrentWork()) {
            case "loadData":
                student = json.loadStudentData(userName);
                break;
            case "saveData":
                json.saveStudentData(student);
                break;
        }
        thread.setThreadHasFinishedWorking(true);
        thread.setThreadHasSuspended(true);
    }

    /**
     * A short form of "System.out.println"
     * 
     * @param string String to be printed
     */
    void println(String string) {
        System.out.println(string);
    }

    /**
     * A short form of "System.out.print"
     * 
     * @param string String to be printed
     */
    void print(String string) {
        System.out.print(string);
    }

    /**
     * Cleans the console
     *
     * @throws IOException
     * @throws InterruptedException
     */
    final void cleanConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected static void makeDelay(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
