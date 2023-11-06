package com.ustmportal.resources.logs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.ustmportal.resources.configurations.SecondaryThread;
import com.ustmportal.resources.utilities.Animations;
import com.ustmportal.resources.utilities.Archive;

import lombok.Getter;
import lombok.Setter;

public class Log implements Runnable {
    private final static Archive file = new Archive();
    private final static Animations it = new Animations();
    private final static SecondaryThread thread = new SecondaryThread();
    private final static LogAttributes log = new LogAttributes();
    private static boolean initThread = false;

    // private static String logMessage = "";
    // private final static String logPath = ".\\data\\configuration_data\\logs";
    // private final static String fileName = "logs";
    // private final static String fileFormat = ".txt";
    // private static boolean log.getCanReadFile() = false;
    // private static String oldMessage = "[DEBUG] INITIALIZING APP....";
    private static void init() {
        if (!initThread) {
            initThread = !initThread;
            thread.setThread(new Thread(new Log()));
            thread.getThread().start();
        }
    }

    /**
     * Verify If the file was created
     * if true, it will recover the old information in the file and merge with the
     * new
     * if false, it will overlay the old information
     */
    private static void verifiyIfFileWasCreated() {
        if (log.isCanReadFile() == false && log.getOldMessage().equals("[DEBUG] INITIALIZING APP....\n")) {
            log.setCanReadFile(true);
        } else {
            log.setOldMessage(readFile());
        }
    }

    private static String readFile() {
        File filePath = file.createDiretoryPath(log.getLogPath());
        final FileReader fileReader = file.getFileReader(filePath, "\\" + log.getFileName() + log.getFileFormat());
        final BufferedReader lineReader = file.getBufferedReader(fileReader);
        String currentLine = "";
        String logMessage = "";
        try {
            while ((currentLine = lineReader.readLine()) != null) {
                logMessage += currentLine + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logMessage;
    }

    private static void createLogFile(String message) {
        verifiyIfFileWasCreated();
        File filePath = file.createDiretoryPath(log.getLogPath());
        file.createFile(log.getFileName(), log.getOldMessage() + message, filePath, log.getFileFormat());
    }

    public static void info(String message) {
        final String type = "[INFO] ";
        addMessage(type, message);
    }

    public static void warning(String message) {
        final String type = "[WARNING] ";
        addMessage(type, message);
    }

    public static void error(Exception exception, String message) {
        final String type = "[ERROR] ";
        message = type + message + "\nException Details: " + exception.getMessage();
        addMessage(type, message);
    }

    private static void addMessage(String messageType, String message) {
        log.setLogMessage(messageType + message);
        init();
        thread.startWork();
    }

    @Override
    public void run() {
        while (true) {
            while (thread.isThreadHasSuspended()) {
                it.animate(100);
            }
            threadWork();
        }
    }

    private void threadWork() {
        createLogFile(log.getLogMessage());
        thread.stopWork();
    }

}

@Getter
@Setter
class LogAttributes {
    private String logMessage = "";
    private final String logPath = ".\\data\\configuration_data\\logs";
    private final String fileName = "logs";
    private final String fileFormat = ".txt";
    private boolean CanReadFile = false;
    private String oldMessage = "[DEBUG] INITIALIZING APP....\n";
}
