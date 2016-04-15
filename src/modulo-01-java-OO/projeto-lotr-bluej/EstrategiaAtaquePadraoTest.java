import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaAtaquePadraoTest
{
    @Test
    public void exercitoDeUmElfoVerdeAtacaHordaUmDwarf()
    {
        Dwarf dwarf = new Dwarf("Alvo");
        HordaDwarfs horda = new HordaDwarfs();
        horda.adicionar(dwarf);
        ElfoVerde elfo = new ElfoVerde("Green");
        ExercitoElfos exercito = new ExercitoElfos();
        exercito.alistar(elfo);
        exercito.setEstrategia(new EstrategiaAtaquePadrao());
        exercito.atacar(horda);
        assertEquals(41, elfo.getFlechas());
        assertTrue(100.00 == dwarf.getQtdVida());
    }
    
    @Test
    public void exercitoVazioAtacandoHordaSemDwarfs()
    {
        Dwarf dwarf = new Dwarf("Alvo");
        HordaDwarfs horda = new HordaDwarfs();
        horda.adicionar(dwarf);
        ExercitoElfos exercito = new ExercitoElfos();
        exercito.setEstrategia(new EstrategiaAtaquePadrao());
        exercito.atacar(horda);
        assertTrue(110.00 == dwarf.getQtdVida());
    }
    
    @Test
    public void exercitoAtacandoHordaDwarfs()
    {
        HordaDwarfs horda = new HordaDwarfs();
        ElfoVerde elfo = new ElfoVerde("Green");
        ExercitoElfos exercito = new ExercitoElfos();
        exercito.alistar(elfo);
        exercito.setEstrategia(new EstrategiaAtaquePadrao());
        exercito.atacar(horda);
        assertEquals(42, elfo.getFlechas());
    }

    @Test
    public void comparandoOrdemUltimoAtaqueDeExercitoComUmElfo()
    {
        Dwarf dwarf = new Dwarf("Alvo");
        HordaDwarfs horda = new HordaDwarfs();
        horda.adicionar(dwarf);
        ElfoVerde elfo = new ElfoVerde("Green");
        ExercitoElfos exercito = new ExercitoElfos();
        exercito.alistar(elfo);
        exercito.setEstrategia(new EstrategiaAtaquePadrao());
        exercito.atacar(horda);
        assertTrue(elfo.equals(exercito.getEstrategiaAtaque().getOrdemUltimoAtaque().get(0))); 
    }
    
    @Test
    public void comparandoOrdemUltimoAtaqueDeExercitoComTresNoturnoEUmVerde()
    {
        HordaDwarfs horda = new HordaDwarfs();
        horda.adicionar(new Dwarf("Alvo"));
        horda.adicionar(new Dwarf("Alvo 2"));

        ExercitoElfos exercito = new ExercitoElfos();
        ElfoVerde verde = new ElfoVerde("Green");
        ElfoNoturno noturno1 = new ElfoNoturno("Noturno 1");
        ElfoNoturno noturno2 = new ElfoNoturno("Noturno 2");
        ElfoNoturno noturno3 = new ElfoNoturno("Noturno 3");
        
        exercito.alistar(verde);
        exercito.alistar(noturno1);
        exercito.alistar(noturno2);
        exercito.alistar(noturno3);
        
        exercito.setEstrategia(new EstrategiaAtaquePadrao());
        exercito.atacar(horda);
    
        assertTrue(exercito.getEstrategiaAtaque().getOrdemUltimoAtaque().contains(verde)); 
        assertTrue(exercito.getEstrategiaAtaque().getOrdemUltimoAtaque().contains(noturno1)); 
        assertTrue(exercito.getEstrategiaAtaque().getOrdemUltimoAtaque().size() == 2); 
    }
    
    @Test
    public void ataqueDeExercitoComTresNoturnoEUmVerdeEmHordaDeDoisElfos()
    {
        HordaDwarfs horda = new HordaDwarfs();
        horda.adicionar(new Dwarf("Alvo"));
        horda.adicionar(new Dwarf("Alvo 2"));

        ExercitoElfos exercito = new ExercitoElfos();
        ElfoVerde verde = new ElfoVerde("Green");
        ElfoNoturno noturno1 = new ElfoNoturno("Noturno 1");
        ElfoNoturno noturno2 = new ElfoNoturno("Noturno 2");
        ElfoNoturno noturno3 = new ElfoNoturno("Noturno 3");
        
        exercito.alistar(verde);
        exercito.alistar(noturno1);
        exercito.alistar(noturno2);
        exercito.alistar(noturno3);
        
        exercito.setEstrategia(new EstrategiaAtaquePadrao());
        exercito.atacar(horda);
    
        assertEquals(40, verde.getFlechas()); 
        assertEquals(40, noturno1.getFlechas()); 
        assertEquals(42, noturno2.getFlechas());
        assertEquals(42, noturno3.getFlechas());
         
        assertTrue(90.00 == horda.gethorda().get(0).getQtdVida()); 
        assertTrue(90.00 == horda.gethorda().get(1).getQtdVida()); 
    }
    
    @Test
    public void ataqueDeExercitoComCincoVerdesEDoisNoturnosEmHordaDeDoisElfos()
    {
        HordaDwarfs horda = new HordaDwarfs();
        horda.adicionar(new Dwarf("Alvo"));
        horda.adicionar(new Dwarf("Alvo 2"));

        ExercitoElfos exercito = new ExercitoElfos();
        
        ElfoVerde verde1 = new ElfoVerde("Green 1");
        ElfoVerde verde2 = new ElfoVerde("Green 2");
        ElfoVerde verde3 = new ElfoVerde("Green 3");
        ElfoVerde verde4 = new ElfoVerde("Green 4");
        ElfoVerde verde5 = new ElfoVerde("Green 5");
        
        ElfoNoturno noturno1 = new ElfoNoturno("Noturno 1");
        ElfoNoturno noturno2 = new ElfoNoturno("Noturno 2");
        
        exercito.alistar(verde1);
        exercito.alistar(verde2);
        exercito.alistar(verde3);
        exercito.alistar(verde4);
        exercito.alistar(verde5);
        
        exercito.alistar(noturno1);
        exercito.alistar(noturno2);
        
        exercito.setEstrategia(new EstrategiaAtaquePadrao());
        exercito.atacar(horda);
    
        assertEquals(40, verde1.getFlechas());
        assertEquals(40, verde2.getFlechas()); 
        assertEquals(40, verde3.getFlechas()); 
        assertEquals(40, verde4.getFlechas()); 
        assertEquals(40, verde5.getFlechas()); 
        assertEquals(40, noturno1.getFlechas());
        assertEquals(40, noturno2.getFlechas());
         
        assertTrue(40.00 == horda.gethorda().get(0).getQtdVida()); 
        assertTrue(40.00 == horda.gethorda().get(1).getQtdVida()); 
    }
}