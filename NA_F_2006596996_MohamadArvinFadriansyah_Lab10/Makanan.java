// Ikuti UML Diagram

public class Makanan extends Pesanan {
    // TODO: tambahkan attributes
    private int tingkatKepedasan;

    public Makanan(String nama, int harga, int prioritas, int tingkatKepedasan) {
        // TODO: Lengkapi Constructor berikut
        super(nama, harga, prioritas);
        this.tingkatKepedasan = tingkatKepedasan;

    }

    @Override
    public String toString() {
        // TODO: return deskripsi sesuai dengan ketentuan soal
        return String.format("%s level %d telah disajikan", this.getNama(), this.getTingkatKepedasan());
    }

    // Tambahkan getter-setter apabila diperlukan
    @Override
    public String getNama() {
        // TODO Auto-generated method stub
        return super.getNama();
    }

    public int getTingkatKepedasan() {
        return tingkatKepedasan;
    }
}
