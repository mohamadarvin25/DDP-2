
public class Aset {
	// Inisiasi atribut
	private String nama;
	private int jumlah;
	private double harga;
	public static int tahun = 0;
	
	public Aset(String nama, int jumlah, double harga) {
		this.nama = nama;
		this.jumlah = jumlah;
		this.harga = harga;

	}
	
	// Increment tahun
	public void nextYear() {
		tahun++;	
	}
	
	// Setter and getter tiap atribut

	public String getNama() {
		return nama;
	}
		
	public int getJumlah() {
		return jumlah;
	}
	
	public double getHarga() {
		return harga;
	}

	public static int getTahun() {
		return tahun;
	}
	public void setHarga(double harga) {
		this.harga = harga;
	}

	public void setJumlah(int jumlah) {
		this.jumlah = jumlah;
	}
	
	public void setNama(String nama) {
		this.nama = nama;
	}


	
