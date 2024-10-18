public class Dokter extends Warga {
	// Inisiasi atribut
	private int jumlahPasienDitemui;
	private String penyakitKeahlian;
	private boolean dokterRamah;

	// Constructor
	public Dokter(String nama, String penyakitKeahlian, boolean dokterRamah) {
		super(nama);
		this.penyakitKeahlian = penyakitKeahlian;
		this.dokterRamah = dokterRamah;
	}

	// Method berinteraksi
	@Override
	public void berinteraksi(Warga X) {
		if (X instanceof Pasien) {
			this.jumlahPasienDitemui++;

		}
		super.addLogInteraksi(X);

	}

	// method toString untuk print class
	@Override
	public String toString() {
		return super.toString();
	}

	// Getter jumlah pasien yang ditemui
	public int getJumlahPasienDitemui() {
		return this.jumlahPasienDitemui;
	}

	// Getter penyakit keahlian
	public String getPenyakitKeahlian() {
		return this.penyakitKeahlian;
	}

	// Getter mengenai keramahan dokter
	public boolean getDokterRamah() {
		return this.dokterRamah;
	}

	// checker apakah penyakit bisa disembuhkan dokter
	public boolean bisaMenyembuhkan(String namaPenyakit){
		return this.getPenyakitKeahlian().equalsIgnoreCase(namaPenyakit);
	}

}
