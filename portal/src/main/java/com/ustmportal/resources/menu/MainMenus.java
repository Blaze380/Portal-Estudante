package com.ustmportal.resources.menu;

import java.io.IOException;
import java.util.Scanner;

import com.ustmportal.resources.utilities.StringConversions;

public class MainMenus extends StringConversions {
    private Scanner scanner = new Scanner(System.in);
    private int option = 0;

    public String getScanner() {
        return scanner.nextLine();
    }

    /**
     * Prints if the user confirm the register data
     * 
     * @return option
     */
    public int confirmRegister() {
        cleanConsole();
        println("Voce deseja confirmar o seu registro? \n1 - Sim \n2 - nao \n\n\n");
        print("Opcao:");
        option = toInt(getScanner());
        return option;
    }

    /**
     * Sucess Menu
     */
    public void sucess() {
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
    public int confirmChanges() {
        cleanConsole();
        println("Voce deseja alterar? \n1 - Sim \n2 - nao \n\n\n");
        print("Opcao:");
        option = toInt(getScanner());
        return option;
    }

    /**
     * Here the student acess his data
     * 
     * @param studentName
     * @param studentCode
     * @return option
     */
    public int studentMenu(String studentName, int studentCode) {
        cleanConsole();
        println("***** MENU ESTUDANTE *****\n");
        println("Nome: " + studentName + "\nCodigo: " + studentCode + "\n\n");
        println("1 - Dados Pessoais \n2 - Dados Escolares \n3 - Dados Financeiros \n0 - Sair da conta");
        print("Opcao:");
        option = toInt(getScanner());
        return option;
    }

    /**
     * Menu that shows student subject data
     * 
     * @param student current Student Object
     * @return option
     */
    public void studentSubjectData(String subjectData) {
        cleanConsole();
        println("Disciplina       Nota1   Nota2  Trabalho  Media  Exame  MediaFinal  Observação");

        for (int i = 0; i < 4; i++) {
            println(subjectData);
        }

        println("\n\n\n0 - Voltar \nOpcao:");
    }

    /**
     * Menu that shows student personal data
     * 
     * @param student current Student Object
     * @return option
     */
    public int studentPersonalData(String personalData) {
        cleanConsole();
        println(" **** DADOS PESSOAIS *****");
        println(personalData + "\n\n\n1 - Alterar Senha \n0 - Voltar \nOpcao:");
        option = toInt(getScanner());
        return option;
    }

    /**
     * Menu that shows student financial data
     * 
     * @param financialData
     * @return
     */
    public int studentFinancialData(String financialData) {
        cleanConsole();
        println(" **** DADOS FINANCEIROS ****");
        println(financialData);
        println("\n\n1 - Pedir extrato \n0 - Voltar");
        print("Opcao:");
        option = toInt(getScanner());
        return option;
    }

    /**
     * * Menu that shows student school data
     * 
     * @param schoolData
     * @return
     */
    public int studentschoolData(String schoolData) {
        cleanConsole();
        println("****   DADOS ESCOLARES ****\n\n\n");
        println(schoolData + "\n1 - Verificar Notas \n0 - Voltar \nOpcao:");
        option = toInt(getScanner());
        return option;
    }

    /**
     * Main menu of the portal
     * 
     * @return option
     */
    public int mainMenu() {
        cleanConsole();
        println("Powered By BL4Z3 \n\n\n\n");
        println("                                        * * * * * * * * * * * * * * * * * * * ");
        println("                                        *                                   *");
        println("                                        *       P O R T A L   U S T M       *");
        println("                                        *                                   *");
        println("                                        * * * * * * * * * * * * * * * * * * * \n\n");
        println("                                                1 - Login como Docente");
        println("                                               2 - Login como Estudante");
        println("                                                       0 - Sair");
        print("Opcao:");
        option = toInt(getScanner());
        return option;
    }

    /**
     * Chose between the student make login or register by his self
     * 
     * @return option
     */
    public int studentChooseSigninOrSignup() {
        cleanConsole();
        println("                                   * * * *   L O G A R   E S T U D A N  T E   * * * *\n\n");
        println("                                                   1 - Fazer Login");
        println("                                                   2 - Criar conta");
        println("                                                      0 - Voltar");
        print("Opcao:");
        option = toInt(getScanner());
        return option;
    }

    /**
     * A short form of "System.out.println"
     * 
     * @param string String to be printed
     */
    public void println(String string) {
        System.out.println(string);
    }

    /**
     * A short form of "System.out.print"
     * 
     * @param string String to be printed
     */
    public void print(String string) {
        System.out.print(string);
    }

    /**
     * Cleans the console
     *
     * @throws IOException
     * @throws InterruptedException
     */
    public final void cleanConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
