abstract class Mobil {
    private String nama;
    private int persenFuel;
    private String bahanBakar;
    private String jenis;
    private EngineBehaviour engineBehaviour;
    private boolean isOn;

    // Constructor
    protected Mobil(String nama, EngineBehaviour engineBehaviour, String bahanBakar, String jenis) {
        this.nama = nama;
        this.engineBehaviour = engineBehaviour;
        this.bahanBakar = bahanBakar;
        this.jenis = jenis;
        this.persenFuel = 100;
    }

    // Start method
    public String start() {
        this.isOn = true;
        return this.engineBehaviour.start(this);
    }

    // Gas method
    public String gas() {
        // Jika mesin menyala
        if (this.getIsOn()) {
            this.setPersenFuel(this.engineBehaviour.gas(persenFuel));

            // jika bensin habis
            if (this.getPersenFuel() < 0) {
                return "Bensin Habis!";
            }

            // Jika bensin masih ada
            else {
                String tempat = null;

                // Jika mobil terbang
                if (this.jenis.equals("Terbang")) {
                    tempat = "Langit";

                    // Jika mobil truk
                } else if (this.jenis.equals("Truk")) {
                    tempat = "Jalan Raya";

                    // Jika mobil air
                } else {
                    tempat = "Laut";

                }
                return String.format("%s digas dengan cepat di %s! Bahan bakar mobil %s sekarang %d %%.",
                        this.getNama(), tempat, this.getBahanBakar(), this.getPersenFuel());
            }

        }

        // Jika mesin mati
        return "Nyalakan mobil dulu!";
    }

    // Stop method
    public String stop() {
        this.isOn = false;
        return this.engineBehaviour.stop(this);
    }

    // abstract method untuk di implementasi pada subclass

    public abstract String isiBahanBakar();

    public abstract String[] simulasi();

    // Getter & Setter atribut

    public String getNama() {
        return this.nama;
    }

    public int getPersenFuel() {
        return this.persenFuel;
    }

    public void setPersenFuel(int persenFuel) {
        this.persenFuel = persenFuel;
    }

    public String getBahanBakar() {
        return this.bahanBakar;
    }

    public boolean getIsOn() {
        return this.isOn;
    }

}