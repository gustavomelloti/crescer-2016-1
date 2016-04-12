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
   public void verificarExperienciaAoAtirarTresFlechas()
   {
       ElfoNoturno elfo = new ElfoNoturno("Gustavo");
       Dwarf d = new Dwarf("Paul");
       elfo.atirarFlechaEmDwarf(d);
       elfo.atirarFlechaEmDwarf(d);
       elfo.atirarFlechaEmDwarf(d);
       assertEquals(9, elfo.getExperiencia());
   }
   
   @Test
   public void verificarSeElfoMorreAposAtirarVinteFlechas()
   {
       ElfoNoturno elfo = new ElfoNoturno("Gustavo");
       Dwarf d = new Dwarf("Paul");
       
       for (int i = 0; i < 20; i++)
           elfo.atirarFlechaEmDwarf(d);
   
       assertEquals(Status.MORTO, elfo.getStatus());
   }
   
   @Test
   public void verificarExperienciaAposAtirarVinteFlechas()
   {
       ElfoNoturno elfo = new ElfoNoturno("Gustavo");
       Dwarf d = new Dwarf("Paul");
       
       for (int i = 0; i < 20; i++)
           elfo.atirarFlechaEmDwarf(d);
   
       assertEquals(60, elfo.getExperiencia());
   }
}
