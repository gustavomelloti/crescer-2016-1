package FilesUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class RunFilesUtil {
    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Crescer-Linux. Para encerrar o terminal digite. (PONTO FINAL)");
        
        try {
            MeuFileUtils filesUtils = new MeuFileUtils();
            Scanner c = new Scanner(System.in);
            String comando = c.nextLine();
            while (!comando.equals(".")) {
                String[] comandoEmArray = comando.split(" ");
                switch(comandoEmArray[0]) {
                    case "mk":
                        filesUtils.criar(comandoEmArray[1]);
                    break;
                    case "ls":
                        filesUtils.listar(comandoEmArray[1]);
                    break;
                    case "rm":
                        filesUtils.deletar(comandoEmArray[1]);
                    break;
                    case "mv":
                        filesUtils.mover(comandoEmArray[1], comandoEmArray[2]);
                    break;
                }
                comando = c.nextLine();
            }
        } catch(FileNotFoundException e) {
            System.out.print("Arquivo não encontrado.");
        } catch (IllegalArgumentException e) {
            System.out.print("Você deve informar um arquivo, não um diretório.");
        } catch (IOException e) {
            System.out.print("Erro ao realizar operação.");
        }
    }
}
