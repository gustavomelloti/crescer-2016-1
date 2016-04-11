import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoVerdeTest
{
   @Test
   public void adicionarItemArmadura()
   {
       ElfoVerde elfoV = new ElfoVerde("Gustavo");
       Item armadura = new Item(10, "Armadura X");
       elfoV.adicionarItem(armadura);
       assertTrue(elfoV.getInventario().getItens().size() == 0);
   }
   
   @Test
   public void adicionarItemEspadadeacovaliriano()
   {
       ElfoVerde elfoV = new ElfoVerde("Gustavo");
       Item espada = new Item(10, "Espada de aço valiriano");
       elfoV.adicionarItem(espada);
       assertTrue(elfoV.getInventario().getItens().contains(espada));
   }
   
   @Test
   public void adicionarItemArcoeFlechadeVidro()
   {
       ElfoVerde elfoV = new ElfoVerde("Gustavo");
       Item arco = new Item(10, "Arco e Flecha de Vidro");
       elfoV.adicionarItem(arco);
       assertTrue(elfoV.getInventario().getItens().contains(arco));
   }
}
