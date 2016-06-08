package br.com.crescer.aula2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Run {
    
    public static String formatarData(Calendar c) {
        SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
        return simple.format(c);
    }
  
    public static void main(String[] args) {
        String nome = "Gustavo";
        String caminho  = "//10.0.100.102/cwitmp/carloshenrique/crescer.txt";
        Chat chat = new Chat(caminho);
        chat.exibirMensagens();
        
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String mensagemDigitada = scanner.nextLine();
            if (mensagemDigitada.trim().length() != 0) {
                chat.cadastrarMensagem(
                    String.format(
                        "%s (%s) : %s",
                        nome,
                        new SimpleDateFormat("dd/MM/yyyy HH:mm").format(Calendar.getInstance().getTime()),
                        mensagemDigitada
                    )
                );                    
            } 
        }
    }
}
