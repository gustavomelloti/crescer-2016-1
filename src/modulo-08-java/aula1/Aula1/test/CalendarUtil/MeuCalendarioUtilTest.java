package CalendarUtil;

import java.text.ParseException;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class MeuCalendarioUtilTest {
    @Test
    public void dayOfWeekInformandoData08062016QueEhQuarta() throws ParseException {
        MeuCalendarioUtil instance = new MeuCalendarioUtil();
        assertEquals("Quarta-feira", instance.dayOfWeek("08/06/2016"));
    }
    
    @Test
    public void dayOfWeekInformandoData12062016QueEhDomingo() throws ParseException {
        MeuCalendarioUtil instance = new MeuCalendarioUtil();
        assertEquals("Domingo", instance.dayOfWeek("12/06/2016"));
    }
}
