import java.util.*;

public class HobbitContador
{
    public int calcularDiferenca(ArrayList<ArrayList<Integer>> arrayDePares)
    {
        int resultado = 0, mmc, valorA, valorB;
      
        for(ArrayList<Integer> pares: arrayDePares)
        {
            mmc = valorA = pares.get(0); valorB = pares.get(1);
          
            while ( (mmc % valorA != 0) || (mmc % valorB != 0) )
                 mmc++;

            resultado+= (valorA * valorB) - mmc;
        }
        
        return resultado;
    }
    
    public int obterMaiorMultiploDeTresAte(int limite)
    {
        /*
          ArrayList<Integer> multiplos = new ArrayList<>(Arrays.asList(0)); 
          for (int i = 1; i <= limite; i++) {
                  if (i % 3 == 0) {
                      multiplos.add(i);
                      continue;
                  }
              }
            
           return multiplos;
              
              1) o método utilizava um arraylist para guardar os múltiplos, totalmente desnecessário
              porque o método deve retornar somente o inteiro
         
              2) método utilizava variável limite que não foi declarada
         
              3) método definia o retorno de um inteiro e retornava um arrayList
        */
       
        int multiploMaior = 0;
        
        for (int i = limite; i >= 3; i--) {
            if (i % 3 == 0) {
                multiploMaior = i / 3;
                break;
          }
      }
    
      return multiploMaior;
    }
    
    public ArrayList<Integer> obterMultiplosDeTresAte(int limite)
    {
        /*
        public ArrayList<Integer> obterMultiplosDeTresAte(int numero)
        {
              ArrayList<Integer> multiplos = new ArrayList<>(Arrays.asList(0));
            
              for (int i = 1; i <= limite; i++) {
                  if (i % 3 == 0) break;
                  multiplos.add(i);
              }
            
              return multiplos;
        }
        
        1) Altera o nome do valor limite informado por parâmetro
     
        2) Retira o break
        
         */
       
        ArrayList<Integer> multiplos = new ArrayList<>(Arrays.asList(0));
        
        for (int i = 1; i <= limite; i++) {
            if (i % 3 == 0)
                multiplos.add(i);
        }
        
        return multiplos;
    }
}
