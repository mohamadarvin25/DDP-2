
public class Saham extends Aset {
	// Inisiasi atribut
	private double dividen;
	private double pertumbuhan;

	Saham(String nama, int jumlah, double harga, double pertumbuhan, double dividen) {
		super(nama, jumlah, harga);
		this.pertumbuhan = pertumbuhan;
		this.dividen = dividen;

	}

	@Override
	public void nextYear() {
		super.nextYear();
		grow();

		// TODO modifikasi harga sesuai dengan pertumbuhan sekarang dan tambahkan
		// dividen ke earnings
	}

	// Linear congruential generator for subsequent growth
	public void grow() {
		int a = 0x4b;
		int c = 0x4a;
		int m = 2;
		pertumbuhan = ((a * pertumbuhan + c) % m) - 1;
		pertumbuhan = pertumbuhan < 0 ? pertumbuhan % -m : pertumbuhan;
	}

	// Method untuk output dari kelas
	@Override
	public String toString() {
		return "harga" + super.getHarga() + "jumlah" + super.getJumlah() + "dividen" + dividen;
	}



	// Setter dan getter tiap kelas
	public double getPertumbuhan() {
		return pertumbuhan;
	}

	public double getDividen() {
		return dividen;
	}

	public void setPertumbuhan(double pertumbuhan) {
		this.pertumbuhan = pertumbuhan;
	}

	public void setDividen(double dividen) {
		this.dividen = dividen;
	}

}
