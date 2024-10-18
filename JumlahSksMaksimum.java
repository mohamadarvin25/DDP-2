import java.util.Scanner;

public class JumlahSksMaksimum {
    public static void main(String[] Args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("IP sebelumnya: ");
        double ip = sc.nextDouble();

        if (ip < 2.0) {
            System.out.print("Anda boleh mengambil maksimal 12 SKS di semester ini.");
        } else if (ip < 2.5) {
            System.out.print("Anda boleh mengambil maksimal 15 SKS di semester ini.");
        } else if (ip < 3.0) {
            System.out.print("Anda boleh mengambil maksimal 18 SKS di semester ini.");
        } else if (ip < 3.5) {
            System.out.print("Anda boleh mengambil maksimal 21 SKS di semester ini.");
        } else {
            System.out.print("Anda boleh mengambil maksimal 24 SKS di semester ini.");
        }
    }

}
