public class Barang {
    private String nama;
    private int harga;
    private int beratBarang;
    private int stock;

    // Constructor
    public Barang(String nama, int harga, int beratBarang, int stock) {
        this.nama = nama;
        this.harga = harga;
        this.beratBarang = beratBarang;
        this.stock = stock;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga(){
        return harga;
    }
    
    public int getBerat(){
        return this.beratBarang;
    }

    public int getStock() {
        return stock;
    }

    void setStock(int stock) {
        this.stock = stock;
    }

    // Ini untuk mengecek stock barang apakah masih tersedia
    boolean cekStock(int kuantitas){
        if(this.stock>=kuantitas){
          return true;
        }
        return false;
    }
}
