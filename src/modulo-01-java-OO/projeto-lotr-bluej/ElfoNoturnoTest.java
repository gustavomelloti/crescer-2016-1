import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ElfoNoturnoTest
{
   @Test
   public void verificarGanhoExperienciaAoAtirarFlecha()
   {
       ElfoNoturno elfo = new ElfoNoturno("Gustavo");
       elfo.atirarFlechaEmDwarf(new Dwarf("Paulo"));
       assertEquals(3, elfo.getExperiencia());
   }
   
   @Test
   public void verificarExperienciaAoAtirarTresFlecha()
   {
       ElfoNoturno elfo = new ElfoNoturno("Gustavo");
       Dwarf d = new Dwarf("Paul");
       elfo.atirarFlechaEmDwarf(d);
       elfo.atirarFlechaEmDwarf(d);
       elfo.atirarFlechaEmDwarf(d);
       assertEquals(9, elfo.getExperiencia());
   }
}
