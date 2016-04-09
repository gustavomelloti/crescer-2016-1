import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class HobbitContadorTest
{
    @Test
    public void tresParesEDeveRetornar840()
    {
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(15, 18)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(4, 5)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(12, 60)));
        
        HobbitContador contador = new HobbitContador();
        int obitdo = contador.calcularDiferenca(arrayDePares);
        
        assertEquals(840, obitdo);
    }
    
    @Test
    public void passandoUmPar()
    {
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(6, 4)));
        
        HobbitContador contador = new HobbitContador();
        int obitdo = contador.calcularDiferenca(arrayDePares);
        
        assertEquals(12, obitdo);
    }
    
    public void passandoArrayVazio()
    {
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();        
        HobbitContador contador = new HobbitContador();
        
        int obitdo = contador.calcularDiferenca(arrayDePares);
        
        assertEquals(0, obitdo);
    }
    
    
}
