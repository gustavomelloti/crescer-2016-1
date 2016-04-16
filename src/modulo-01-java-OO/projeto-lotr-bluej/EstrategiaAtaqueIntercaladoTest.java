import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaAtaqueIntercaladoTest
{
    
    @Test
    public void ataqueIntercaladoComDoisElfosVerdeEDoisNoturnos() throws NaoPodeAlistarException
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
    public void ataqueIntercaladoComDoisElfosVerde() throws NaoPodeAlistarException
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
    public void ataqueIntercaladoComDoisElfosVerdeEDoisNoturnosExercitoDesordenado() throws NaoPodeAlistarException
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
    
    @Test
    public void ataqueDeExercitoComCincoVerdesEhDoisNoturnosVivosETresMortosEmHordaDeDoisElfos() throws NaoPodeAlistarException
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
        ElfoNoturno noturno3 = new ElfoNoturno("Noturno 3");
        ElfoNoturno noturno4 = new ElfoNoturno("Noturno 4");
        ElfoNoturno noturno5 = new ElfoNoturno("Noturno 5");
        
        Dwarf d = new Dwarf("Alvo3");
        for (int i = 0; i < 90; i++)
        {
            noturno3.atirarFlechaEmDwarf(d);
            noturno4.atirarFlechaEmDwarf(d);
            noturno5.atirarFlechaEmDwarf(d);
        }
        
        exercito.alistar(verde1);
        exercito.alistar(verde2);
        exercito.alistar(verde3);
        exercito.alistar(verde4);
        exercito.alistar(verde5);
        
        exercito.alistar(noturno1);
        exercito.alistar(noturno2);
        exercito.alistar(noturno3);
        exercito.alistar(noturno4);
        exercito.alistar(noturno5);
        
        exercito.setEstrategia(new EstrategiaAtaqueIntercalado());
        exercito.atacar(horda);
        assertTrue(exercito.getEstrategiaAtaque().getOrdemUltimoAtaque().size() == 0);
    }
    
    @Test
    public void ataqueDeExercitoComCincoVerdesECincoNoturnossEmHordaDeDoisElfos() throws NaoPodeAlistarException
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
        ElfoNoturno noturno3 = new ElfoNoturno("Noturno 3");
        ElfoNoturno noturno4 = new ElfoNoturno("Noturno 4");
        ElfoNoturno noturno5 = new ElfoNoturno("Noturno 5");

        exercito.alistar(verde1);
        exercito.alistar(verde2);
        exercito.alistar(verde3);
        exercito.alistar(verde4);
        exercito.alistar(verde5);
        
        exercito.alistar(noturno1);
        exercito.alistar(noturno2);
        exercito.alistar(noturno3);
        exercito.alistar(noturno4);
        exercito.alistar(noturno5);
        
        exercito.setEstrategia(new EstrategiaAtaqueIntercalado());
        exercito.atacar(horda);
        
        boolean ordemCorreta = true;
        
        for (int i = 0; i < exercito.getEstrategiaAtaque().getOrdemUltimoAtaque().size() -1; i++)
        {
            if (i == 0 || i % 2 == 0)
            {
                if (! (exercito.getEstrategiaAtaque().getOrdemUltimoAtaque().get(i) instanceof ElfoNoturno))
                    ordemCorreta = false;
            }
            else
            {
                if (! (exercito.getEstrategiaAtaque().getOrdemUltimoAtaque().get(i) instanceof ElfoVerde))
                    ordemCorreta = false;
            }
        }
        
        assertTrue(ordemCorreta);
    }
}
