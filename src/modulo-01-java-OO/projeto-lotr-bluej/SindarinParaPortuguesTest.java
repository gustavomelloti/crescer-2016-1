import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SindarinParaPortuguesTest
{
   @Test
    public void traduzirNaurParaIngles() {
        TradutorSindarin tradutorPortugues = new SindarinParaPortugues();
        assertEquals("fogo", tradutorPortugues.traduzir("naur"));
    }
    
    @Test
    public void traduzirNullParaIngles() {
        TradutorSindarin tradutorPortugues = new SindarinParaPortugues();
        assertNull(tradutorPortugues.traduzir("null"));
    }
}
