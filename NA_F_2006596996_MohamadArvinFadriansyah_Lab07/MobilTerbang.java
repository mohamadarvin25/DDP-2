// Mobil terbang IS-A mobil
public class MobilTerbang extends Mobil {

    // Constructor
    public MobilTerbang(String nama, EngineBehaviour engineBehaviour, String bahanBakar) {
        super(nama, engineBehaviour, bahanBakar, "Terbang");
    }

    // Method untuk mengisi bahan bakar
    @Override
    public String isiBahanBakar() {

        // jika mesih masih menyala
        if (super.getIsOn()) {
            return "Mobil masih terbang, matikan terlebih dahulu agar tidak jatuh.";
        }

        // Jika mesin sudah mati
        super.setPersenFuel(100);
        return String.format("%s sekarang sudah penuh, mobil dapat terbang kembali!", super.getBahanBakar());
    }

    // Method untuk simulasi mobil
    @Override
    public String[] simulasi() {
        return new String[] { super.start(), super.gas(), super.gas(), super.stop(), this.isiBahanBakar() };
    }

}