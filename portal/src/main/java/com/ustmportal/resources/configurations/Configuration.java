package com.ustmportal.resources.configurations;

import java.io.IOException;
import java.util.Properties;
import com.ustmportal.resources.student.Student;
import com.ustmportal.resources.teacher.Teacher;
import com.ustmportal.resources.utilities.Archive;
import com.ustmportal.resources.utilities.JsonFiles;
import com.ustmportal.resources.utilities.Variables;

public abstract class Configuration {
    protected static Teacher teacher[] = new Teacher[5];
    protected static Properties prop = new Properties();
    protected static Archive file = new Archive();
    protected static Variables var = new Variables();
    protected static JsonFiles json = new JsonFiles();

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
        // TODO MISSING FIX THREADS
        // while (!var.getThreadHasFinishedWorking()) {
        // System.out.print("Carregando");
        // for (int j = 1; j < 5; j++) {
        // System.out.print(".");
        // makeDelay(200);
        // }
        // cleanConsole();
        // }
    }

}
