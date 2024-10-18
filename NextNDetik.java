/*
Name : Mohamad Arvin Fadriansya
NPM : 2006596996
Desc. : Program ini akan berisi mengenai penambahan waktu dalam n detik 
*/
import java.util.Scanner;

public class NextNDetik {
    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Input jam: ");
        int jam = sc.nextInt();
        System.out.print("Input menit: ");
        int menit = sc.nextInt();
        System.out.print("Input detik: ");
        int detik = sc.nextInt();
        System.out.print("N: ");
        int n = sc.nextInt();

        detik += n;

        while (detik > 59){
            detik -= 60;
            menit ++;

        while (menit > 59){
                menit -= 60;
                jam ++;

        while (jam > 23){
                    jam -= 24;                    
                }

            }
        }
        
        System.out.println("Waktu " + n + " detik kedepan");
        System.out.println("adalah: (" + jam + "," + menit  + "," + detik + ")");
    }
    
}
