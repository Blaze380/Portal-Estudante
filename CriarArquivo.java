import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class CriarAquivo {
    public static void main(String[] args) {

        // CRIADOR DE ARQUIVO:
        // DADOS PESSOAIS:
        int estudanteNr = 2;
        String nome = "Niuro";
        int idade = 18;

        // CAMINHO DA PASTA:
        String caminho = ".\\data"; // as duas "\\",serve para adicionar uma "\" sem quebrar linha
        File pasta = new File(caminho);
        // pasta.mkdir(); , Este método serve para criar pasta

        // FORMATAÇÃO PRA FAKE-Json
        String dados = "\"Nome:\" " + nome + "\n\"Idade:\" " + idade + "\n\"Nº Estudante:\" " + estudanteNr;

        /**
         * CRIA O ARQUIVO COM O NOME DA PESSOA COM FORMATO ".txt" E ESCREVE NELE OS
         * DADOS
         */
        try (FileWriter arquivo = new FileWriter(pasta + File.separator + nome.toLowerCase() + ".txt")) {

            /**
             * Adiciona a String ao arquivo
             */
            arquivo.write(dados);
            System.out.println("Arquivo Criado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        /// LEITOR DE ARQUIVO:
        /**
         * O "leitorArquivo", serve para localizar e carregar o arquivo para
         * consequentemento ser adicionado à um BufferedReader
         */
        try (FileReader leitorArquivo = new FileReader(caminho + "\\" + nome + ".txt")) {

            /**
             * O "leitorLinha", serve para ler cada linha do arquivo
             */
            BufferedReader leitorLinha = new BufferedReader(leitorArquivo);

            /**
             * Esta String irá servir para armazenar cada linha que o método "readLine()"
             * irá lhe atribuir
             */
            String linha;
            StringBuilder content = new StringBuilder();

            /**
             * Em cada linha,tem que fazer a conversão apropriada, a var "linha" está comoum
             * objecto
             */
            while ((linha = leitorLinha.readLine()) != null) {

                content.append(linha);
            }
            // Transforma em string
            String dadosEstudante = content.toString();
        } catch (Exception e) {
        }
    }
}