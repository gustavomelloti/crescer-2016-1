import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class PersonagemTest
{
    @Test
    public void compararDoisPersonagensIguais()
    {
        Personagem f1 = new Elfo("Gustavo");
        Personagem f2 = new Elfo("Gustavo");
        
        assertTrue(f1.equals(f2));
    }
    
    @Test
    public void compararDoisPersonagensDiferentes()
    {
        Personagem f1 = new Elfo("Gustavo Mello");
        Personagem f2 = new Elfo("Gustavo");
        
        assertFalse(f1.equals(f2));
    }
}
