import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest
{
    @Test
    public void compararDoisItensIguais()
    {
        Item a = new Item(10, "espada");
        Item b = new Item(10, "espada");   
        assertTrue(a.equals(b));
    }
    
    @Test
    public void compararDoisItensDiferentes()
    {
        Item a = new Item(13, "espada");
        Item b = new Item(10, "espada");   
        assertFalse(a.equals(b));
    }
}
