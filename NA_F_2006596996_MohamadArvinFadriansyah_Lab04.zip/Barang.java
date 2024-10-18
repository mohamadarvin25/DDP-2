public class Barang {

    // Insialisasi Atribut
    private String nama;
    private int harga;
    private int beratBarang;
    private int stock;

    // Counstructor barang
    public Barang(String nama, int harga, int beratBarang, int stock) {
        this.nama = nama;
        this.harga = harga;
        this.beratBarang = beratBarang;
        this.stock = stock;

    }

    // Stock checker
    public boolean cekStock(int stock) {
        return this.stock > 0;
    }

    // Getter nama
    public String getNama() {
        return this.nama;
    }

    // Getter stock
    public int getStock() {
        return this.stock;
    }

    // Setter stock
    public void setStock(int kuantitas) {
        this.stock = kuantitas;
    }

    // Getter berat brang
    public int getBeratBarang() {
        return this.beratBarang;
    }

    // getter harga
    public int getHarga() {
        return this.harga;
    }

}
