package resources.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public final class Archive {
    /**
     * Creates a file, nothing else to say LOL
     * 
     * @param fileName    The name of the file
     * @param fileContent The content that have to be put IN THE FILE
     * @param filePath    The path to create the file
     * @see #insertFileFormatAndName
     * @see #createDiretoryPath
     */
    public void createFile(String fileName, String fileContent, File filePath) {
        fileName = insertFileFormatAndName(fileName, ".txt");
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
     * Returns the path of a specified a student data
     * 
     * @param studentName The Student name
     * @return The Path that contains the student data
     */
    public String getStudentPath(String studentName) {
        return ".\\data\\student_data\\" + studentName.toLowerCase();
    }

    /**
     * Returns the path of a specified teacher data
     * 
     * @param teacherName The teacher name
     * @return Teacher path that contains his data
     */
    public String getTeacherPath(String teacherName) {
        return ".\\data\\teacher_data\\" + teacherName.toLowerCase();
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
     * Load And reads the file line By line
     *
     * @param lineSkipper times to skip the lines that was already read
     * @param filePath    the path of the file to be read
     * @param fileName    the name of the file to be read
     * @throws IOException
     * @return A single line of the file content
     * @see #stringBuilder
     */
    public String loadAndReadFile(int lineSkipper, File filePath, String fileName) {
        String fileContent = "";
        try (FileReader fileReader = new FileReader(filePath + fileName)) {
            BufferedReader lineReader = new BufferedReader(fileReader);
            String currentLine = "";
            if (lineSkipper == 1) {
                currentLine = lineReader.readLine();
            } else if (lineSkipper > 1) {
                for (int i = 1; i <= lineSkipper; i++) {
                    currentLine = lineReader.readLine();
                }
            }
            fileContent = stringBuilder(currentLine);
        } catch (Exception e) {
        }
        return fileContent;
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

    public int contadorLinha(File diretorio, String arquivo, String tipo) {
        int contador = 0;
        try (FileReader leitorArquivo = new FileReader(diretorio + arquivo)) {
            String linha = "";
            BufferedReader leitorLinha = new BufferedReader(leitorArquivo);
            switch (tipo) {
                case "log":
                    leitorLinha.readLine();
                    break;
            }
            while ((linha = leitorLinha.readLine()) != null) {
                contador++;
            }
        } catch (Exception e) {
        }
        return contador;
    }
}

// /**
// * Este método serve para registrar o nome e a posição em que o estudante
// ocupou
// * na array "Estudante
// */
// protected static void estudanteSavePoint(String nome, int i) {
// String path = "\n\"nome\":";
// dados = "";

// /**
// * Este Método lê o arquivo
// */
// try (FileReader leitorArquivo = new FileReader(arquivo.diretorio(".\\dados")
// + "\\log_estudantes.txt")) {
// /**
// * O leitorLinha serve para ler cada linha no arquivo
// */
// BufferedReader leitorLinha = new BufferedReader(leitorArquivo);
// String dadoEstudante = "";
// String linha;
// leitorLinha.readLine();
// while ((linha = leitorLinha.readLine()) != null) {
// /**
// * Insere a linha lida para a StringBuilder "content"
// */
// StringBuilder content = new StringBuilder();
// content.append(linha);

// /**
// * a StringBuilder é transformada em string e ao mesmo tempo ele é feito
// * a substring onde o primeiro índice é onde aparece o ":"
// */
// dadoEstudante = content.toString().substring(linha.indexOf(":") + 1);
// loadEstudante(dadoEstudante);
// dados += path + dadoEstudante;
// System.out.println(linha.indexOf(":"));
// }
//
// } catch (Exception e) {
// }
// dados += path + nome + "/" + i;
// arquivo.criarArquivo("log_estudantes", dados, arquivo.diretorio(".\\dados"));
// }