package com.ustmportal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Propriedades {
    public static void main(String[] args) throws SecurityException, IOException {
        Properties prop = new Properties();
        prop.setProperty("Nome", "niu5t5ro");
        prop.setProperty("Idade", "16");
        prop.setProperty("Ano", "1");
        prop.setProperty("curso", "LDS");
        try (FileOutputStream fileOut = new FileOutputStream("neste/Personal.properties")) {
            prop.store(fileOut, "Joanaaaaaaa");
            System.out.println("criei o gah");

        } catch (IOException e) {
            e.printStackTrace();
        }
        ///

        try (FileInputStream fileIn = new FileInputStream("neste/personal.properties")) {

            prop.load(fileIn);

            System.out.println("Nome: " + prop.getProperty("Nome"));
            System.out.println("Idade: " + prop.getProperty("Idade"));
            System.out.println("Ano: " + prop.getProperty("Ano"));

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("a");
        }
    }
}
