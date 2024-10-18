import java.io.*;
import java.util.*;

public class Kasir {

    // Insialisasi atribut
    private static InputReader in = new InputReader(System.in);
    private static PrintWriter out = new PrintWriter(System.out);
    // Gunakan out sebagai pengganti System.out
    // out ini akan menahan output sampai dia di-(close/flush)
    // Contoh jika ingin print("merah"), maka tulis out.print("merah")

    private static Barang[] barang;
    private static Pelanggan[] pelanggan;
    private static int N, M;

    // Method untuk mencari pelanggan
    public static Pelanggan cariPelanggan(String nama) {
        for (Pelanggan p : pelanggan) {
            if (nama.equals(p.getNama())) {
                return p;
            }
        }
        return null;
    }

    // Method untuk mencari barang 
    public static Barang cariBarang(String namaBarang) {
        for (Barang b : barang) {
            if (namaBarang.equals(b.getNama())) {
                return b;
            }
        }
        return null;
    }

    // Method untuk pembeliab barang di kasir
    public static void kasir(Pelanggan K) {
        if (K.getKeranjang() == null) {
            out.print("Maaaf tidak ada barang di keranjang " + K.getNama());
        } else if (K.totalHargaBarang() < K.getUang()) {
            out.print("Maaf " + K.getNama() + " tidak memiliki cukup uang");
        } else {
            out.print("Pembelian " + K.getNama() + " berhasil");
        }

    }

    public static void main(String[] args) {
        N = in.nextInt();
        barang = new Barang[N];
        for (int i = 0; i < N; i++) {
            String namaBarang = in.next();
            int hargaBarang = in.nextInt();
            int beratBarang = in.nextInt();
            int stock = in.nextInt();

            // Counstruct objek barang
            barang[i] = new Barang(namaBarang, hargaBarang, beratBarang, stock);
           
        }

        M = in.nextInt();
        pelanggan = new Pelanggan[M];
        for (int j = 0; j < M; j++) {
            String namaPelanggan = in.next();
            int uang = in.nextInt();

            // Construct objek pelanggan
            pelanggan[j] = new Pelanggan(namaPelanggan, uang, N);

            
        }

        int P = in.nextInt();
        for (int k = 0; k < P; k++) {
            String command = in.next();

            if (command.equals("ADD")) {
                String namaPelanggan = in.next();
                String namaBarang = in.next();
                int banyakBarangDiambil = in.nextInt();

                Pelanggan plg = cariPelanggan(namaPelanggan);
                out.print(plg.addBarang(cariBarang(namaBarang), banyakBarangDiambil));
            }

            if (command.equals("TOTAL_HARGA")) {
                String namaPelanggan = in.next();
                Pelanggan plg = cariPelanggan(namaPelanggan);
                out.printf("Total harga belanjaan %s adalah %d%n", plg.getNama(), plg.totalHargaBarang());
            }

            if (command.equals("KASIR")) {
                String namaPelanggan = in.next();
                Pelanggan plg = cariPelanggan(namaPelanggan);
                kasir(plg);
            }

            if (command.equals("CEK_UANG")) {
                String namaPelanggan = in.next();
                Pelanggan plg = cariPelanggan(namaPelanggan);
                out.print(plg.cekUang());
            }
        }

        // don't forget to close/flush the output
        out.close();
    }

    // taken from https://codeforces.com/submissions/Petr
    // together with PrintWriter, these input-output (IO) is much faster than the
    // usual Scanner(System.in) and System.out
    public static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}