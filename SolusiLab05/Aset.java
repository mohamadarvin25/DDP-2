
public class Aset {
	protected String nama;
	protected int jumlah;
	protected double harga;
	protected int tahun = 0;
	
	public Aset(String nama, int jumlah, double harga) {
		this.nama = nama;
		this.jumlah = jumlah;
		this.harga = harga;
	}
	
	public void nextYear() {
		tahun++;
	}

	// TODO buat getter dan setter untuk fields pada class ini
	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public double getHarga() {
		return harga;
	}

	public void setHarga(double harga) {
		this.harga = harga;
	}

	public int getJumlah() {
		return jumlah;
	}

	public void setJumlah(int jumlah) {
		this.jumlah = jumlah;
	}
}
