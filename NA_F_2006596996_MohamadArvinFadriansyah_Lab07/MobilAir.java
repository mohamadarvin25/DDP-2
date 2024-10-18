// Mobil Air IS-A mobil
public class MobilAir extends Mobil {

    // Constructor
    public MobilAir(String nama, EngineBehaviour engineBehaviour, String bahanBakar) {
        super(nama, engineBehaviour, bahanBakar, "Air");
    }

    // Method untuk mengisi bahan bakar
    @Override
    public String isiBahanBakar() {
        // jika mesih masih menyala
        if (super.getIsOn()) {
            return "Mobil masih menyala, matikan terlebih dahulu agar tidak tenggelam.";
        }

        // Jika mesin sudah mati
        super.setPersenFuel(100);
        return String.format("%s sekarang sudah penuh, mobil dapat digunakan kembali!", super.getBahanBakar());
    }

    // Method untuk simulasi mobil
    @Override
    public String[] simulasi() {
        return new String[] { super.start(), super.gas(), super.gas(), super.gas(), super.gas(), super.gas(),
                super.stop(), this.isiBahanBakar() };
    }
}