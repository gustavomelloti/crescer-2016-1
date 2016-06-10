package FilesUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunWriter {
     public static void main(String[] args) {
        try {
            Scanner c = new Scanner(System.in);
            MeuWriterUtils writerUtil = new MeuWriterUtils();
            List<String> conteudo = new ArrayList<>();
            System.out.print("Informe o arquivo desejado: ");
            String arquivo = c.nextLine();
            String conteudoDaLinha = "";
            System.out.print("Digite abaixo as linhas do arquivo, separando-as pela tecla ENTER. Para encerrar a escrita digite . (PONTO FINAL).");          
            conteudoDaLinha = c.nextLine();
            while(!conteudoDaLinha.equals(".")) {
                conteudo.add(conteudoDaLinha);
                conteudoDaLinha = c.nextLine();
            }
            writerUtil.escreverConteudo(arquivo, conteudo);
        } catch(FileNotFoundException e) {
            System.out.print("Arquivo não encontrado.");
        } catch (IllegalArgumentException e) {
            System.out.print("Somente arquivos .txt são aceitos.");
        } catch (IOException e) {
            System.out.print("Erro ao realizar leitura.");
        }
    }
}
