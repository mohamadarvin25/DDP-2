/*
Name : Mohamad Arvin Fadriansya
NPM : 2006596996
Desc. : Program untuk menghitung indeks masa tubuh
*/

import java.util.Scanner;
public class KalkulatorBMI {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Selamat datang di program kalkulator BMI!");
        System.out.println("--------------------------------------------------------");

        System.out.print("Masukkan jumlah mahasiswa yang akan dihitung datanya: ");
        int jumlahMahasiswa = sc.nextInt();

        // Inisiasi nilai
        int beratBadanDiBawahNormal = 0;
        int beratBadanNormal = 0;
        int beratBadanDiAtasNormal = 0;
        int obesitas = 0;

        
        String rumus1 = "METRIK"; 
        

        for (int i = 0 ; i < jumlahMahasiswa  ; i++){
            System.out.println("--------------------DATA MAHASISWA "+ (i+1) + " --------------------");

            System.out.print("Standar pengukuran apakah yang digunakan? ");
            String standarPengukuran = sc.next();
            
            // BMI jenis metrik
            if (standarPengukuran.equals(rumus1)) {
                System.out.print("Masukkan massa tubuh mahasiswa (kilogram): ");
                double massa = sc.nextDouble();

                System.out.print("Masukkan tinggi tubuh mahasiswa (sentimeter): ");
                double tinggi = sc.nextDouble();
                double tinggiDalamMeter = tinggi/100;

                double metrik =  massa / (tinggiDalamMeter * tinggiDalamMeter);
                
                // Klasifikasi nilai BMI
                if (metrik < 18.5){
                    beratBadanDiBawahNormal ++;  
                }
                else if (metrik <= 24.9){
                    beratBadanNormal ++;
                } 
                else if (metrik <= 29.9){
                    beratBadanDiAtasNormal ++;
                }
                else{
                    obesitas ++;
                }
                
            }
            // BMI jenis imperial
            else {             
                System.out.print("Masukkan massa tubuh mahasiswa (pon): ");
                double massa = sc.nextDouble();

                System.out.print("Masukkan tinggi tubuh mahasiswa (inci): ");
                double tinggi = sc.nextDouble();
                
                int faktorKonversi = 703;
                double imperial =  faktorKonversi * massa / (tinggi * tinggi);
                

                // Klasifikasi nilai BMI
                if (imperial < 18.5){
                    beratBadanDiBawahNormal ++;  
                }
                else if (imperial <= 24.9){
                    beratBadanNormal ++;
                } 
                else if (imperial <= 29.9){
                    beratBadanDiAtasNormal ++;
                }
                else{
                    obesitas ++;
                }
            } 
        }
         
            // Output
            System.out.println("---------------------RINGKASAN DATA---------------------");
            System.out.println("Berikut merupakan ringkasan hasil pengukuran BMI dari " + jumlahMahasiswa + " mahasiswa.");

            System.out.println("Jumlah mahasiswa dengan berat badan di bawah normal: " + beratBadanDiBawahNormal);
            System.out.println("Jumlah mahasiswa dengan berat badan normal: " + beratBadanNormal);
            System.out.println("Jumlah mahasiswa dengan berat badan di atas normal: " + beratBadanDiAtasNormal);
            System.out.println("Jumlah mahasiswa obesitas: " + obesitas); 

            System.out.println("--------------------------------------------------------");
            System.out.println("Terima kasih telah menggunakan program kalkulator BMI!");


                
            
        
    }

    
}
