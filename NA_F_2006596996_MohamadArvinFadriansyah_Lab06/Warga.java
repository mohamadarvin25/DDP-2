public abstract class Warga {
	// Insiasi atribut
	private String nama;
	private Warga[] logInteraksi = new Warga[0];

	// Constructor
	public Warga(String nama) {
		this.nama = nama;
	}

	// Getter nama
	public String getNama() {
		return this.nama;
	}

	// Method sengaja dikosongkan
	protected abstract void berinteraksi(Warga X) ;
	

	// Method untuk menambah log interaksi
	public void addLogInteraksi(Warga warga) {
		Warga[] newLog = new Warga[this.logInteraksi.length + 1];

		for (int i = 0; i < this.logInteraksi.length; i++) {
			newLog[i] = this.logInteraksi[i];
		}
		this.logInteraksi = newLog;

		newLog[this.logInteraksi.length - 1] = warga;
	}

	// method toString untuk print class
	@Override
	public String toString() {
		return this.getNama();
	}

	// Getter log interaksi
	public Warga[] getLogInteraksi() {
		return this.logInteraksi;
	}
}
