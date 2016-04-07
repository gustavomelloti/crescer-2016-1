import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest
{
    @Test
    public void testarComAno2016()
    {
        DataTerceiraEra ano2016 = new DataTerceiraEra(1, 10, 2016);
        assertTrue(ano2016.ehBissexto());
    }
    
    @Test
    public void testarComAno4()
    {
        DataTerceiraEra ano4 = new DataTerceiraEra(1, 10, 4);
        assertTrue(ano4.ehBissexto());
    }
    
    @Test
    public void testarComAno3024()
    {
        DataTerceiraEra ano3024 = new DataTerceiraEra(1, 10, 3024);
        assertTrue(ano3024.ehBissexto());
    }
    
    @Test
    public void testarComAno2015()
    {
        DataTerceiraEra ano2015 = new DataTerceiraEra(1, 10, 2015);
        assertFalse(ano2015.ehBissexto());
    }
    
    @Test
    public void testarComAnoNegativo()
    {
        DataTerceiraEra anoNegativo = new DataTerceiraEra(1, 10, -20);
        assertFalse(anoNegativo.ehBissexto());
    }
    
    @Test
    public void testarComAnoZero()
    {
        DataTerceiraEra anoZero = new DataTerceiraEra(1, 10, 0);
        assertFalse(anoZero.ehBissexto());
    }
}
