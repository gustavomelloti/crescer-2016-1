package exercicio1;

import static java.time.Clock.system;
import java.util.Scanner;

public class Exercicio1 {
    
    public static void main(String[] args) {
        Scanner teclado = null;
        try {
            teclado = new Scanner(System.in);
            System.out.print("Digite o número a ser comparado:");
            System.out.println(teclado.nextInt() % 2 == 0 ? "Par" : "Ímpar" );
        } catch(Exception e) {
            System.out.println("Número digitado deveria ser um inteiro");
        } finally {
            if (teclado != null) {
                teclado.close();
            }    
        }
    }
}
