import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Latihan {

  // method utama
  public static void main(String[] args) {
    SimpleDateFormat sdf = new SimpleDateFormat(
        "dd/MM/yyyy");
    try {
    Date d1 = sdf.parse("25/10/2001");
    Date d2 = sdf.parse("26/10/2025");

    long difference_In_Time = d2.getTime() - d1.getTime();

    long difference_In_Days = (difference_In_Time
        / (1000 * 60 * 60 * 24));

    System.out.println(difference_In_Days);
    }

    catch (ParseException e) {
      e.printStackTrace();
    }
    
  }

  // method ini menghitung ada berapa banyak
  // elemen genap yang ada di matrix

}