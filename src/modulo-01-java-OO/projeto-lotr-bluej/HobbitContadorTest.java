import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class HobbitContadorTest
{
    @Test
    public void calcularDiferencaComtresPares()
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
    public void calcularDiferencaComUmPar()
    {
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(6, 4)));
        
        HobbitContador contador = new HobbitContador();
        int obitdo = contador.calcularDiferenca(arrayDePares);
        
        assertEquals(12, obitdo);
    }
    
    @Test
    public void calcularDiferencaComArrayVazio()
    {
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();        
        HobbitContador contador = new HobbitContador();
        
        int obitdo = contador.calcularDiferenca(arrayDePares);
        
        assertEquals(0, obitdo);
    }
    
    @Test
    public void calcularDiferencaComParDePrimos()
    {
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(43, 31)));
        
        HobbitContador contador = new HobbitContador();
        int obitdo = contador.calcularDiferenca(arrayDePares);
        
        assertEquals(0, obitdo);
    }
    
    @Test
    public void obterMaiorMultiploDeTresComLimite24()
    {
        HobbitContador c = new HobbitContador();
        assertEquals(8, c.obterMaiorMultiploDeTresAte(24));
    }
    
    @Test
    public void obterMaiorMultiploDeTresComLimite29()
    {
        HobbitContador c = new HobbitContador();
        assertEquals(9, c.obterMaiorMultiploDeTresAte(29));
    }
    
    @Test
    public void obterMultiplosDeTresAte9()
    {
        HobbitContador c = new HobbitContador();
        ArrayList<Integer> multiplos = c.obterMultiplosDeTresAte(9);
        assertTrue(multiplos.get(0) == 0 && multiplos.get(1) == 3 && multiplos.get(2) == 6 && multiplos.get(3) == 9 && multiplos.size() == 4);
    }
    
    @Test
    public void obterMultiplosDeTresAte2()
    {
        HobbitContador c = new HobbitContador();
        ArrayList<Integer> multiplos = c.obterMultiplosDeTresAte(2);
        assertTrue(multiplos.get(0) == 0 && multiplos.size() == 1);
    }
}
