package com.ustmportal;

import com.ustmportal.resources.configurations.Configuration;
import com.ustmportal.resources.configurations.SecondaryThread;
import com.ustmportal.resources.menu.MainMenus;

final class App extends Configuration implements Runnable {
    static SecondaryThread thread[] = new SecondaryThread[3];
    static App mainClass = new App();
    static MainMenus menu = new MainMenus();
    static int option = 1;

    /**
     * It loads the Threads
     */
    static void loadThreads() {
        for (int i = 0; i < thread.length; i++) {
            thread[i] = new SecondaryThread();
            thread[i].setThread(new Thread(mainClass));
        }
    }

    public static void main(String[] args) {
        loadThreads();
        thread[0].getThread().start();
        paraClasse();
        mainMenu();
    }

    static void mainMenu() {
        loadingBar();
        option = menu.mainMenu();
        switch (option) {
            case 1:
                break;
            case 2:
                studentChooseSigninOrSignup();
                break;
        }
    }

    /**
     * Student Sign up Menu
     */
    static void studentSignup() {
        int currentPosition = var.getStudentFreePosition();
        registerStudentData(currentPosition);
        var.setStudentFreePosition(currentPosition + 1);
        studentMenu(currentPosition);
    }

    static void studentSignin() {
        menu.cleanConsole();
        System.out.print("Usuário: ");
        var.setUser(menu.getScanner());
        System.out.print("Senha: ");
        var.setPassword(menu.getScanner());
        // Missing!"!!!!!!!!!!!!!"
    }

    static void studentChooseSigninOrSignup() {
        option = menu.studentChooseSigninOrSignup();
        switch (option) {
            case 1:
                studentSignin();
                break;
            case 2:
                studentSignup();
                break;
            case 0:
                mainMenu();
                break;
            default:
                studentChooseSigninOrSignup();
                break;
        }
    }

    /**
     * Student Main menu
     * 
     * @param position current student position
     */
    static void studentMenu(int position) {
        String studentName = student[position].getName();
        int studentCode = student[position].getStudentCode();

        option = menu.studentMenu(studentName, studentCode);
        switch (option) {
            case 1:
                menuStudentPersonalData();
            case 2:
                menuStudentSchoolData();
            case 3:
                menuStudentFinacialData();
            default:
                System.out.println("Opcao incorrecta!");
                studentMenu(position);
                break;
            case 0:
                mainMenu();
                break;
        }
    }

    /**
     * Prints the Student financial data menu
     */
    private static void menuStudentFinacialData() {
        int currentPosition = var.getCurrentStudentPosition();
        String financialData = student[currentPosition].printFinancialData();
        option = menu.studentFinancialData(financialData);
    }

    /**
     * Prints the Student school data menu
     */
    private static void menuStudentSchoolData() {
        int position = var.getCurrentStudentPosition();
        String schoolData = student[position].printSchoolData();
        option = menu.studentschoolData(schoolData);
        switch (option) {
            case 1:
                String subjectData = "";
                for (int i = 0; i < 5; i++) {
                    subjectData = student[position].printSubjectData(i);
                    menu.studentSubjectData(subjectData);
                }
        }
        option = Integer.parseInt(menu.getScanner());
    }

    /**
     * Prints the Student personal data menu
     */
    private static void menuStudentPersonalData() {
        int position = var.getCurrentStudentPosition();
        String personalData = student[position].printPersonalData();
        option = menu.studentPersonalData(personalData);
    }

    @Override
    public void run() {
        construtor();
        // threadHasFinishedWorking = !threadHasFinishedWorking;
        suspendSecondaryThread();
        menu.println("Terminado!");

    }

    synchronized void suspendSecondaryThread() {
        // while (threadHasSuspended) {
        // makeDelay(1000);
        // }
    }
}
