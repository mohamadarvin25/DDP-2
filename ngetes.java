
import java.util.Date;
import java.text.SimpleDateFormat;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.Arrays;

public class ngetes {
  public static void main(String[] args) {

    Integer[] a = { 3, 6, 4, 7, 5 };
    for (int i = 0; i < a.length; i++) {
      for (int j = i + 1; j < a.length; j++) {
        if (a[i] > a[j]) {
          Integer temp = a[i];
          a[i] = a[j];
          a[j] = temp;
        }
      }
      
    }
    System.out.println(Arrays.toString(a));
  }
}
