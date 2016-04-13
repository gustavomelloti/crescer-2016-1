import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest
{
    @Test
    public void testarComAno2016QueEhBissexto()
    {
        DataTerceiraEra ano2016 = new DataTerceiraEra(1, 10, 2016);
        assertTrue(ano2016.ehBissexto());
    }
    
    @Test
    public void testarComAno3024QueEhBissexto()
    {
        DataTerceiraEra ano3024 = new DataTerceiraEra(1, 10, 3024);
        assertTrue(ano3024.ehBissexto());
    }
    
    @Test
    public void testarComAno2015QueNaoEhBissexto()
    {
        DataTerceiraEra ano2015 = new DataTerceiraEra(1, 10, 2015);
        assertFalse(ano2015.ehBissexto());
    }
    
    @Test
    public void comprarDatasComAnosDiferentes()
    {
         DataTerceiraEra data1 = new DataTerceiraEra(1, 10, 2015);
         DataTerceiraEra data2 = new DataTerceiraEra(1, 10, 2016);
         assertFalse(data1.equals(data2));
    }
    
    @Test
    public void comprarDatasComMesesDiferentes()
    {
         DataTerceiraEra data1 = new DataTerceiraEra(1, 10, 2015);
         DataTerceiraEra data2 = new DataTerceiraEra(1, 12, 2015);
         assertFalse(data1.equals(data2));
    }
    
    @Test
    public void comprarDatasComDiasDiferentes()
    {
         DataTerceiraEra data1 = new DataTerceiraEra(1, 12, 2015);
         DataTerceiraEra data2 = new DataTerceiraEra(5, 12, 2015);
         assertFalse(data1.equals(data2));
    }
    
    @Test
    public void comprarDatasiguais()
    {
         DataTerceiraEra data1 = new DataTerceiraEra(1, 12, 2015);
         DataTerceiraEra data2 = new DataTerceiraEra(1, 12, 2015);
         assertTrue(data1.equals(data2));
    }
    
    @Test
    public void comprarDatasComDiasEMesesDiferentes()
    {
         DataTerceiraEra data1 = new DataTerceiraEra(1, 10, 2015);
         DataTerceiraEra data2 = new DataTerceiraEra(5, 12, 2015);
         assertFalse(data1.equals(data2));
    }
    
    @Test
    public void comprarDatasComDiasEAnosDiferentes()
    {
         DataTerceiraEra data1 = new DataTerceiraEra(1, 10, 2015);
         DataTerceiraEra data2 = new DataTerceiraEra(5, 10, 2014);
         assertFalse(data1.equals(data2));
    }
    
    @Test
    public void comprarDatasComMesesEAnosDiferentes()
    {
         DataTerceiraEra data1 = new DataTerceiraEra(5, 11, 2015);
         DataTerceiraEra data2 = new DataTerceiraEra(5, 10, 2014);
         assertFalse(data1.equals(data2));
    }
}
