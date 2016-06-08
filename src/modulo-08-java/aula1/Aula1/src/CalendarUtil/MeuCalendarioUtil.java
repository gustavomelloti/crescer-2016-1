package CalendarUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MeuCalendarioUtil {
    
    public String dayOfWeek(String data) throws ParseException {
        SimpleDateFormat formatInput =new SimpleDateFormat("dd/MM/yyyy");
        Date dataFormata = formatInput.parse(data);
        
        DateFormat formatDayOfWeek = new SimpleDateFormat("EEEE"); 
        return formatDayOfWeek.format(dataFormata);
    }
    
    public long elapsedDate(String data) throws ParseException {
        SimpleDateFormat formatInput = new SimpleDateFormat("dd/MM/yyyy");
        
        Calendar now = Calendar.getInstance();
        Calendar dataInformada = Calendar.getInstance();
        Date d = formatInput.parse(data);
        dataInformada.set(d.getYear(), d.getMonth(), d.getDay());

        long diferencaEmMilisegundos = now.getTimeInMillis() - dataInformada.getTimeInMillis();
        
        return diferencaEmMilisegundos / (24 * 60 * 60 * 1000);
        
        //TODO: ajustar
    }
}
