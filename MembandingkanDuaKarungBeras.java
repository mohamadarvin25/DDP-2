import java.util.Scanner;
public class MembandingkanDuaKarungBeras {   
    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan berat dan harga untuk karung 1: ");
        double beratKarung1 = sc.nextDouble();
        double hargaKarung1 = sc.nextDouble();
        double hargaPerBerat1 = hargaKarung1 / beratKarung1 ;

        System.out.print("Masukkan berat dan harga untuk karung 2: ");
        double beratKarung2 = sc.nextDouble();
        double hargaKarung2 = sc.nextDouble();
        double hargaPerBerat2 = hargaKarung2 / beratKarung2 ;

        if (hargaPerBerat1 > hargaPerBerat2) {
            System.out.print("karung 2 lebih murah");
        }

        else if (hargaPerBerat1 == hargaPerBerat2) {
            System.out.print("kedua karung sama aja");
        }

        else {
            System.out.print("karung 1 lebih murah");
        }

    }
}
