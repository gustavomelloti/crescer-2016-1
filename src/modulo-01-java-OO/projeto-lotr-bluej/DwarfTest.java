import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
   @Test
   public void verificarSePerdeuDezDeVidaAoReceberFlechada()
   {
       Dwarf d = new Dwarf("Gustavo");
       int vidaAtual = d.getQtdVida();
       d.receberFlechada();
       assertEquals(vidaAtual-10, d.getQtdVida());
   }
   
   public void verificarSeDwarfFoiInstanciadoCom110DeVida()
   {
       Dwarf d = new Dwarf("Gustavo");
       assertEquals(110, d.getQtdVida());
   }
   
   @Test
   public void dwarfNasceVivo() 
   {
       Dwarf dwarf = new Dwarf("Gustavo");
       assertEquals(Status.VIVO, dwarf.getStatus());
   }
   
   @Test
   public void dwarfRecebeFlechaAteMorrer()
   {
       Dwarf d = new Dwarf("Gustavo");
 
       for (int i = 0; i <= 10;i++)
           d.receberFlechada();
     
       assertEquals(Status.MORTO, d.getStatus()); 
   }
   
   public void verificarSeVidaPermanece0AposMorrerETentarPerderVida()
   {
       Dwarf d = new Dwarf("Gustavo");
       
       for (int i = 0; i <= 11;i++)
           d.receberFlechada();
       
       assertEquals(0, d.getQtdVida());
   }
}