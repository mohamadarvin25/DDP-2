import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Kuis {
    public static void main(String[] args) {
        try {
            // membuat File object
            File file = new File("input.txt");

            // membuat object Scanner dengan input dari file
            // berpotensi FileNotFoundException
            Scanner input = new Scanner(file);

            // membaut object PrintWrite untuk tulis file teks
            // berpotensi FileNotFoundException
            PrintWriter output = new PrintWriter("output.txt");

            try {

                // lengkapi bagian di dalam blok try ini
                // 1. loop ke setiap baris di input.txt dengan method hasNext()
                while (input.hasNext()){
                    String namaProduk = input.next();
                    int banyakUnit = input.nextInt();
                    double hargaSatuan = input.nextDouble();

                    if (banyakUnit < 0){
                        throw new NegativeInputException(String.format("kuantitas %s tidak boleh negatif", namaProduk));

                    }

                    if (hargaSatuan < 0){
                        throw new NegativeInputException(String.format("Harga %s tidak boleh negatif", namaProduk));
                    }

                    double hargaTotal = banyakUnit * hargaSatuan;
                    output.println(namaProduk + " "  + hargaTotal);

                }

                // 2. baca setiap baris dengan beberapa method pada Scanner, seperti
                // nextDouble().
                // Ingat bahwa method-method ini berpotensi melempar InputMismatchException
                // 3. jika banyak unit atau harga satuan NEGATIF, lempar custom exception
                // NegativeInputException (lihat di bagian akhir soal ini).
                // 4. hitung total harga dan tulis ke output.txt

            } finally {
                input.close();
                output.close();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Wrong format on input file");
        } catch (NegativeInputException e) {
            System.out.println(e.getMessage());
        }
    }
}