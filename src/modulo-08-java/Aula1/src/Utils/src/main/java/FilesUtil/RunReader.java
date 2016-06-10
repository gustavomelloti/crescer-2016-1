package FilesUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class RunReader {
    public static void main(String[] args) {
        try {
            Scanner c = new Scanner(System.in);
            MeuReaderUtils readerUtil = new MeuReaderUtils();
            System.out.print("Informe o arquivo desejado: ");
            readerUtil.exibirConteudo(c.nextLine());
        } catch(FileNotFoundException e) {
            System.out.print("Arquivo não encontrado.");
        } catch (IllegalArgumentException e) {
            System.out.print("Somente arquivos .txt são aceitos.");
        } catch (IOException e) {
            System.out.print("Erro ao realizar leitura.");
        }
    }
}
