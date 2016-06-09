package Juros;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Parcelator {
    public List<Parcela> simpleInterestCalculator(double valor, double taxa, int parcelas, Date dataInformada) throws ParseException
    {
        List<Parcela> carnePagamento = new ArrayList<>();
        
        double valorParcela = (valor + (valor * taxa)) / parcelas;

        Calendar cal = Calendar.getInstance();
        cal.setTime(dataInformada);
        
        for (int i = 1; i <= parcelas; i++) {
            carnePagamento.add(
                new Parcela (
                    i,
                    cal.getTime(),
                    valorParcela
                )
            );
            cal.add(Calendar.MONTH, 1);
        }
        
        return carnePagamento;
    }
}
