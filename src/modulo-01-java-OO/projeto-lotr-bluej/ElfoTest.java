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
    public void verificarSeElfoFoiInstanciadoCom42Flechas()
    {
        Elfo e = new Elfo("Gustavo");
        assertEquals(42, e.getFlechas());
    }
    
    @Test
    public void verificarToStringAoCriarElfoComNomeGustavo()
    {
        Elfo e = new Elfo("Gustavo");
        assertEquals("Gustavo possui 42 flecha(s) e 0 nívei(s) de experiência.", e.toString());
    }
    
    @Test
    public void verificarToStringAoCriarElfoComNomeGustavoEAtirarUmaFlecha()
    {
        Elfo e = new Elfo("Gustavo");
        e.atirarFlechaEmDwarf(new Dwarf("Pedro"));
        assertEquals("Gustavo possui 41 flecha(s) e 1 nívei(s) de experiência.", e.toString());
    }
}
