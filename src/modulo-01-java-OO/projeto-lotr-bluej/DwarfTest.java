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
}
