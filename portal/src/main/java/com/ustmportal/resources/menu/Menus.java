package com.ustmportal.resources.menu;

import java.io.IOException;
import java.util.Scanner;

import com.ustmportal.resources.teacher.Teacher;
import com.ustmportal.resources.utilities.Conversions;

public class Menus extends Conversions {
    private Scanner scanner = new Scanner(System.in);
    Teacher Teacher;
    private int option = 0;

    private String getScanner() {
        return scanner.nextLine();
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
