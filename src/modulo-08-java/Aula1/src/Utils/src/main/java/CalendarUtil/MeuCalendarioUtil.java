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
    
    public String elapsedDate(String data) throws ParseException {
        SimpleDateFormat formatInput = new SimpleDateFormat("dd/MM/yyyy");
        
        long diffInMillis = new Date().getTime() - formatInput.parse(data).getTime();
        
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(diffInMillis);
        c.add(Calendar.YEAR, -1970);
        
        return String.format("%03d ano(s), %03d mese(s) e %03d dia(s)", c.YEAR, c.MONTH, c.DAY_OF_MONTH);
    }
}
