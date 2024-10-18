
public class Obligasi extends Aset {
	private double bunga;
	private int maturitas;
	private boolean jatuhTempo = false;
	
	public Obligasi(String nama, int jumlah, double harga, double bunga, int maturitas) {
		super(nama, jumlah, harga);
		this.bunga = bunga;
		this.maturitas = maturitas;
		// TODO 
	}
	
	@Override
	public void nextYear() {
		if(jatuhTempo) return;
		if(tahun >= maturitas) jatuhTempo = true;
		super.nextYear();
		// TODO tambahkan bunga ke pendapatan PacilTrade 
		Pacilnomo.addToEarnings(bunga * harga * jumlah);
	}

	@Override
	public String toString() {
		return String.format("%s\nTipe: Obligasi\nHarga: %.2f\nJumlah: %d\nBunga: %.2f\nJatuh Tempo: %b", nama, harga, jumlah, bunga, jatuhTempo);
	}

	public double getBunga() {
		return bunga;
	}

	public void setBunga(double bunga) {
		this.bunga = bunga;
	}
	
	public int getMaturitas() {
		return maturitas;
	}

	public void setMaturitas(int maturitas) {
		this.maturitas = maturitas;
	}
	
	public boolean isJatuhTempo() {
		return jatuhTempo;
	}

	public void setJatuhTempo(boolean jatuhTempo) {
		this.jatuhTempo = jatuhTempo;
	}

}
