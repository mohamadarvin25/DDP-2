// Ikuti UML diagram

public class Minuman extends Pesanan {
    // TODO: tambahkan attributes
    private boolean isPakeEs;

    public Minuman(String nama, int harga, int prioritas, boolean isPakeEs) {
        // TODO: Lengkapi Constructor berikut
        super(nama, harga, prioritas);
        this.isPakeEs = isPakeEs;

    }

    @Override
    public String toString() {
        // TODO: return deskripsi sesuai dengan ketentuan soal

        // Dingin
        if (isPakeEs) {
            return String.format("%s dingin telah disajikan", this.getNama());

        }

        // Hangat
        else {
            return String.format("%s hangat telah disajikan", this.getNama());
        }
    }

    // Tambahkan getter-setter bila diperlukan
    @Override
    public String getNama() {
        // TODO Auto-generated method stub
        return super.getNama();
    }
}
