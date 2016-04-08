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
    
    @Test
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
    
    @Test
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
    
    @Test
    public void inventarioComItemNomeArmadura()
    {
        Inventario inventario = new Inventario();
        Item armadura = new Item(10, "armadura");
        inventario.adicionarItem(armadura);
        assertEquals("armadura", inventario.getDescricoesItens());
    }
    
    @Test
    public void inventarioComDoisItensArmaduraEBota()
    {
        Inventario inventario = new Inventario();
        Item armadura = new Item(10, "armadura");
        Item bota = new Item(10, "bota");
        inventario.adicionarItem(armadura);
        inventario.adicionarItem(bota);
        assertEquals("armadura,bota", inventario.getDescricoesItens());
    }
    
    @Test
    public void inventarioComNenhumItem()
    {
        Inventario inventario = new Inventario();
        assertEquals("", inventario.getDescricoesItens());
    }
    
    @Test
    public void inventarioComItemBotaQuePossuiMaiorQuantidade()
    {
        Inventario inventario = new Inventario();
        Item armadura = new Item(10, "armadura");
        Item bota = new Item(15, "bota");
        inventario.adicionarItem(armadura);
        inventario.adicionarItem(bota);
        assertSame(bota, inventario.getItemComMaiorQuantidade());    
    }
    
    @Test
    public void inventarioComNenhumItemRetornandoMaiorQuantidade()
    {
        Inventario inventario = new Inventario();
        assertNull(inventario.getItemComMaiorQuantidade());    
    }
    
    @Test
    public void ordenarInventarioCom2tens()
    {
        Inventario inventario = new Inventario();
        Item armadura = new Item(15, "armadura");
        Item bota = new Item(10, "bota");
        inventario.adicionarItem(armadura);
        inventario.adicionarItem(bota);
        inventario.ordenarItens();
        //assertSame(bota, inventario.getItens().get(0));    
    }
}
