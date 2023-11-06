package com.ustmportal.resources.utilities;

import java.io.IOException;

import com.ustmportal.resources.logs.Log;

public final class Animations {

    public void wrongOptionFormat() {
        cleanConsole();
        System.out.println("Formato de Opcao Incorrecta! \nTente novamente!");
        animate(1000);
        cleanConsole();
    }

    public void specificLoadingBar(String message) {
        cleanConsole();
        System.out.print(message);
        for (int j = 1; j < 5; j++) {
            System.out.print(".");
            animate(200);
        }
        cleanConsole();
    }

    public void specificAnimatedMessage(String message, long milliseconds) {
        cleanConsole();
        System.out.println(message);
        animate(milliseconds);
        cleanConsole();
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

    public void animate(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Log.error(e, "Thread was interrupted while using sleep method!");
            // TODO e.printStackTrace();
        }
    }
}
