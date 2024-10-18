public class Pelanggan {

    // Insialisasi atribut
    private String nama;
    private int uang;
    private Order[] keranjang;
    private int dayaTampungKeranjang;
    private static final int kapasitasKeranjang = 5000;
    private int numKeranjang;

    // Constructor Pelanggan
    public Pelanggan(String nama, int uang, int kapasitas) {
        this.nama = nama;
        this.uang = uang;
        this.dayaTampungKeranjang = kapasitasKeranjang;
        this.keranjang = new Order[kapasitas];
        this.numKeranjang = 0;
    }

    // Method untuk memnambah barang ke keranjang
    public String addBarang(Barang barang, int banyakBarang) {
        if (barang.cekStock(barang.getStock())) {
            if (barang.getStock() >= banyakBarang) {
                if (dayaTampungKeranjang >= (barang.getBeratBarang() * banyakBarang)) {

                    barang.setStock(barang.getStock() - banyakBarang);
                    dayaTampungKeranjang -= barang.getBeratBarang() * banyakBarang;
                    return nama + " berhasil menambahkan " + banyakBarang + " " + barang.getNama();

                } else {
                    int i = 1;
                    while (dayaTampungKeranjang >= 0) {
                        dayaTampungKeranjang -= barang.getBeratBarang();
                        i++;
                    }
                    return "Maaf " + banyakBarang + " " + barang.getNama() + " terlalu berat, tetapi " + i + " "
                            + barang + " berhasil ditambahkan";
                }

            } else {
                return "Stock " + barang.getNama() + " kurang";
            }

        }
        return "Stock " + barang.getNama() + "tidak ada";
    }

    // Method untuk menghitung total harga barang
    public int totalHargaBarang() {
        int totalHarga = 0;
        if (this.keranjang == null) {
            totalHarga = 0;
        } else {
            for (int i = 0; i < this.keranjang.length; i++) {
                totalHarga += ((this.keranjang[i].getBarang().getHarga()) * (this.keranjang[i].getBanyakBarang()));
            }
        }

        return totalHarga;
    }

    // Getter untuk mengecek uan
    public String cekUang() {
        return "Uang " + this.nama + " = " + getUang();
    }

    // Getter nama pelanggan
    public String getNama() {
        return this.nama;
    }

    // Setter nama pelanggan
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    // Getter uang
    public int getUang() {
        return this.uang;
    }

    // Setter uang
    public void setUang(int uang) {
        this.uang = uang;
    }
    
    // Setter keranjang
    public void setKeranjang(Order aBarang) {
        this.keranjang[this.numKeranjang++] = aBarang;
    }

    // Getter keranjang
    public Order[] getKeranjang() {

        return keranjang;
    }

}