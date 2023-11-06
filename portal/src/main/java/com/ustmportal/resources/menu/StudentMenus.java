package com.ustmportal.resources.menu;

import java.io.File;
import java.util.Scanner;

import com.ustmportal.resources.configurations.SecondaryThread;
import com.ustmportal.resources.logs.Log;
import com.ustmportal.resources.student.Student;
import com.ustmportal.resources.utilities.Animations;
import com.ustmportal.resources.utilities.Archive;
import com.ustmportal.resources.utilities.Conversions;
import com.ustmportal.resources.utilities.Generic;
import com.ustmportal.resources.utilities.JsonFiles;
import com.ustmportal.resources.utilities.SystemPrinting;

public class StudentMenus extends Conversions implements Runnable, MenuBase {
    private final static SecondaryThread thread = new SecondaryThread();
    private final Archive file = new Archive();
    private final DataInput si = new DataInput();
    private final Animations it = new Animations();
    private final Scanner scanner = new Scanner(System.in);
    private final SystemPrinting sys = new SystemPrinting();
    private final JsonFiles json = new JsonFiles();
    private static Student student = new Student();
    private static String userName = "";
    private static String password = "";
    private byte option = 0;

    private String getScanner() {
        return scanner.nextLine();
    }

    /**
     * Prints if the user confirm the changes
     * 
     * @return option
     */
    @Override
    public void confirmChanges() {
        it.cleanConsole();
        sys.println("Voce deseja alterar? \n1 - Sim \n2 - nao \n\n\n");
        sys.print("Opcao:");
        option = toByte(getScanner());
    }

