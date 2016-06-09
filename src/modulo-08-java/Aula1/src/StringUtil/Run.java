package StringUtil;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner teclado = null;
        MeuStringUtil stringUtil = null;
        try {
            teclado = new Scanner(System.in);
            stringUtil = new MeuStringUtil();
            
            System.out.println("---------Utilização de recursos------- \n");
            
            System.out.println("Utilização do método isEmpty:");
            System.out.print("Digite a String desejada: ");
            System.out.print("Resultado: " + stringUtil.isEmpty(teclado.nextLine()));
            
            System.out.println("\nUtilização do método lengthVogais:");
            System.out.print("Digite a String desejada: ");
            System.out.print("Resultado: " + stringUtil.lengthVogais(teclado.nextLine()));
            
            System.out.println("\nUtilização do método reverse:");
            System.out.print("Digite a String desejada: ");
            System.out.print("Resultado: " + stringUtil.reverse(teclado.nextLine()));
            
            System.out.println("\nUtilização do método isPalindromo:");
            System.out.print("Digite a String desejada: ");
            System.out.print("Resultado: " + stringUtil.isPalindromo(teclado.nextLine()));
            
        } catch(Exception e) {
            System.out.println("Erro ao realizar operação.");
        } finally {
            if (teclado != null) {
                teclado.close();
            }    
        }
    }
}
