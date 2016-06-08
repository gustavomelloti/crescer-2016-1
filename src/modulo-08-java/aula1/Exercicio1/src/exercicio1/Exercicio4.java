package exercicio1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Exercicio4 {
    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date date = new Date();
	System.out.println(dateFormat.format(date));
        
        
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        System.out.println(c.get(Calendar.DAY_OF_WEEK));  
    }
}
