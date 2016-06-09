package StringUtil;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gustavo
 */
public class MeuStringUtilTest {

    @Test
    public void isNullPassandoPalavraCasaDeveRetornarFalse() {
        MeuStringUtil instance = new MeuStringUtil();
        assertEquals(false, instance.isEmpty("Casa"));
    }
    
    @Test
    public void isNullPassandoNullDeveRetornarTrue() {
        MeuStringUtil instance = new MeuStringUtil();
        assertEquals(true, instance.isEmpty(null));
    }
    
    @Test
    public void isNullPassandoStringVaziaDeveRetornarTrue() {
        MeuStringUtil instance = new MeuStringUtil();
        assertEquals(true, instance.isEmpty(""));
    }
    
    @Test
    public void isPalindromoPassandoOvoDeveRetornarTrue() {
        MeuStringUtil instance = new MeuStringUtil();
        assertEquals(true, instance.isPalindromo("ovo"));
    }
    
    @Test
    public void isPalindromoPassandoCasaDeveRetornarFalse() {
        MeuStringUtil instance = new MeuStringUtil();
        assertEquals(false, instance.isPalindromo("casa"));
    }
    
    @Test
    public void isPalindromoPassandoAmeEEmaDeveRetornarTrue() {
        MeuStringUtil instance = new MeuStringUtil();
        assertEquals(true, instance.isPalindromo("Ame a ema"));
    }
    
    @Test
    public void reversePassandoCasaDeveRetornarAsac() {
        MeuStringUtil instance = new MeuStringUtil();
        assertEquals("asac", instance.reverse("casa"));
    }
    
    @Test
    public void reversePassandoADeveRetornarA() {
        MeuStringUtil instance = new MeuStringUtil();
        assertEquals("a", instance.reverse("a"));
    }
    
    @Test
    public void reversePassandoStringVaziaDeveRetornarStringVazia() {
        MeuStringUtil instance = new MeuStringUtil();
        assertEquals("", instance.reverse(""));
    }
    
    @Test
    public void lengthVogaisPassandoCasaDeveRetornar2() {
        MeuStringUtil instance = new MeuStringUtil();
        assertEquals(2, instance.lengthVogais("casa"));
    }
    
    @Test
    public void lengthVogaisPassandoFgtDeveRetornar0() {
        MeuStringUtil instance = new MeuStringUtil();
        assertEquals(0, instance.lengthVogais("fgy"));
    }
    
    @Test
    public void lengthVogaisPassandoAeiouDeveRetornar5() {
        MeuStringUtil instance = new MeuStringUtil();
        assertEquals(5, instance.lengthVogais("aeiou"));
    }
}
