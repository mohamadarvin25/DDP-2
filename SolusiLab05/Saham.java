
public class Saham extends Aset {
	private double pertumbuhan;
	private double dividen;
	
	public Saham(String nama, int jumlah, double harga, double pertumbuhan, double dividen) {
		super(nama, jumlah, harga);
		this.pertumbuhan = pertumbuhan;
		this.dividen = dividen;
	}

	@Override
	public void nextYear() {
		super.nextYear();
		grow();
		// TODO modifikasi harga sesuai dengan pertumbuhan sekarang dan tambahkan dividen ke earnings
		harga += harga * pertumbuhan;
		Pacilnomo.addToEarnings(dividen * harga * jumlah);
	}

	// Linear congruential generator for subsequent growth
	private void grow() {
		int a = 0x4b;
		int c = 0x4a;
		int m = 2;
		pertumbuhan = ((a * pertumbuhan + c) % m) - 1;
		pertumbuhan = pertumbuhan < 0 ? pertumbuhan % -m : pertumbuhan;
	}

	@Override
	public String toString() {
		return String.format("%s\nTipe: Saham\nHarga: %.2f\nJumlah: %d\nDividen: %.2f\nPertumbuhan: %.2f", nama, harga, jumlah, dividen, pertumbuhan);
	}

	// TODO buat getter dan setter untuk fields pada class ini
	public double getDividen() {
		return dividen;
	}

	public void setDividen(double dividen) {
		this.dividen = dividen;
	}
	
}
