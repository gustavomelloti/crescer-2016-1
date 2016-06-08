package exercicio1;

import java.util.Arrays;
import java.util.Comparator;

public class Exercicio3 {
    public static void main(String[] args) {
        StringBuilder builder =  new StringBuilder();
        Estados[] estadosEmArray = Estados.values();
        ordenarEstados(estadosEmArray);

        for (Estados e : estadosEmArray) {
            builder.append(e.getNome()).append(", ");
        }
        
        System.out.println(removeLastChar(builder.toString()));
    }
    
    public static void ordenarEstados(Estados[] estadosEmArray) {
        Arrays.sort(estadosEmArray, new Comparator<Estados>() {
            @Override
            public int compare(Estados e1, Estados e2) {
                return e1.getNome().compareTo(e2.getNome());
            }
        });
    }
    
    public static String removeLastChar(String str) {
        return str.substring(0,str.length()-1);
    }
}
