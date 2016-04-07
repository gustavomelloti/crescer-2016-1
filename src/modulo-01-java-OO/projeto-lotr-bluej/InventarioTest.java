import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class InventarioTest
{   
    @Test
    public void testarInsercaoDeUmItem()
    {
        Inventario i = new Inventario();
        Item armadura = new Item(2, "Armadura X");
        
        i.adicionarItem(armadura);
        
        assertSame(armadura, i.getItens().get(0));
    }
    
    public void testarRemocaoDeItem()
    {
        Inventario i = new Inventario();
        Item armadura = new Item(2, "Armadura X");
        Item bota = new Item(2, "bota X");
       
        i.adicionarItem(armadura);
        i.adicionarItem(bota);
        i.removerItem(armadura);
        
        assertFalse(i.getItens().contains(armadura));
    }
    
    public void testarInsercaoDe3Itens()
    {
        Inventario i = new Inventario();
        
        Item armadura = new Item(2, "Armadura X");
        Item bota = new Item(2, "bota X");
        Item capacete = new Item(2, "Capacete X");
        
        i.adicionarItem(armadura);
        i.adicionarItem(bota);
        i.adicionarItem(capacete);

        assertTrue(i.getItens().size() == 3);
    }
}
