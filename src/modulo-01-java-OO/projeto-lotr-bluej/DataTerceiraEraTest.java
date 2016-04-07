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
    public void testarComAno3024QueNaoEhBissexto()
    {
        DataTerceiraEra ano3024 = new DataTerceiraEra(1, 10, 3024);
        assertFalse(ano3024.ehBissexto());
    }
    
    @Test
    public void testarComAno2015QueNaoEhBissexto()
    {
        DataTerceiraEra ano2015 = new DataTerceiraEra(1, 10, 2015);
        assertFalse(ano2015.ehBissexto());
    }
}
