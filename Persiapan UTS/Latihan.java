import java.util.Scanner;
import java.util.Arrays;

public class Latihan {
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    System.out.print("nilai n (n >= 0): ");
    int n = input.nextInt();

    // isi array dengan barisan fibonacci
    int[] arrayFibo = arrFib(n);

    System.out.println(Arrays.toString(arrayFibo));

  }

  public static int[] arrFib(int n) {
    int[] arrayFibo = new int[n + 1];

    arrayFibo[0] = 0;
    if (n == 0) {
      return arrayFibo;
    } else {
      arrayFibo[1] = 1;
      if (n == 1) {        
        return arrayFibo;
      }
      for (int i = 2; i < arrayFibo.length; i++) {
        arrayFibo[i] = arrayFibo[i - 1] + arrayFibo[i - 2];
      }
      
    }
    return arrayFibo;
  }
}
