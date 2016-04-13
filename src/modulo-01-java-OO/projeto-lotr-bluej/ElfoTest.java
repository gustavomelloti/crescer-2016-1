import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{   
    @After
    public void clear()
    {
        System.gc();
    }
    
    @Test
    public void verificarQuantidadeDeElfosAoCriarUmElfo()
    {
        int qtdElfosAntesDeCriar = Elfo.getContador();
        Elfo f = new Elfo("Gustavo");
        assertEquals(1, Elfo.getContador());
    }
    
    @Test
    public void verificarQuantidadeDeElfosAoCriarUmElfoUmElfoUmElfoVerdeUmElfoNoturno()
    {
        int qtdElfosAntesDeCriar = Elfo.getContador();
        Elfo elfo = new Elfo("Gustavo");
        ElfoVerde verde = new ElfoVerde("Green");
        ElfoNoturno noturno = new ElfoNoturno("Noturno");
        assertEquals(3, Elfo.getContador());
    }
    
    @Test
    public void verificarQuantidadeSemCriarElfo()
    {
        assertEquals(0, Elfo.getContador());
    }
  
    @Test
    public void verificarSePerdeuUmaFlechaAoAtirarFlecha()
    {
        Elfo e = new Elfo("Gustavo");
        int qtdFlechasAntesDeAtirar = e.getFlechas();
        e.atirarFlechaEmDwarf(new Dwarf("Paulo"));
        assertEquals(qtdFlechasAntesDeAtirar -1, e.getFlechas());
    }
    
    @Test
    public void verificarSeGanhouUmDeExperienciaAoAtirarFlecha()
    {
        Elfo e = new Elfo("Gustavo");
        int experienciaAntesDeAtirar = e.getExperiencia();
        e.atirarFlechaEmDwarf(new Dwarf("Paulo"));
        assertEquals(experienciaAntesDeAtirar +1, e.getExperiencia());
    }
    
    @Test
    public void verificarSeElfoFoiInstanciadoComQuantidadePadraoDe42Flechas()
    {
        Elfo e = new Elfo("Gustavo");
        assertEquals(42, e.getFlechas());
    }
    
    @Test
    public void verificarSeElfoFoiInstanciadoInformando50Flechas()
    {
        Elfo e = new Elfo("Gustavo", 50);
        assertEquals(50, e.getFlechas());
    }
    
    @Test
    public void verificarToStringAoCriarElfo()
    {
        Elfo e = new Elfo("Gustavo");
        assertEquals(e.getNome() + " possui " + e.getFlechas() + " flecha(s) e " + e.getExperiencia() + " nívei(s) de experiência.", e.toString());
    }
    
    @Test
    public void verificarToStrinAposElfoAtirarFlecha()
    {
        Elfo e = new Elfo("Gustavo");
        String esperado = e.toString();
        e.atirarFlechaEmDwarf(new Dwarf("Pedro"));
        assertFalse(esperado.equals(e.toString()));
    }
    
    @Test
    public void compararElfosIguais()
    {
        Elfo elfo1 = new Elfo("gustavo");
        Elfo elfo2 = new Elfo("gustavo");
        assertTrue(elfo1.equals(elfo2));
    }
    
    @Test
    public void compararElfosIguaisComTrintaFlechas()
    {
        Elfo elfo1 = new Elfo("gustavo", 30);
        Elfo elfo2 = new Elfo("gustavo", 30);
        assertTrue(elfo1.equals(elfo2));
    }
    
    @Test
    public void compararElfosComNomesDiferentes()
    {
        Elfo elfo1 = new Elfo("gustavo");
        Elfo elfo2 = new Elfo("gustavo Mello");
        assertFalse(elfo1.equals(elfo2));
    }
    
    @Test
    public void compararElfosComQuantidadeDeFlechasDiferentes()
    {
        Elfo elfo1 = new Elfo("gustavo");
        Elfo elfo2 = new Elfo("gustavo", 30);
        assertFalse(elfo1.equals(elfo2));
    }
}
