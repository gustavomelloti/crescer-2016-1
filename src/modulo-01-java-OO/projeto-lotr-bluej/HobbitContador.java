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
}
