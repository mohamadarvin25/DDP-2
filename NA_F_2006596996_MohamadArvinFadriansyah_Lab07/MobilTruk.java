// Mobil Truk IS-A mobil
public class MobilTruk extends Mobil {

    // Constructor
    public MobilTruk(String nama, EngineBehaviour engineBehaviour, String bahanBakar) {
        super(nama, engineBehaviour, bahanBakar, "Truk");
    }

    // Method untuk mengisi bahan bakar
    @Override
    public String isiBahanBakar() {
        // jika mesih masih menyala
        if (super.getIsOn()) {
            return "Mobil masih menyala, matikan terlebih dahulu agar tidak meledak.";
        }

        // Jika mesin sudah mati
        super.setPersenFuel(100);
        return String.format("%s sekarang sudah penuh, mobil dapat digaskeun kembali!", super.getBahanBakar());
    }

    // Method untuk simulasi mobil
    @Override
    public String[] simulasi() {
        return new String[] { super.start(), super.gas(), super.gas(), super.gas(), super.gas(), super.stop(),
                this.isiBahanBakar() };

    }

}