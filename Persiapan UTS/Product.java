public class Product {
    private String nama;
    private int hargaSatuan;

    public Product(String nama, int hargaSatuan) {
        this.nama = nama;
        this.hargaSatuan = hargaSatuan;
    }

    public String getNama() {
        return nama;
    }

    public int getHargaSatuan() {
        return hargaSatuan;
    }

    @Override
    public String toString() {
        return String.format("nama: %s dan harga: %d", this.nama, this.hargaSatuan);

    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Product){
            return this.nama == ((Product) other).nama;
        }
        else{
            return false;
        }
    }
}