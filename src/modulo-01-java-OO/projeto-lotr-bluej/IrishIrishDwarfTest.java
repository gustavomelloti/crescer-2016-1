
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishIrishDwarfTest
{
   @Test
   public void verificarSePerdeuDezDeVidaAoReceberFlechada()
   {
       IrishDwarf d = new IrishDwarf("Gustavo");
       int vidaAtual = d.getQtdVida();
       d.receberFlechada();
       assertEquals(vidaAtual-10, d.getQtdVida());
   }
   
   public void verificarSeIrishDwarfFoiInstanciadoCom110DeVida()
   {
       IrishDwarf d = new IrishDwarf("Gustavo");
       assertEquals(110, d.getQtdVida());
   }
   
   @Test
   public void IrishDwarfNasceVivo() 
   {
       IrishDwarf IrishDwarf = new IrishDwarf("Gustavo");
       assertEquals(Status.VIVO, IrishDwarf.getStatus());
   }
   
   @Test
   public void IrishDwarfRecebeFlechaAteMorrer()
   {
       IrishDwarf d = new IrishDwarf("Gustavo");
 
       for (int i = 0; i <= 10;i++)
           d.receberFlechada();
     
       assertEquals(Status.MORTO, d.getStatus()); 
   }
   
   @Test
   public void verificarSeVidaPermanece0AposMorrerETentarPerderVida()
   {
       IrishDwarf d = new IrishDwarf("Gustavo");
       
       for (int i = 0; i <= 11;i++)
           d.receberFlechada();
       
       assertEquals(0, d.getQtdVida());
   }

   @Test
   public void testarConstrutorComDataTerceiraEraPadrao()
   {
       IrishDwarf d = new IrishDwarf("Gustavo");
       assertEquals(1, d.getDataNascimento().getDia());
       assertEquals(1, d.getDataNascimento().getMes());
       assertEquals(1, d.getDataNascimento().getAno());
   }
   
   @Test
   public void testarConstrutorInformandoDataTerceiraEra()
   {
       DataTerceiraEra nascimentoIrishDwarf = new DataTerceiraEra(12, 12, 2018);
       IrishDwarf d = new IrishDwarf("Gustavo", nascimentoIrishDwarf);
       assertSame(nascimentoIrishDwarf, d.getDataNascimento());
   }
   
   @Test
   public void testarNumeroDaSorteIrishDwarfNascidoAnoBissextoEComVida85()
   {
       IrishDwarf d = new IrishDwarf("Gustavo", new DataTerceiraEra(01, 12, 2016));
       
       for (int i = 0; i <= 2; i++)
           d.receberFlechada();
           
       assertTrue(-3333 == d.getNumeroSorte());
   }
   
   @Test
   public void testarNumeroDaSorteIrishDwarfNascidoAnoBissextoEComVida110()
   {
       IrishDwarf d = new IrishDwarf("Gustavo", new DataTerceiraEra(12, 12, 2016));
       assertTrue(101.00 == d.getNumeroSorte());
   }
   
   @Test
   public void testarNumeroDaSorteIrishDwarfNascidoAnoNaoBissextoComNomeGustavo()
   {
       IrishDwarf d = new IrishDwarf("Gustavo", new DataTerceiraEra(1, 1, 2015));
       assertTrue(101.00 == d.getNumeroSorte());
   }
   
   @Test
   public void testarNumeroDaSorteIrishDwarfNascidoAnoNaoBissextoComNomeSeixas()
   {
      IrishDwarf d = new IrishDwarf("Seixas", new DataTerceiraEra(1, 1, 2015));
      assertTrue(33 == d.getNumeroSorte());
   }
   
   @Test
   public void testarNumeroDaSorteIrishDwarfNascidoAnoNaoBissextoComNomeMeireles()
   {
       IrishDwarf d = new IrishDwarf("Meireles", new DataTerceiraEra(1, 1, 2015));
       assertTrue(33 == d.getNumeroSorte());
   }
   
   @Test
   public void testarNumeroDaSorteIrishDwarfNascidoAnoBissextoComNomeMeireles()
   {
       IrishDwarf d = new IrishDwarf("Meireles", new DataTerceiraEra(1, 1, 2016));
       assertTrue(101 == d.getNumeroSorte());
   }
   
   @Test
   public void testarIrishDwarfAnoNaoBissextoComNomeSeixasRecebendoUmaFlechada()
   {
        IrishDwarf d = new IrishDwarf("Seixas", new DataTerceiraEra(1, 1, 2015));
        d.receberFlechada();
        assertEquals(110, d.getQtdVida());
        assertEquals(0, d.getExperiencia());
   }
   
   @Test
   public void testarIrishDwarfAnoBissextoComNomeSeixasRecebendoUmaFlechada()
   {
        IrishDwarf d = new IrishDwarf("Seixas", new DataTerceiraEra(1, 1, 2016));
        d.receberFlechada();
        assertEquals(100, d.getQtdVida());
   }
   
   @Test
   public void testarIrishDwarfAnoNaoBissextoComNomeGustavoRecebendoUmaFlechada()
   {
        IrishDwarf d = new IrishDwarf("Gustavo", new DataTerceiraEra(1, 1, 2015));
        d.receberFlechada();
        assertEquals(100, d.getQtdVida());
   }
   
   @Test
   public void testarIrishDwarfAnoBissextoComVida110RecebendoUmaFlechada()
   {
        IrishDwarf d = new IrishDwarf("Gustavo", new DataTerceiraEra(1, 1, 2016));
        d.receberFlechada();
        assertEquals(100, d.getQtdVida());
   }
   
   @Test
   public void testarIrishDwarfAnoBissextoRecebendoQuatroFlechadas()
   {
        IrishDwarf d = new IrishDwarf("Gustavo", new DataTerceiraEra(1, 1, 2016));
        
        for (int i = 0; i <= 4; i++)
            d.receberFlechada();
            
        assertEquals(90, d.getQtdVida());
        assertEquals(6, d.getExperiencia());
   }
   
   @Test
   public void IrishDwarfTentaSorteComUmItemBotaComQuantidade2()
   {
       IrishDwarf d = new IrishDwarf("Gustavo", new DataTerceiraEra(1,1,2016));
       Inventario inventario = new Inventario();
       Item armadura = new Item(2, "Armadura");
       inventario.adicionarItem(armadura);
       d.getInventario().adicionarItem(armadura);
       
       for (int i = 0; i <= 2; i++)
            d.receberFlechada();
       
       assertEquals(3002, d.getInventario().getItens().get(0).getQuantidade());
   }
   
   @Test
   public void IrishDwarfTentaSorteComTresItens()
   {
       IrishDwarf d = new IrishDwarf("Gustavo", new DataTerceiraEra(1,1,2016));
       Inventario inventario = new Inventario();
       Item armadura = new Item(2, "Armadura");
       Item espada = new Item(3, "Espada");
       Item bota = new Item(4, "Bota");
       
       inventario.adicionarItem(armadura);
       d.getInventario().adicionarItem(armadura);
       d.getInventario().adicionarItem(espada);
       d.getInventario().adicionarItem(bota);
       
       for (int i = 0; i <= 2; i++)
            d.receberFlechada();
       
       assertEquals(3002, d.getInventario().getItens().get(0).getQuantidade());
       assertEquals(6003, d.getInventario().getItens().get(1).getQuantidade());
       assertEquals(10004, d.getInventario().getItens().get(2).getQuantidade());
   }
}