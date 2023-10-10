package resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

final class Arquivos {
    void criarArquivo(String nome, String conteudo, File pasta) {
        try (FileWriter arquivo = new FileWriter(
                pasta + File.separator + nome.toLowerCase() + ".txt")) {
            arquivo.write(conteudo);
            System.out.println(nome.toUpperCase() + " criado com sucesso!");
        } catch (Exception e) {
        }
    }

    String pathEstudante(String nome) {
        return ".\\dados\\dados_estudante\\" + nome;
    }

    String pathDocente(String nome) {
        return ".\\dados\\dados_docente\\" + nome;
    }

    /**
     * Este método cria um objecto que permite manipular arquivos
     * de um diretório específico
     */
    File diretorio(String caminho) {
        File pasta = new File(caminho);
        /**
         * Verifica se a pasta com o nome específico(seja docente ou estudante)
         * Esxiste no diretório, caso não exista...a pasta será criada
         */
        if (!pasta.exists()) {
            pasta.mkdirs();
        }
        return pasta;
    }

    String lerArquivo(int i, File diretorio, String arquivo) {
        String dados = "";
        try (FileReader leitorArquivo = new FileReader(diretorio + arquivo)) {
            BufferedReader leitorLinha = new BufferedReader(leitorArquivo);
            String linha = "";
            if (i == 1) {
                linha = leitorLinha.readLine();
            } else if (i > 1) {
                for (int j = 1; j <= i; j++) {
                    linha = leitorLinha.readLine();
                }
            }
            StringBuilder content = new StringBuilder();
            content.append(linha);

            dados = content.toString();
        } catch (Exception e) {
        }
        return dados;
    }

    int contadorLinha(File diretorio, String arquivo, String tipo) {
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
// String caminho = "\n\"nome\":";
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
// dados += caminho + dadoEstudante;
// System.out.println(linha.indexOf(":"));
// }
//
// } catch (Exception e) {
// }
// dados += caminho + nome + "/" + i;
// arquivo.criarArquivo("log_estudantes", dados, arquivo.diretorio(".\\dados"));
// }