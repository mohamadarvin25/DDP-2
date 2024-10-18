import java.util.Scanner;

public class Pacilnomo {
	private static Aset[] portofolio;
	private static double earnings;

	private static void printSeparator() {
		System.out.println("=".repeat(64));
	}
	
	// DEVNOTE pakai toString
	private static void daftarAset() {
		printSeparator();
		System.out.printf("Kamu memiliki %d total aset:\n", portofolio.length);
		for(Aset a : portofolio) {
			System.out.println("- " + a);
		}
		printSeparator();
	}

	// DEVNOTE pakai instanceof
	private static void infoPortofolio() {
		int jumlahSaham = 0, jumlahObligasi = 0;
		double netWorth = 0;
 
		// TODO implementasi info portofolio
		for(Aset a : portofolio) {
			netWorth += a.getHarga() * a.getJumlah();
			if(a instanceof Saham) {
				jumlahSaham++;
			} else if(a instanceof Obligasi) {
				jumlahObligasi++;
			}
		}

		netWorth += earnings;

		printSeparator();
		System.out.printf("""
		Info Portofolio
		Jumlah Jenis Saham: %d
		Jumlah Jenis Obligasi: %d
		Total Nilai Portofolio: %.2f
		""", jumlahSaham, jumlahObligasi, netWorth);
		printSeparator();
	}

	private static void nextYear() {
		for(Aset a : portofolio) {
			a.nextYear();
		}
		
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Silakan masukkan banyak aset yang tersedia: ");
		int banyakAset = Integer.parseInt(in.nextLine());
		
		portofolio = new Aset[banyakAset];
		
		for(int i = 0; i < banyakAset; i++) {
			System.out.printf("Aset %d: ", i + 1);
			String inp[] = in.nextLine().split("\\s+");
			String namaAset = inp[0], jenisAset = inp[1]; 
			int jumlah = Integer.valueOf(inp[2]); 
			double harga = Double.valueOf(inp[3]);
			
			// TODO tambahkan setiap aset ke asetTersedia berdasarkan jenisnya
			if(jenisAset.equals("SAHAM")) {
				double pertumbuhan = Double.valueOf(inp[4]);
				double dividen = Double.valueOf(inp[5]);
				portofolio[i] = new Saham(namaAset, jumlah, harga, pertumbuhan, dividen);
			} else if(jenisAset.equals("OBLIGASI")) {
				double kupon = Double.valueOf(inp[4]);
				int maturitas = Integer.valueOf(inp[5]);
				portofolio[i] = new Obligasi(namaAset, jumlah, harga, kupon, maturitas);
			} 
		}

		System.out.print("Selamat datang di...");
		System.out.print(""" 


							 /$$$$$$$                     /$$ /$$                                            
							| $$__  $$                   |__/| $$                                            
							| $$  \\ $$ /$$$$$$   /$$$$$$$ /$$| $$ /$$$$$$$   /$$$$$$  /$$$$$$/$$$$   /$$$$$$ 
							| $$$$$$$/|____  $$ /$$_____/| $$| $$| $$__  $$ /$$__  $$| $$_  $$_  $$ /$$__  $$
							| $$____/  /$$$$$$$| $$      | $$| $$| $$  \\ $$| $$  \\ $$| $$ \\ $$ \\ $$| $$  \\ $$
							| $$      /$$__  $$| $$      | $$| $$| $$  | $$| $$  | $$| $$ | $$ | $$| $$  | $$
							| $$     |  $$$$$$$|  $$$$$$$| $$| $$| $$  | $$|  $$$$$$/| $$ | $$ | $$|  $$$$$$/
							|__/      \\_______/ \\_______/|__/|__/|__/  |__/ \\______/ |__/ |__/ |__/ \\______/ 
																											
                                                                                 
                                                                                 """);
		
		while(true) {
			System.out.printf("""
				Silakan pilih salah satu opsi berikut:
				[1] Daftar aset
				[2] Info portofolio
				[3] Lanjut ke tahun berikutnya
				[*] Keluar\n""", earnings);
			printSeparator();
			System.out.print("Input: ");
			String pilihan = in.nextLine();
			if(pilihan.equals("1")) {
				daftarAset();
			} else if(pilihan.equals("2")) {
				infoPortofolio();
			} else if(pilihan.equals("3")) {
				nextYear();
				System.out.println("Setahun telah berlalu...");
				printSeparator();
			} else {
				System.out.println("Terima kasih telah menggunakan layanan Pacilnomo ~ !");
				break;
			}
		}
		
		in.close();
	}
	
	public static void addToEarnings(double jumlah) {
		earnings += jumlah;
	}
}
