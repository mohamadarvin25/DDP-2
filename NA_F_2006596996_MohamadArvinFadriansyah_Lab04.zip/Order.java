  public class Order {

    // Insialisasi Atribut
    private Barang barang;
    private int banyakBarang;

    // Counstructor Order
    public Order(Barang barang, int banyakBarang) {
        this.barang = barang;
        this.banyakBarang = banyakBarang;
    }

    // Getter barang
    public Barang getBarang() {
        return this.barang;
    }

    // Getter banyak barang
    public int getBanyakBarang() {
        return this.banyakBarang;
    }

    // Setter barang
    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    // Setter banyak barang
    public void setBanyakBarang(int banyakBarang) {
        this.banyakBarang = banyakBarang;
    }
}