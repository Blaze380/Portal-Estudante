package com.ustmportal.resources.menu;

import java.io.File;
import java.util.Scanner;

import com.ustmportal.resources.configurations.SecondaryThread;
import com.ustmportal.resources.logs.Log;
import com.ustmportal.resources.student.Student;
import com.ustmportal.resources.teacher.Teacher;
import com.ustmportal.resources.utilities.Animations;
import com.ustmportal.resources.utilities.Archive;
import com.ustmportal.resources.utilities.Conversions;
import com.ustmportal.resources.utilities.Generic;
import com.ustmportal.resources.utilities.JsonFiles;
import com.ustmportal.resources.utilities.SystemPrinting;

public class TeacherMenus extends Conversions implements Runnable, MenuBase {
    private final static SecondaryThread thread = new SecondaryThread();
    private final Scanner scanner = new Scanner(System.in);
    private final SystemPrinting sys = new SystemPrinting();
    private static Teacher teacher = new Teacher();
    private final Animations it = new Animations();
    private final JsonFiles json = new JsonFiles();
    private final DataInput si = new DataInput();
    private final Archive file = new Archive();
    private static String userName = "";
    private static String password = "";
    private byte option = 0;

    private String getScanner() {
        return scanner.nextLine();
    }

    @Override
    public void startThread() {
        final TeacherMenus menu = new TeacherMenus();
        thread.setThread(new Thread(menu));
        thread.getThread().start();
    }

    /**
     * Chose between the teacher make login or register by his self
     */
    @Override
    public void chooseSigninOrSignup() {
        startThread();
        it.cleanConsole();
        sys.println("                                   * * * *   L O G A R   D O C E N T E   * * * *\n\n");
        sys.println("                                                   1 - Fazer Login");
        sys.println("                                                   2 - Criar conta");
        sys.println("                                                      0 - Voltar");
        sys.print("Opcao:");
        option = toByte(getScanner());
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
            userExists = json.thisUserExists(file.getTeacherPath(userName));
            if (userExists) {
                password = si.setLoginPassword();
                thread.setSecondThreadWork("loadData");
                loadingBar();
                if (teacher.getPassword().equals(password)) {
                    passwordIscorrect = !passwordIscorrect;
                } else {
                    it.specificAnimatedMessage("Senha incorrecta!", 2000);
                }
            } else {
                it.specificAnimatedMessage("O usuário nao existe!", 2000);
            }
        }
        mainMenu();
    }

    @Override
    public void signUp() {
        registerTeacher();
        teacher.loadMastersDegreeIn();
        thread.setSecondThreadWork("saveData");
        loadingBar();
        mainMenu();
    }

    private void registerTeacher() {
        boolean quit = false;
        while (!quit) {
            it.cleanConsole();
            teacher = si.registerTeacher();
            userName = teacher.getUserName();
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
                    getTeacherData();
                    break;
                case "saveData":
                    setTeacherData();
                    break;
            }
            thread.stopWork();
        }
    }

    /**
     * Saves the student data using the generic object
     */
    private void setTeacherData() {
        File teacherPath = file.createDiretoryPath(file.getTeacherPath(userName));
        Generic<?> teachGeneric = new Generic<>(teacher);
        json.saveUserData(teacherPath, teachGeneric);
    }

    /**
     * Loads the student data using generic object
     */
    private void getTeacherData() {
        File teacherPath = file.createDiretoryPath(file.getTeacherPath(userName));
        Generic<?> teacherGeneric = new Generic<>(teacher);
        teacher = (Teacher) json.loadUserData(teacherPath, teacherGeneric).getGenericObject();
    }

    @Override
    public void confirmChanges() {
        it.cleanConsole();
        sys.println("Voce deseja alterar? \n1 - Sim \n2 - nao \n\n\n");
        sys.print("Opcao:");
        option = toByte(getScanner());

    }

    @Override
    public void mainMenu() {
        boolean quit = false;
        while (!quit) {
            it.cleanConsole();
            sys.println("      * * * * *   M E N U   D O C E N T E   * * * * * \n");
            sys.println("Nome: " + teacher.getName() + "\n\n");
            sys.println("1 - Dados Pessoais \n2 - Gerenciamento Escolar \n0 - Sair da conta");
            sys.print("Opcao:");
            option = toByte(getScanner());
            switch (option) {
                case 1:
                    showPersonalData();
                    break;
                case 2:
                    schoolManagement();
                    break;
                case 0:
                    quit = !quit;
                    thread.setThreadHasBeenFinalized(true);
                    thread.startWork();
                    // thread.getThread().interrupt();
                default:
                    it.specificAnimatedMessage("opcao incorrecta!", 2000);
                    break;
            }
        }

    }

    private void schoolManagement() {
        it.cleanConsole();
        sys.println("O seu Mestrado: " + teacher.getMastersDegreeIn() + "\nEscolha a disciplina");
        sys.println(
                "\n\nO sistema ainda está em construcao devido a sua complexidade, e a minha preguica kkkk ");
        sys.print("Pressione qualquer tecla ou enter para voltar:");
        getScanner();
    }

    private void showPersonalData() {
        it.cleanConsole();
        sys.println(" **** DADOS PESSOAIS *****");
        sys.println("Nome completo: " + teacher.getName() + " " + teacher.getLastName() +
                "\nData de Nascimento: " + teacher.getBirthDate() +
                "\nCelular: " + teacher.getPhone() +
                "\nE-mail: " + teacher.getEmail() +
                "\nMestrado: " + teacher.getMastersDegreeIn() +
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
            if (teacher.getPassword().equals(password)) {
                teacher.setPassword(si.setPassword());
                thread.setSecondThreadWork("saveData");
                it.specificAnimatedMessage("Senha Alterada com sucesso!", 2500);
                quit = !quit;
            } else {
                it.specificAnimatedMessage("Senha incorrecta!", 2000);
            }
        }

    }

}
