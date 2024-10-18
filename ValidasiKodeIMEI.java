import java.util.Scanner;

public class ValidasiKodeIMEI {


        // Mengecek kevalidan kode IMEI
        public static boolean isValid(long kode) {
            return cekPrefix(kode)
                && (getPanjangKode(kode) == 11)
                && ((jumlahDoublePosisiGanjil(kode) + jumlahPosisiGenap(kode)) % 10 == 0);
        }
      
        // Menghitung total digit ganjil yang dikali 2
        public static int jumlahDoublePosisiGanjil(long kode) {
            String stringkode = "" + kode;
    
            if (kode < 1) {
                return 0;
            }
            
            else if (stringkode.length()%2 != 0){
                // Jika hasil kalinya dua digit bawa ke method getDigit
                if (kode%10 >= 5) {
                    int intKode = (int) (getDigit((int) (kode % 10)) + jumlahDoublePosisiGanjil(kode/100));
                    return intKode;
                }
    
                else {
                    int intKode = (int) ((2 * (kode % 10)) + jumlahDoublePosisiGanjil(kode/100));
                    return intKode;
                }
    
            }
    
            else {
                return jumlahDoublePosisiGanjil(kode/10);
            } 
        }
      
        // Meghitung total nilai puluhan dan satuan 
        public static int getDigit(int number) {
            if (number * 2 >= 10) {
                int puluhan = (number * 2) / 10;
                int satuan  = (number * 2) % 10;
                number = puluhan + satuan ;
            }
      
            return number;
        }
    
      
        // Menghitung total digit genap
        public static int jumlahPosisiGenap(long kode) {
      
            String stringkode = "" + kode;
    
            if (kode < 1) {
                return 0;
            }
            
            else if (stringkode.length() % 2 == 0) {
            int intKode = (int) (kode % 10 + jumlahPosisiGenap(kode / 100));
            return intKode;    
            }
            
            else {
                return jumlahPosisiGenap(kode / 10);
            } 
        }
      
        // Mengecek kevalidan dari prefik kode
        public static boolean cekPrefix(long kode) {
            String stringkode = "" + kode;
            if (stringkode.startsWith("2") || stringkode.startsWith("18")) {
                return true;
            }
                  
            return false;
        }
      
        // Menghitung panjang kode
        public static int getPanjangKode(long kode) {
            String stringKode = "" + kode; 
            int panjangKode = stringKode.length();
          
            return panjangKode;
        }
      
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
      
            while (n-- > 0) {
                long kode = sc.nextLong();
                System.out.println(isValid(kode) ? "YES" : "NO");
            }
            
          sc.close();
        }
      
}
