public class Pesanan implements Comparable<Pesanan> {
    // TODO: tambahkan attributes
    private String nama;
    private int harga;
    private int prioritas;

    public Pesanan(String nama, int harga, int prioritas) {
        // TODO: Lengkapi Constructor berikut
        this.nama = nama;
        this.harga = harga;
        this.prioritas = prioritas;

    }

    // Membandignkan berdasarkan prioritas
    @Override
    public int compareTo(Pesanan o) {
        // TODO: Lengkapi method ini
        if (this.getPrioritas() > o.getPrioritas()) {
            return 1;
        }
        return -1;

    }

    // Tambahkan getter-setter bila diperlukan

    public int getPrioritas() {
        return prioritas;
    }

    public String getNama() {
        return nama;
    }
}