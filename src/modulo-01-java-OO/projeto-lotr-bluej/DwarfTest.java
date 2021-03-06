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
       double vidaAtual = d.getQtdVida();
       d.receberFlechada();
       assertTrue(100.00 == d.getQtdVida());
   }
   
   public void verificarSeDwarfFoiInstanciadoCom110DeVida()
   {
       Dwarf d = new Dwarf("Gustavo");
       assertTrue(110.00 == d.getQtdVida());
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
   
   @Test
   public void verificarSeVidaPermanece0AposMorrerETentarPerderVida()
   {
       Dwarf d = new Dwarf("Gustavo");
       
       for (int i = 0; i <= 11;i++)
           d.receberFlechada();
       
       assertTrue(0.00 == d.getQtdVida());
   }

   @Test
   public void testarConstrutorComDataTerceiraEraPadrao()
   {
       Dwarf d = new Dwarf("Gustavo");
       assertEquals(1, d.getDataNascimento().getDia());
       assertEquals(1, d.getDataNascimento().getMes());
       assertEquals(1, d.getDataNascimento().getAno());
   }
   
   @Test
   public void testarConstrutorInformandoDataTerceiraEra()
   {
       DataTerceiraEra nascimentoDwarf = new DataTerceiraEra(12, 12, 2018);
       Dwarf d = new Dwarf("Gustavo", nascimentoDwarf);
       assertSame(nascimentoDwarf, d.getDataNascimento());
   }
   
   @Test
   public void testarNumeroDaSorteDwarfNascidoAnoBissextoEComVida85()
   {
       Dwarf d = new Dwarf("Gustavo", new DataTerceiraEra(01, 12, 2016));
       
       for (int i = 0; i <= 2; i++)
           d.receberFlechada();
           
       assertTrue(-3333 == d.getNumeroSorte());
   }
   
   @Test
   public void testarNumeroDaSorteDwarfNascidoAnoBissextoEComVida110()
   {
       Dwarf d = new Dwarf("Gustavo", new DataTerceiraEra(12, 12, 2016));
       assertTrue(101.00 == d.getNumeroSorte());
   }
   
   @Test
   public void testarNumeroDaSorteDwarfNascidoAnoNaoBissextoComNomeGustavo()
   {
       Dwarf d = new Dwarf("Gustavo", new DataTerceiraEra(1, 1, 2015));
       assertTrue(101.00 == d.getNumeroSorte());
   }
   
   @Test
   public void testarNumeroDaSorteDwarfNascidoAnoNaoBissextoComNomeSeixas()
   {
      Dwarf d = new Dwarf("Seixas", new DataTerceiraEra(1, 1, 2015));
      assertTrue(33 == d.getNumeroSorte());
   }
   
   @Test
   public void testarNumeroDaSorteDwarfNascidoAnoNaoBissextoComNomeMeireles()
   {
       Dwarf d = new Dwarf("Meireles", new DataTerceiraEra(1, 1, 2015));
       assertTrue(33 == d.getNumeroSorte());
   }
   
   @Test
   public void testarNumeroDaSorteDwarfNascidoAnoBissextoComNomeMeireles()
   {
       Dwarf d = new Dwarf("Meireles", new DataTerceiraEra(1, 1, 2016));
       assertTrue(101 == d.getNumeroSorte());
   }
   
   @Test
   public void testarDwarfAnoNaoBissextoComNomeSeixasRecebendoUmaFlechada()
   {
        Dwarf d = new Dwarf("Seixas", new DataTerceiraEra(1, 1, 2015));
        d.receberFlechada();
        assertTrue(110.00 == d.getQtdVida());
        assertEquals(0, d.getExperiencia());
   }
   
   @Test
   public void testarDwarfAnoBissextoComNomeSeixasRecebendoUmaFlechada()
   {
        Dwarf d = new Dwarf("Seixas", new DataTerceiraEra(1, 1, 2016));
        d.receberFlechada();
        assertTrue(100.00 == d.getQtdVida());
   }
   
   @Test
   public void testarDwarfAnoNaoBissextoComNomeGustavoRecebendoUmaFlechada()
   {
        Dwarf d = new Dwarf("Gustavo", new DataTerceiraEra(1, 1, 2015));
        d.receberFlechada();
        assertTrue(100.00 == d.getQtdVida());
   }
   
   @Test
   public void testarDwarfAnoBissextoComVida110RecebendoUmaFlechada()
   {
        Dwarf d = new Dwarf("Gustavo", new DataTerceiraEra(1, 1, 2016));
        d.receberFlechada();
        assertTrue(100.00 == d.getQtdVida());
   }
   
   @Test
   public void testarDwarfAnoBissextoRecebendoQuatroFlechadas()
   {
        Dwarf d = new Dwarf("Gustavo", new DataTerceiraEra(1, 1, 2016));
        
        for (int i = 0; i <= 4; i++)
            d.receberFlechada();
            
        assertTrue(90.00 == d.getQtdVida());
        assertEquals(6, d.getExperiencia());
   }
   
   @Test
   public void dwarfTentaSorteComUmItemBotaComQuantidade2()
   {
       Dwarf d = new Dwarf("Gustavo", new DataTerceiraEra(1,1,2016));
       Inventario inventario = new Inventario();
       Item armadura = new Item(2, "Armadura");
       inventario.adicionarItem(armadura);
       d.getInventario().adicionarItem(armadura);
       
       for (int i = 0; i <= 2; i++)
            d.receberFlechada();
       
       assertEquals(1002, d.getInventario().getItens().get(0).getQuantidade());
   }
   
   @Test
   public void dwarfTentaSorteComTresItens()
   {
       Dwarf d = new Dwarf("Gustavo", new DataTerceiraEra(1,1,2016));
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
       
       assertEquals(1002, d.getInventario().getItens().get(0).getQuantidade());
       assertEquals(1003, d.getInventario().getItens().get(1).getQuantidade());
       assertEquals(1004, d.getInventario().getItens().get(2).getQuantidade());
   }
  
   @Test
   public void compararDwarfComMenorVidaPrimeiro()
   {
       Dwarf d1 = new Dwarf("Gustavo");
       d1.receberFlechada();
       Dwarf d2 = new Dwarf("Paul");
       assertSame(d1, Dwarf.descobrirMenosVida(d1, d2));
   }
   
   @Test
   public void compararDwarfComMenorVidaSegundo()
   {
       Dwarf d1 = new Dwarf("Gustavo");
       Dwarf d2 = new Dwarf("Paul");
       d2.receberFlechada();
       assertSame(d2, Dwarf.descobrirMenosVida(d2, d1));
   }
   
   @Test
   public void compararDwarfMenorVidaIguais()
   { 
       Dwarf d1 = new Dwarf("Gustavo");
       Dwarf d2 = new Dwarf("Paul");
       assertSame(d2, Dwarf.descobrirMenosVida(d1, d2));
   }
   
   @Test
   public void comprarDwarfsIguais()
   {
       Dwarf d1 = new Dwarf("Gustavo");
       Dwarf d2 = new Dwarf("Gustavo");
       assertTrue(d1.equals(d2));
   }
   
   @Test
   public void comprarDwarfsIguaisInformandoDataNascimento()
   {
       Dwarf d1 = new Dwarf("Gustavo", new DataTerceiraEra(10,12,1200));
       Dwarf d2 = new Dwarf("Gustavo", new DataTerceiraEra(10,12,1200));
       assertTrue(d1.equals(d2));
   }
   
   @Test
   public void comprarDwarfsComNomesIguaisInformandoDataNascimentoDiferente()
   {
       Dwarf d1 = new Dwarf("Gustavo", new DataTerceiraEra(10,11,1200));
       Dwarf d2 = new Dwarf("Gustavo", new DataTerceiraEra(10,12,1200));
       assertFalse(d1.equals(d2));
   }
   
   @Test
   public void comprarDwarfsComNomesDiferentes()
   {
       Dwarf d1 = new Dwarf("Gustavo");
       Dwarf d2 = new Dwarf("Gustavo Mello");
       assertFalse(d1.equals(d2));
   }
}