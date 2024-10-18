public class Pasien extends Warga {
	// Inisiasi atribut
	private int happiness;
	private String penyakit;
	private boolean pasienSembuh;

	// Constructor
	public Pasien(String nama, String penyakit) {
		super(nama);
		this.penyakit = penyakit;

	}

	// Method berinteraksi
	@Override
	public void berinteraksi(Warga X) {
		if (X instanceof Dokter) {
			if (((Dokter) X).bisaMenyembuhkan(this.getPenyakit()) && !this.getStatusSembuh()){
				this.pasienSembuh = true;
				this.setHappiness(this.getHappiness() + 20);
			}

			if (((Dokter) X).getDokterRamah() == true) {
				this.setHappiness(this.getHappiness() + 10);
			}

			if (((Dokter) X).getDokterRamah() == false) {
				this.setHappiness(this.getHappiness() - 5);
			}
			super.addLogInteraksi(X);
		}

		else {
			this.happiness += 5;
			super.addLogInteraksi(X);
		}

	}

	// method toString untuk print class
	public String toString() {
		return super.toString()
	}

	// Getter happiness
	public int getHappiness() {
		return this.happiness;
	}

	// Getter status sembuh
	public boolean getStatusSembuh() {
		return this.pasienSembuh;
	}

	// Getter penyakit
	public String getPenyakit() {
		return this.penyakit;
	}

	// Setter happiness
	public void setHappiness(int happiness) {
		if (happiness > 100) {
			this.happiness = 100;
		}

		else if (happiness < 0) {
			this.happiness = 0;
		}

		else {
			this.happiness = happiness;
		}

	}

	

}
