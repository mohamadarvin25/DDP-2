public class Order {
    Barang barang;
    int banyakBarang;

    public Order(Barang barang, int banyakBarang) {
      this.barang = barang;
      this.banyakBarang = banyakBarang;
    }

    Barang getBarang() {
      return barang;
    }

    int getBanyakBarang(){
      return banyakBarang;
    }

    void setBanyakBarang(int banyakBarang){
      this.banyakBarang = banyakBarang;
    }
}