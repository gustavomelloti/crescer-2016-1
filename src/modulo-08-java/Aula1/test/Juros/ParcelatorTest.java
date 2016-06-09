package Juros;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParcelatorTest {
    
    @Test
    public void simpleInterestCalculatorComValor1000Taxa01EDuasParcelasDeveRetornarDuasMensalidadesDe550() throws Exception {
        SimpleDateFormat formatInput = new SimpleDateFormat("dd/MM/yyyy");
        Date dataInformada = formatInput.parse("08/06/2016");
        Parcelator instance = new Parcelator();
        List<Parcela> result = instance.simpleInterestCalculator(1000, 0.1, 2, dataInformada);
        assertEquals(2, result.size());
        assertEquals(550.00,result.get(0).getValor(), 0.00);
        assertEquals(550.00,result.get(1).getValor(), 0.00);
    }
    
    @Test
    public void simpleInterestCalculatorComValor1000Taxa01EDezParcelasDeveRetornarDezMensalidadesDe110() throws Exception {
        SimpleDateFormat formatInput = new SimpleDateFormat("dd/MM/yyyy");
        Date dataInformada = formatInput.parse("08/06/2016");
        Parcelator instance = new Parcelator();
        List<Parcela> result = instance.simpleInterestCalculator(1000, 0.1, 10, dataInformada);
        assertEquals(10, result.size());
        assertEquals(110.00,result.get(0).getValor(), 0.00);
        assertEquals(110.00,result.get(1).getValor(), 0.00);
    }
    
    @Test
    public void simpleInterestCalculatorComValor1000Taxa01EDezParcelasDeveRetornarDezMensalidadesApartirDaData08062016() throws Exception {
        SimpleDateFormat formatInput = new SimpleDateFormat("dd/MM/yyyy");
        Date dataInformada = formatInput.parse("08/06/2016");
        Parcelator instance = new Parcelator();
        List<Parcela> result = instance.simpleInterestCalculator(1000, 0.1, 10, dataInformada);
        assertEquals(10, result.size());
        assertEquals("08/06/2016",formatInput.format(result.get(0).getDataVencimento()));
        assertEquals("08/07/2016",formatInput.format(result.get(1).getDataVencimento()));
        assertEquals("08/08/2016",formatInput.format(result.get(2).getDataVencimento()));
        assertEquals("08/09/2016",formatInput.format(result.get(3).getDataVencimento()));
        assertEquals("08/10/2016",formatInput.format(result.get(4).getDataVencimento()));
        assertEquals("08/11/2016",formatInput.format(result.get(5).getDataVencimento()));
        assertEquals("08/12/2016",formatInput.format(result.get(6).getDataVencimento()));
        assertEquals("08/01/2017",formatInput.format(result.get(7).getDataVencimento()));
        assertEquals("08/02/2017",formatInput.format(result.get(8).getDataVencimento()));
        assertEquals("08/03/2017",formatInput.format(result.get(9).getDataVencimento()));
    }
}