    /**
     * Here the student acess his datade
     * 
     * @return option
     */
    @Override
    public void mainMenu() {
        boolean quit = false;
        while (!quit) {
            it.cleanConsole();
            sys.println("***** MENU ESTUDANTE *****\n");
            sys.println("Nome: " + student.getName() + "\nCodigo: " + student.getStudentCode() + "\n\n");
            sys.println("1 - Dados Pessoais \n2 - Dados Escolares \n3 - Dados Financeiros \n0 - Sair da conta");
            sys.print("Opcao:");
            option = toByte(getScanner());
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
                    thread.setThreadHasBeenFinalized(true);
                    thread.startWork();
                    // thread.getThread().interrupt();
                    break;
                default:
                    it.specificAnimatedMessage("opcao incorrecta!", 2000);
                    break;
            }
        }
    }

    /**
     * Menu that shows student subject data
     */
    void showSubjectData() {
        it.cleanConsole();
        sys.println(" ___________________________________________________________________________________");
        sys.println("|       Disciplina          |Nota1|Nota2|Trabalho|Media|Exame|MediaFinal|Observacao |");
        sys.println("|___________________________|_____|_____|________|_____|_____|__________|___________|");
        String spaces = "";
        for (int i = 0; i < 4; i++) {
            spaces = addSpacesToSubject(student.subject[i].getName());
            sys.println("|" + student.subject[i].getName() + spaces + "| " + student.subject[i].getNote1() + " | "
                    + student.subject[i].getNote2() + " |  " + student.subject[i].getJob() + "   | "
                    + student.subject[i].getAverage() + " | " + student.subject[i].getExam() + " |    "
                    + student.subject[i].getFinalAverage() + "   |" + student.subject[i].getObservation() + "|");
        }
        sys.println("|___________________________|_____|_____|________|_____|_____|__________|___________|");
        sys.println("\n0 - Voltar \nOpcao:");
        option = toByte(getScanner());
    }

    private String addSpacesToSubject(String string) {
        final int MAX_LENGTH = 28;
        int lengthToReach = MAX_LENGTH - string.length();
        String spaces = "";
        for (int i = 1; i < lengthToReach; i++) {
            spaces += " ";
        }
        return spaces;
    }

    /**
     * Menu that shows student personal data
     */
    void showPersonalData() {
        it.cleanConsole();
        sys.println(" **** DADOS PESSOAIS *****");
        sys.println("Nome completo: " + student.getName() + " " + student.getLastName() +
                "\nData de Nascimento: " + student.getBirthDate() +
                "\nCelular: " + student.getPhone() +
                "\nE-mail: " + student.getEmail() +
                "\nNome do encarregado: " + student.getNameInCharge() +
                "\nSenha: ******");
        sys.println("\n\n\n1 - Alterar Senha \n0 - Voltar \nOpcao:");
        option = toByte(getScanner());
        switch (option) {
            case 1:
                changePassword();
                break;
        }
    }

    private void changePassword() {
        String password = "";
        boolean quit = false;
        while (!quit) {
            it.cleanConsole();
            sys.println("Para confirmarmos, por favor, insira a sua senha antiga.\n");
            sys.print("Senha: ");
            password = getScanner();
            if (student.getPassword().equals(password)) {
                student.setPassword(si.setPassword());
                thread.setSecondThreadWork("saveData");
                it.specificAnimatedMessage("Senha Alterada com sucesso!", 2500);
                quit = !quit;
            } else {
                it.specificAnimatedMessage("Senha incorrecta!", 2000);
            }
        }

    }

    /**
     * Menu that shows student financial data
     */
    void showFinancialData() {
        it.cleanConsole();
        sys.println(" **** DADOS FINANCEIROS ****");
        sys.println("Nome: " + student.getName() +
                "\nSaldo: " + student.getCurrentBalance() +
                "\nSaldo em divida: " + student.getDebtBalance());
        sys.println("\n\n1 - Pedir extrato \n0 - Voltar");
        sys.print("Opcao:");
        option = toByte(getScanner());
        // TODO Create extract method
    }

    /**
     * * Menu that shows student school data
     */
    void showSchoolData() {
        it.cleanConsole();
        sys.println("****   DADOS ESCOLARES ****\n\n\n");
        sys.println("Nome: " + student.getName() +
                "\nCodigo: " + student.getStudentCode() +
                "\nCurso: " + student.getCourse() +
                "\nAno: " + student.getYear());
        sys.println("\n1 - Verificar Notas \n0 - Voltar \nOpcao:");
        option = toByte(getScanner());
        switch (option) {
            case 1:
                showSubjectData();
                break;
        }
    }

    @Override
    public void startThread() {
        final StudentMenus menu = new StudentMenus();
        thread.setThread(new Thread(menu));
        thread.getThread().start();
    }

    /**
     * Chose between the student make login or register by his self
     */
    @Override
    public void chooseSigninOrSignup() {
        Log.info("Emulandini");
        startThread();
        it.cleanConsole();
        sys.println("                                   * * * *   L O G A R   E S T U D A N  T E   * * * *\n\n");
        sys.println("                                                   1 - Fazer Login");
        sys.println("                                                   2 - Criar conta");
        sys.println("                                                      0 - Voltar");
        sys.print("Opcao:");
        option = toByte(getScanner());
        Log.warning("cuidado!!!!");
        switch (option) {
            case 1:
                signIn();
                break;
            case 2:
                signUp();

                break;
        }
    }

    /**
     * Sign in menu!
     */
    @Override
    public void signIn() {
        it.cleanConsole();
        boolean userExists = false;
        boolean passwordIscorrect = false;
        while (!(userExists && passwordIscorrect)) {
            userName = si.setUserName();
            userExists = json.thisUserExists(file.getStudentPath(userName));
            if (userExists) {
                password = si.setLoginPassword();
                thread.setSecondThreadWork("loadData");
                loadingBar();
                if (student.getPassword().equals(password)) {
                    passwordIscorrect = !passwordIscorrect;
                } else {
                    it.specificAnimatedMessage("Senha incorrecta!", 1000);
                }
            } else {
                it.specificAnimatedMessage("O usuário nao existe!", 1000);
            }
        }
        mainMenu();
    }

    @Override
    public void signUp() {
        registerStudent();
        thread.setSecondThreadWork("saveData");
        loadingBar();
        mainMenu();
    }

    private void registerStudent() {
        boolean quit = false;
        while (!quit) {
            it.cleanConsole();
            student = si.registerStudent();
            userName = student.getUserName();
            if (json.thisUserExists(file.getTeacherPath(userName))) {
                it.specificAnimatedMessage("O nome de usuario ja existe, Tente novamente!", 2000);
            } else {
                quit = !quit;
            }
        }
    }

    @Override
    public void loadingBar() {
        while (!thread.isThreadHasFinishedWorking()) {
            it.specificLoadingBar("Verificando o usuario");
        }
    }

    @Override
    public void run() {
        while (!thread.isThreadHasBeenFinalized()) {

            while (thread.isThreadHasSuspended()) {
                it.animate(100);
            }
            threadWork();
        }
    }

    @Override
    public void threadWork() {
        if (!thread.isThreadHasBeenFinalized()) {
            switch (thread.getCurrentWork()) {
                case "loadData":
                    getStudentData();
                    break;
                case "saveData":
                    setStudentData();
                    break;
            }
            thread.stopWork();
        }
    }

    /**
     * Saves the student data using the generic object
     */
    private void setStudentData() {
        File studentPath = file.createDiretoryPath(file.getStudentPath(userName));
        Generic<?> studentGeneric = new Generic<>(student);
        json.saveUserData(studentPath, studentGeneric);
    }

    /**
     * Loads the student data using generic object
     */
    private void getStudentData() {
        File studentPath = file.createDiretoryPath(file.getStudentPath(userName));
        Generic<?> studentGeneric = new Generic<>(student);
        student = (Student) json.loadUserData(studentPath, studentGeneric).getGenericObject();
    }

}
