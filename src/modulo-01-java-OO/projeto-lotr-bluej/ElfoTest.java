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
}
