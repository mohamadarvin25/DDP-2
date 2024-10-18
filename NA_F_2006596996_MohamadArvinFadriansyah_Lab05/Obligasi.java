
public class Obligasi extends Aset {
	// TODO lengkapi visibility modifier atribut dan methods berikut
	private double bunga;
	private int maturitas;
	private static boolean jatuhTempo = false;

	Obligasi(String nama, int jumlah, double harga, double bunga, int maturitas) {
		// TODO lengkapi constructor ini
		super(nama, jumlah, harga);
		this.bunga = bunga;
		this.maturitas = maturitas;
	}

	@Override
	public void nextYear() {
		if (super.getTahun() == maturitas) {
			super.setHarga(super.getHarga());
		}
		// validasi jatuh tempo

		super.nextYear();
		super.setHarga(super.getHarga() * bunga);
		// tambahkan bunga ke total pendapatan Pacilnomo

	}

	// Method untuk output dari kelas
	@Override
	public String toString() {
		return ("harga" + super.getHarga() + "jumlah" + super.getJumlah() + "maturitas" + maturitas);

	}

	// Setter dan getter tiap atribut

	public double getBunga() {
		return bunga;
	}

	public int getMaturitas() {
		return maturitas;
	}

	public void setBunga(double bunga) {
		this.bunga = bunga;
	}

	public void setMaturitas(int maturitas) {
		this.maturitas = maturitas;
	}

}
