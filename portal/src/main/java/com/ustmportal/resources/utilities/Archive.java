package com.ustmportal.resources.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public final class Archive {
    private Properties prop = new Properties();

    /**
     * It allows you to set Properties in the file, before you create it
     * 
     * @param key
     * @param value
     */
    public void setProperties(String key, String value) {
        prop.setProperty(key, value);
    }

    /**
     * It Allows you to acess a specify key value
     * Before acess key values, you have to load a property
     * 
     * @param key
     * @return value of the current key
     * @see #loadProperties
     */
    public String getProperties(String key) {
        String value = prop.getProperty(key);
        return value;
    }

    /**
     * Before acessing the properties, you can use this method to load the property
     * 
     * @param filePath Path of the file that you want to load
     * @param fileName Name of the file That you want to load
     */
    public void loadProperties(String filePath, String fileName) {
        FileInputStream fileIn = createInput(filePath, fileName);
        try {
            prop.load(fileIn);
        } catch (IOException e) {
        }
    }

    /**
     * After adding the properties, you can use this method to save the file
     * 
     * @param filePath        Path of the file that you want to create
     * @param fileName        Name of the file That you want to create
     * @param fileDescription A comment do describe the file(Opcional), you can put
     *                        like this "", if you don't want
     * @see #createOutput
     */
    public void saveProperties(String filePath, String fileName, String fileDescription) {
        FileOutputStream fileOut = createOutput(filePath, fileName);
        try {
            prop.store(fileOut, fileDescription);
            prop.clear();
        } catch (IOException e) {
            // e.printStackTrace();
        }

    }

    /**
     * Creates an Input object that allows you load a ".properties" file
     * 
     * @param filePath Path of the file that you want to load
     * @param fileName Name of the file That you want to load
     * @return FileInputStream Object
     */
    private FileInputStream createInput(String filePath, String fileName) {
        FileInputStream fileInputStream = null;
        fileName = insertFileFormatAndName(fileName, ".properties");
        try {
            fileInputStream = new FileInputStream(filePath + fileName);
        } catch (Exception e) {

        }
        return fileInputStream;
    }

    /**
     * Creates an Output object that allows you creating ".properties" file
     * 
     * @param filePath Path of the file that you want to create
     * @param fileName Name of the file That you want to create
     * @return FileOutputStream Object
     */
    private FileOutputStream createOutput(String filePath, String fileName) {
        FileOutputStream fileOutputStream = null;
        fileName = insertFileFormatAndName(fileName, ".properties");
        try {
            fileOutputStream = new FileOutputStream(filePath + fileName);
        } catch (Exception e) {

        }
        return fileOutputStream;
    }

    /**
     * Creates a file, nothing else to say LOL
     * 
     * @param fileName    The name of the file
     * @param fileContent The content that have to be put IN THE FILE
     * @param filePath    The path to create the file
     * @param fileFormat  The extension of the file, (eg: .json, .properties, .txt)
     * @see #insertFileFormatAndName
     * @see #createDiretoryPath
     */
    public void createFile(String fileName, String fileContent, File filePath, String fileFormat) {

        fileName = insertFileFormatAndName(fileName, fileFormat);
        // Creating the file
        try (FileWriter file = new FileWriter(filePath + File.separator + fileName);) {
            file.write(fileContent);
            System.out.println(fileName.toUpperCase() + " criado com sucesso!");
        } catch (IOException e) {
        }
    }

    /**
     * Returns the concatenation of the file name and the file format in lower case
     * 
     * @param nameOfTheFile Name of the file
     * @param fileFormat    Format of the file to be created
     * @return name of the file concatenated with the file format in lower case
     */
    private String insertFileFormatAndName(String nameOfTheFile, String fileFormat) {
        return (nameOfTheFile + fileFormat).toLowerCase();
    }

    /**
     * Returns the path of a specified a student data to lower case
     * 
     * @param studentUserName The Student username
     * @return The Path that contains the student data
     */
    public String getStudentPath(String studentUserName) {
        return ".\\data\\student_data\\" + studentUserName.toLowerCase();
    }

    /**
     * Returns the path of a specified teacher data to lower case
     * 
     * @param teacherUserName The teacher username
     * @return Teacher path that contains his data
     */
    public String getTeacherPath(String teacherUserName) {
        return ".\\data\\teacher_data\\" + teacherUserName.toLowerCase();
    }

    /**
     * Creates an object containing the path that you want to acess
     * 
     * @param path The Path to acess
     * @return filePath object
     */
    public File createDiretoryPath(String path) {
        File filePath = new File(path);
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        return filePath;
    }

    /**
     * Load And reads the a line By line
     *
     * @param lineSkipper times to skip the lines that was already read
     * @param filePath    the path of the file to be read
     * @param fileName    the name of the file to be read
     * @throws IOException
     * @return A single line of the file content
     * @see #stringBuilder
     * @see #lineCounter
     */
    public String loadAndReadFile(int lineSkipper, File filePath, String fileName) {
        String fileContent = "";
        FileReader fileReader = getFileReader(filePath, fileName);
        BufferedReader lineReader = getBufferedReader(fileReader);
        String currentLine = "";
        try {
            if (lineSkipper == 1) {
                currentLine = lineReader.readLine();
            } else if (lineSkipper > 1) {
                for (int i = 1; i <= lineSkipper; i++) {
                    currentLine = lineReader.readLine();
                }
            }
            fileContent = stringBuilder(currentLine);
        } catch (IOException e) {

        }

        return fileContent;
    }

    /**
     * Returns a FileReader object
     * 
     * @param filePath Path of the file
     * @param fileName Name of the file
     * @return Filereader object
     */
    public FileReader getFileReader(File filePath, String fileName) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filePath + fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fileReader;
    }

    /**
     * Returns a object that reads a file, line by line (BufferedReader)
     * 
     * @param fileReader fileReader Object
     * @return buffered reader object
     */
    public BufferedReader getBufferedReader(FileReader fileReader) {
        return new BufferedReader(fileReader);
    }

    /**
     * Receives the line read by the "BufferedReader" and transforms it into a
     * string
     *
     * @param currentlineToString The current line read by BufferedReader
     * @return the line in String type
     * @see #loadAndReadFile
     */
    private String stringBuilder(String currentlineToString) {
        StringBuilder builder = new StringBuilder();
        builder.append(currentlineToString);
        return builder.toString();
    }

    /**
     * Verifies how many lines a file has before read it
     * 
     * @param diretoryPath The path of the file
     * @param fileName     the file name
     * @return number of lines
     */
    public int lineCounter(File diretoryPath, String fileName) {
        int lineCounter = 0;
        try (FileReader fileReader = new FileReader(diretoryPath + fileName)) {
            BufferedReader lineReader = new BufferedReader(fileReader);

            while ((lineReader.readLine()) != null) {
                lineCounter++;
            }
        } catch (Exception e) {
        }
        return lineCounter;
    }
}
