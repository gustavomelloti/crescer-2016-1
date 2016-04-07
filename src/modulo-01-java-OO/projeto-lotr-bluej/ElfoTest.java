import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
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
}
