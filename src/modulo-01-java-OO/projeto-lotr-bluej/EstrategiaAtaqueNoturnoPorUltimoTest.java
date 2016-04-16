import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EstrategiaAtaqueNoturnoPorUltimoTest
{
    @Test
    public void verificarPosicaoAtaqueElfosNoturnosEVerdesEmbaralhados() throws NaoPodeAlistarException
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
        exercito.alistar(noturno1);
        exercito.alistar(verde4);
        exercito.alistar(verde5);
        exercito.alistar(noturno2);

        exercito.setEstrategia(new EstrategiaAtaqueNoturnoPorUltimo());
        exercito.atacar(horda);
    
        assertTrue(noturno1.equals(exercito.getEstrategiaAtaque().getOrdemUltimoAtaque().get(5))); 
        assertTrue(noturno2.equals(exercito.getEstrategiaAtaque().getOrdemUltimoAtaque().get(6))); 
    }
    
    @Test
    public void exercitoDeUmElfoVerdeAtacaHordaUmDwarf() throws NaoPodeAlistarException
    {
        Dwarf dwarf = new Dwarf("Alvo");
        HordaDwarfs horda = new HordaDwarfs();
        horda.adicionar(dwarf);
        ElfoVerde elfo = new ElfoVerde("Green");
        ExercitoElfos exercito = new ExercitoElfos();
        exercito.alistar(elfo);
        exercito.setEstrategia(new EstrategiaAtaqueNoturnoPorUltimo());
        exercito.atacar(horda);
        assertEquals(41, elfo.getFlechas());
        assertTrue(100.00 == dwarf.getQtdVida());
    }
    
    @Test
    public void verificarAtaqueSoDeElfosNoturnos() throws NaoPodeAlistarException
    {
        HordaDwarfs horda = new HordaDwarfs();
        horda.adicionar(new Dwarf("Alvo"));
        horda.adicionar(new Dwarf("Alvo 2"));
        horda.adicionar(new Dwarf("Alvo 3"));

        ExercitoElfos exercito = new ExercitoElfos();

        ElfoNoturno noturno1 = new ElfoNoturno("Noturno 1");
        ElfoNoturno noturno2 = new ElfoNoturno("Noturno 2");
        ElfoNoturno noturno3 = new ElfoNoturno("Noturno 3");

        exercito.alistar(noturno1);
        exercito.alistar(noturno2);
        exercito.alistar(noturno3);
        
        exercito.setEstrategia(new EstrategiaAtaqueNoturnoPorUltimo());
        exercito.atacar(horda);
    
        assertEquals(39, noturno1.getFlechas());
        assertEquals(39, noturno2.getFlechas());
        assertEquals(39, noturno3.getFlechas());
        
        assertTrue(exercito.getEstrategiaAtaque().getOrdemUltimoAtaque().contains(noturno1)); 
        assertTrue(exercito.getEstrategiaAtaque().getOrdemUltimoAtaque().contains(noturno2)); 
        assertTrue(exercito.getEstrategiaAtaque().getOrdemUltimoAtaque().contains(noturno3));

        assertTrue(80.00 == horda.gethorda().get(0).getQtdVida());
        assertTrue(80.00 == horda.gethorda().get(1).getQtdVida());
        assertTrue(80.00 == horda.gethorda().get(2).getQtdVida());
    }
    
    @Test
    public void exercitoVazioAtacandoHordaSemDwarfs()
    {
        Dwarf dwarf = new Dwarf("Alvo");
        HordaDwarfs horda = new HordaDwarfs();
        horda.adicionar(dwarf);
        ExercitoElfos exercito = new ExercitoElfos();
        exercito.setEstrategia(new EstrategiaAtaqueNoturnoPorUltimo());
        exercito.atacar(horda);
        assertTrue(110.00 == dwarf.getQtdVida());
    }
    
    @Test
    public void verificarPosicaoAtaqueElfosNoturnosEVerdesOrdemInversa() throws NaoPodeAlistarException
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
        
        exercito.alistar(noturno1);
        exercito.alistar(noturno2);
        exercito.alistar(verde1);
        exercito.alistar(verde2);
        exercito.alistar(verde3);
        exercito.alistar(verde4);
        exercito.alistar(verde5);
       
        exercito.setEstrategia(new EstrategiaAtaqueNoturnoPorUltimo());
        exercito.atacar(horda);
    
        assertTrue(noturno1.equals(exercito.getEstrategiaAtaque().getOrdemUltimoAtaque().get(5))); 
        assertTrue(noturno2.equals(exercito.getEstrategiaAtaque().getOrdemUltimoAtaque().get(6))); 
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
        
        exercito.setEstrategia(new EstrategiaAtaqueNoturnoPorUltimo());
        exercito.atacar(horda);
  
        assertTrue(40.00 == horda.gethorda().get(0).getQtdVida()); 
        assertTrue(40.00 == horda.gethorda().get(1).getQtdVida());
        assertTrue(noturno1.equals(exercito.getEstrategiaAtaque().getOrdemUltimoAtaque().get(5))); 
        assertTrue(noturno2.equals(exercito.getEstrategiaAtaque().getOrdemUltimoAtaque().get(6))); 
    }
}
