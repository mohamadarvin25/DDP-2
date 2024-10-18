import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class HealthWorthinessChecker {
    private static Mahasiswa mahasiswa;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner inputFile = null;
        PrintWriter outputFile = null;
        int jumlahMahasiswa = 0;

        System.out.println("Selamat datang di program Health Worthiness Checker.");
        System.out.println("-------------------------------------------------------");

        System.out.print("Silakan masukkan nama file masukan: ");
        String inputFileName = in.next();
        System.out.print("Silakan masukkan nama file keluaran: ");
        String outputFileName = in.next();

        System.out.println("-------------------------------------------------------");

        in.close();

        try {
            inputFile = new Scanner(new File(inputFileName));
            System.out.println("Data sedang diproses, harap menunggu...");

            String line = inputFile.nextLine();

            jumlahMahasiswa = Integer.valueOf(line);

            // Array untuk memasukkan string file input
            ArrayList<String> dataMahasiswa = new ArrayList<String>();

            // Array yang berisi objek mahasiswa
            ArrayList<Mahasiswa> kelayakanMahasiswa = new ArrayList<Mahasiswa>();

            while (inputFile.hasNextLine()) {
                line = inputFile.nextLine();

                // Memsukkan data file input dari line 2 sampai akhir
                dataMahasiswa.add(line);
            }

            // Proses data mahasiswa
            System.out.println("\nLOG:");

            // Tiap mahasiswa memiliki dua line pada input file
            for (int i = 0; i < (jumlahMahasiswa * 2); i += 2) {
                try {

                    // Indeks genap berisi nama
                    String nama = dataMahasiswa.get(i);

                    // Indek ganjil berisi data indikator kesehatan
                    String[] arrayTingkatKesehatanMahasiswa = dataMahasiswa.get(i + 1).split(" ");

                    // Penjumlahan data indikator kesehatan
                    int tingkatKesehatan = 0;
                    for (int j = 0; j < arrayTingkatKesehatanMahasiswa.length; j++) {
                        tingkatKesehatan += Integer.parseInt(arrayTingkatKesehatanMahasiswa[j]) * 2;
                    }

                    mahasiswa = new Mahasiswa(nama, tingkatKesehatan);
                    kelayakanMahasiswa.add(mahasiswa);

                    // Jika tingkat kesehatan kurang dari minimal tingkat kesehatan
                    if (mahasiswa.getStatus().equals("Tidak layak mengikuti program")) {
                        throw new HealthinessUnworthyException(String.format("%s: Tidak layak", nama));
                    } else {
                        System.out.println(String.format("%s: Layak", nama));
                    }

                    // Exception Jika tingkat kesehatan kurang dari minimal tingkat kesehatan
                } catch (HealthinessUnworthyException e) {
                    System.out.println(e.getMessage());

                }
            }

            // Output ke teks
            outputFile = new PrintWriter(new File(outputFileName));

            outputFile.write("Nama Mahasiswa          | Status\n");
            outputFile.write("-------------------------------------------------------\n");

            // Output kelayakan Mahasiwa ke teks
            for (int i = 0; i < kelayakanMahasiswa.size(); i++) {
                outputFile.write(String.format("%s", kelayakanMahasiswa.get(i)));
            }

            System.out.println("\nData mahasiswa berhasil diproses!");

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File masukan tidak ditemukan.");

            // File wajib di close!
        } finally {
            if (inputFile != null) {
                inputFile.close();
            }
            if (outputFile != null) {
                outputFile.close();
            }
        }

        System.out.println("-------------------------------------------------------");
        System.out.println("Terima kasih telah menggunakan program Health Worthiness Checker.");
    }
}
