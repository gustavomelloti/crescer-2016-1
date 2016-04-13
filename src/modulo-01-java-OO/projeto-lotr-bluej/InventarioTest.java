import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;


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
        assertSame(bota, inventario.getItens().get(0));
        assertSame(armadura, inventario.getItens().get(1));
    }
    
    @Test
    public void ordenarInventarioCom3itensSemPrecisarModificar()
    {
        Inventario inventario = new Inventario();
        Item armadura = new Item(15, "armadura");
        Item bota = new Item(40, "bota");
        Item espada = new Item(50, "espada");
        inventario.adicionarItem(armadura);
        inventario.adicionarItem(bota);
        inventario.adicionarItem(espada);
        inventario.ordenarItens();
        assertSame(armadura, inventario.getItens().get(0));
        assertSame(bota, inventario.getItens().get(1));
        assertSame(espada, inventario.getItens().get(2));
    }
    
    @Test
    public void ordenarInventarioCom3itensNecessitandoOrdenar()
    {
        Inventario inventario = new Inventario();
        Item armadura = new Item(15, "armadura");
        Item bota = new Item(40, "bota");
        Item espada = new Item(50, "espada");
        inventario.adicionarItem(espada);
        inventario.adicionarItem(bota);
        inventario.adicionarItem(armadura);
        inventario.ordenarItens();
        assertSame(armadura, inventario.getItens().get(0));
        assertSame(bota, inventario.getItens().get(1));
        assertSame(espada, inventario.getItens().get(2));
    }
    
    @Test
    public void compararInventariosComMesmosItens()
    {
        Inventario i1 = new Inventario();
        Inventario i2 = new Inventario();
        Item espada = new Item(10, "Espada");
        Item armadura = new Item(10, "Armadura");
        i1.adicionarItem(espada);
        i1.adicionarItem(armadura);
        i2.adicionarItem(espada);
        i2.adicionarItem(armadura);
        assertTrue(i1.equals(i2));
    }
    
    @Test
    public void compararInventariosComMesmosItensEmOrdemDiferente()
    {
        Inventario i1 = new Inventario();
        Inventario i2 = new Inventario();
        Item espada = new Item(10, "Espada");
        Item armadura = new Item(10, "Armadura");
        i1.adicionarItem(espada);
        i1.adicionarItem(armadura);
        i2.adicionarItem(armadura);
        i2.adicionarItem(espada);
        assertTrue(i1.equals(i2));
    }
    
     @Test
     public void comprarInventariosComQuantidadesDiferentes()
     {
        Inventario i1 = new Inventario();
        Inventario i2 = new Inventario();
        Item espada = new Item(10, "Espada");
        Item armadura = new Item(10, "Armadura");
        i1.adicionarItem(espada);
        i1.adicionarItem(armadura);
        i2.adicionarItem(espada);
        assertFalse(i1.equals(i2));
     }
     
     @Test
     public void comprarInventariosDiferentesComQuantidadesIguais()
     {
        Inventario i1 = new Inventario();
        Inventario i2 = new Inventario();
        Item espada = new Item(10, "Espada");
        Item armadura = new Item(10, "Armadura");
        Item arco = new Item(10, "Arco");
        i1.adicionarItem(espada);
        i1.adicionarItem(armadura);
        i2.adicionarItem(espada);
        i2.adicionarItem(arco);
        assertFalse(i1.equals(i2));
     }
     
     @Test
     public void compararInventarioComUmItemAMais()
     {
        Inventario i1 = new Inventario();
        Inventario i2 = new Inventario();
        Item espada = new Item(10, "Espada");
        Item armadura = new Item(10, "Armadura");
        Item arco = new Item(10, "Arco");
        i1.adicionarItem(espada);
        i1.adicionarItem(armadura);
        i2.adicionarItem(espada);
        assertFalse(i1.equals(i2));
     }
}
