package controler;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * class to correct the timer
 */
public class Corection {
 /**
  * Construct the time when auction ends when it is created
  * @param s time formated to string in dd:HH:mm:ss format
  * @return time in long format
  * @throws ParseException
  */
       public static long endingTime(String s) throws ParseException {

        SimpleDateFormat format=new SimpleDateFormat("dd:HH:mm:ss");
        System.out.println(s);
        s = s.replace(' ','0');
        System.out.println(s);
        Date date = new Date();
        String pom = format.format(date);

        int dd=Integer.parseInt(pom.substring(0,2))+Integer.parseInt(s.substring(0,2));

        System.out.println(dd);
        int hh=Integer.parseInt(pom.substring(3,5))+Integer.parseInt(s.substring(3,5));
        System.out.println(hh);
        int mm=Integer.parseInt(pom.substring(6,8))+Integer.parseInt(s.substring(6,8));
        System.out.println(mm);
        int ss=Integer.parseInt(pom.substring(9,11))+Integer.parseInt(s.substring(9,11));

//        String finito = String.format("%02d", dd)+":"+String.format("%02d", hh)+":"+String.format("%02d", mm) +":" + String.format("%02d", ss);
        date.setDate(dd);
        date.setHours(hh);
        date.setMinutes(mm);
        date.setSeconds(ss);
        System.out.println("now:::::"+date.getSeconds());
//        date = new SimpleDateFormat("dd:HH:mm:ss").parse(finito);
        long l = date.getTime();
        return l;
    }



}
