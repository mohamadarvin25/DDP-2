import java.io.*;
import java.util.*;

public class Kasir{
    private static InputReader in = new InputReader(System.in);
    private static PrintWriter out = new PrintWriter(System.out);

    static Barang[] daftarBarang;
    static Pelanggan[] daftarPelanggan;
    static int N, M;

    static void kasir(Pelanggan K) {
        int totalHarga = K.totalHargaBarang();

        if(totalHarga == 0) {
            out.printf("Maaf tidak ada barang di keranjang %s\n", K.getNama());
        } 
        else if(K.getUang() < totalHarga){
            out.printf("Maaf %s tidak memiliki cukup uang\n", K.getNama());
        } 
        else {
            out.printf("Pembelian %s berhasil:\n", K.getNama());
            //Get Keranjang Pelanggan
            Order[] keranjang = K.getKeranjang();
            
            //Mengiterasi Keranjang dan mencetak barang banyakBarang = kalkulasi harga
            for(int i = 0; i < N; i++){
                if(keranjang[i] != null){
                    if(keranjang[i].getBanyakBarang() == 0) continue;
                    out.printf("* %s %d = %d\n", keranjang[i].getBarang().getNama(), keranjang[i].getBanyakBarang(), keranjang[i].getBarang().getHarga() * keranjang[i].getBanyakBarang());
                }
            }
            //Mencetak totalHarga dan sisa uang Pelanggan
            out.printf("* Total Belanjaan = %d\n", totalHarga);
            K.setUang(K.getUang() - totalHarga);

            out.printf("* Sisa Uang = %d\n", K.getUang());
            
            K.resetKeranjang(N);
        }

    }

    static Pelanggan cariPelanggan(String nama) {
        for(Pelanggan p: daftarPelanggan) {
            if(nama.equals(p.getNama())) {
                return p;
            }
        }
        return null;
    }
    
    static Barang cariBarang(String namaBarang) {
        for(Barang b: daftarBarang) {
            if(namaBarang.equals(b.getNama())) {
                return b;
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        N = in.nextInt(); // Read value of N
        daftarBarang = new Barang[N];
        for(int i = 0; i < N; i++){

            String namaBarang = in.next();
            int hargaBarang = in.nextInt();
            int beratBarang = in.nextInt();
            int stock = in.nextInt();

            // Construct Barang dan menyimpannya ke daftarBarang
            Barang barangBaru = new Barang(namaBarang, hargaBarang, beratBarang, stock);
            daftarBarang[i] = barangBaru;
        }

        M = in.nextInt(); // Read value of M
        daftarPelanggan = new Pelanggan[M];
        for(int j = 0; j < M; j++){
            String namaPelanggan = in.next();
            int uang = in.nextInt();
            
            // Construct Pelanggan dan menyimpannya ke daftarPelanggan
            Pelanggan pelangganBaru = new Pelanggan(namaPelanggan, uang, N);
            daftarPelanggan[j] = pelangganBaru;
        }

        int P = in.nextInt(); // Read value of P
        for(int k = 0; k < P; k++){
          
            String command = in.next();
            if(command.equals("ADD")) {

                String namaPelanggan = in.next();
                String namaBarang = in.next();
                int banyakBarangDiambil = in.nextInt();
                
                Pelanggan plg = cariPelanggan(namaPelanggan);
                out.print(plg.addBarang(cariBarang(namaBarang), banyakBarangDiambil));
            }
          
            if(command.equals("TOTAL_HARGA")) {
                String namaPelanggan = in.next();
                Pelanggan plg = cariPelanggan(namaPelanggan);
                out.printf("Total harga belanjaan %s adalah %d%n", plg.getNama(), plg.totalHargaBarang());
            }
            
            if(command.equals("KASIR")) {
                String namaPelanggan = in.next();
                Pelanggan plg = cariPelanggan(namaPelanggan);
                kasir(plg);
            }
            
            if(command.equals("CEK_UANG")) {
                String namaPelanggan = in.next();
                Pelanggan plg = cariPelanggan(namaPelanggan);
                out.print(plg.cekUang());
            }
        }
        // don't forget to close/flush the output
        out.close();
    }

    // taken from https://codeforces.com/submissions/Petr
    // together with PrintWriter, these input-output (IO) is much faster than the usual Scanner(System.in) and System.out
    static class InputReader {
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