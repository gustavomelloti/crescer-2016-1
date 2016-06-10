package CalendarUtil;

import Juros.Parcela;
import Juros.Parcelator;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Run {
    public static void main (String[] args) {
        Scanner teclado = null;
        MeuCalendarioUtil calendarioUtil = null;
        
        try {
            teclado = new Scanner(System.in);
            calendarioUtil = new MeuCalendarioUtil();
            
            System.out.println("---------Utilização de recursos------- \n");
            
            System.out.println("Utilização do método dayOfWeek:");
            System.out.println("Digite a data desejada (Ex: 12/04/2016): ");
            System.out.println("Dia da semana: " + calendarioUtil.dayOfWeek(teclado.nextLine()));
            
            System.out.println("Utilização do método elapsedDate:");
            System.out.println("Digite a data desejada (Ex: 12/04/2016): ");
            System.out.println("Dias de diferença: " + calendarioUtil.elapsedDate(teclado.nextLine()));
        } catch(Exception e) {
            System.out.println("Erro ao realizar operação.");
        } finally {
            if (teclado != null) {
                teclado.close();
            }    
        }
    }
}
