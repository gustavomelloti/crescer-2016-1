import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaAtaqueIntercaladoTest
{
    
    @Test
    public void ataqueIntercaladoComDoisElfosVerdeEDoisNoturnos()
    {
        HordaDwarfs horda = new HordaDwarfs();
        horda.adicionar(new Dwarf("Alvo"));
        horda.adicionar(new Dwarf("Alvo 2"));

        ExercitoElfos exercito = new ExercitoElfos();
        
        ElfoVerde verde1 = new ElfoVerde("Vd 1");
        ElfoVerde verde2 = new ElfoVerde("verde2");
        ElfoNoturno noturno1 = new ElfoNoturno("Noturno 1");
        ElfoNoturno noturno2 = new ElfoNoturno("Nt 3");
        
        exercito.alistar(verde1);
        exercito.alistar(noturno1);
        exercito.alistar(verde2);
        exercito.alistar(noturno2);
        exercito.setEstrategia(new EstrategiaAtaqueIntercalado());
        exercito.atacar(horda);
        
        ArrayList<Elfo> ordem = exercito.getEstrategiaAtaque().getOrdemUltimoAtaque();
        assertTrue(noturno1.equals(ordem.get(0)));
        assertTrue(verde1.equals(ordem.get(1)));
        assertTrue(noturno2.equals(ordem.get(2)));
        assertTrue(verde2.equals(ordem.get(3)));
        
        assertEquals(40, verde1.getFlechas());
        assertEquals(40, verde2.getFlechas());
        assertEquals(40, noturno1.getFlechas());
        assertEquals(40, noturno2.getFlechas());
        
        assertTrue(70.00 == horda.gethorda().get(0).getQtdVida());
        assertTrue(70.00 == horda.gethorda().get(1).getQtdVida());
    }
    
    @Test
    public void ataqueIntercaladoComDoisElfosVerde()
    {
        HordaDwarfs horda = new HordaDwarfs();
        horda.adicionar(new Dwarf("Alvo"));
        horda.adicionar(new Dwarf("Alvo 2"));

        ExercitoElfos exercito = new ExercitoElfos();
        
        ElfoVerde verde1 = new ElfoVerde("adasjoidjoi");
        ElfoVerde verde2 = new ElfoVerde("Green 123");
        
        exercito.alistar(verde1);
        exercito.alistar(verde2);
        exercito.setEstrategia(new EstrategiaAtaqueIntercalado());
        exercito.atacar(horda);
        
        ArrayList<Elfo> ordem = exercito.getEstrategiaAtaque().getOrdemUltimoAtaque();
        assertEquals(42, verde1.getFlechas());
        assertEquals(42, verde2.getFlechas());
    }
    
    @Test
    public void ataqueIntercaladoComDoisElfosVerdeEDoisNoturnosExercitoDesordenado()
    {
        HordaDwarfs horda = new HordaDwarfs();
        horda.adicionar(new Dwarf("Alvo"));
        horda.adicionar(new Dwarf("Alvo 2"));

        ExercitoElfos exercito = new ExercitoElfos();
        
        ElfoVerde verde1 = new ElfoVerde("Vd 1");
        ElfoVerde verde2 = new ElfoVerde("verde2");
        ElfoNoturno noturno1 = new ElfoNoturno("Noturno 1");
        ElfoNoturno noturno2 = new ElfoNoturno("Nt 3");
        exercito.alistar(noturno1);
        exercito.alistar(noturno2);
        exercito.alistar(verde1);
        exercito.alistar(verde2);
        
        exercito.setEstrategia(new EstrategiaAtaqueIntercalado());
        exercito.atacar(horda);
        
        ArrayList<Elfo> ordem = exercito.getEstrategiaAtaque().getOrdemUltimoAtaque();
        assertTrue(noturno1.equals(ordem.get(0)));
        assertTrue(verde1.equals(ordem.get(1)));
        assertTrue(noturno2.equals(ordem.get(2)));
        assertTrue(verde2.equals(ordem.get(3)));
        
        assertEquals(40, verde1.getFlechas());
        assertEquals(40, verde2.getFlechas());
        assertEquals(40, noturno1.getFlechas());
        assertEquals(40, noturno2.getFlechas());
        
        assertTrue(70.00 == horda.gethorda().get(0).getQtdVida());
        assertTrue(70.00 == horda.gethorda().get(1).getQtdVida());
    }
}
