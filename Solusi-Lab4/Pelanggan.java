public class Pelanggan {
    private String nama;
    private int uang;
    private Order[] keranjang;

    int kapasitasKeranjang = 5000; // Default kapasitas keranjang 

    // Constructor
    public Pelanggan(String nama, int uang, int kapasitas){
        this.nama = nama;
        this.uang = uang;
        keranjang = new Order[kapasitas];
    }

    // Mengecek apakah berat saat barang tersebut masuk masih dapat dimuat di keranjang atau tidak
    public boolean cekBerat(Barang barang, int banyakBarang) {
        return kapasitasKeranjang >= barang.getBerat()*banyakBarang;
    }
    
    //Method mencari index untuk addBarang
    public int findIndex(Barang barang){
        int index = 0;
        for(int i=0;i < keranjang.length; i++){
            
            // Apabila menemukan posisi keranjang yang belum diisi Order barang apa pun
            if(keranjang[i] == null){
                index = i;
                break;
            }
            
            // Menemukan posisi Order barang tersebut
            if(keranjang[i].getBarang().equals(barang)){
                index = i;
                break;
            }
        }
        return index;
    }

    public String addBarang(Barang barang, int banyakBarang){
        //Mencari index yang sesuai
        int index = findIndex(barang);
        
        //Mengecek Stock yang dapat masuk ke keranjang
        boolean cekStock = barang.cekStock(banyakBarang);
        
        //Jika Stock habis
        if(!cekStock) {
            return String.format("Stock %s kurang%n",barang.getNama());
        } 
        else {
            //Mengecek berat barang yang akan masuk
            boolean cekBerat = cekBerat(barang, banyakBarang);
            
            if(cekBerat){
                if(keranjang[index]!=null){
                    //Menambahkan banyakBarang Order jika sudah ada Order dengan barang yang sama
                    keranjang[index].setBanyakBarang(keranjang[index].getBanyakBarang()+banyakBarang);
                }else{
                    //Membuat Order baru apabila belum ada Order dengan barang yang sesuai
                    keranjang[index]= new Order(barang, banyakBarang);
                }
                
                //Set stock barang yang baru
                barang.setStock(barang.getStock()-banyakBarang);
                
                //Update kapasitasKeranjang
                kapasitasKeranjang-=barang.getBerat()*banyakBarang;
                
                // Output
                return String.format("%s berhasil menambahkan %d %s\n",this.nama,banyakBarang,barang.getNama());
            } 
            else {
                int banyak = 0;
                for(int j = banyakBarang; j>=0; j--){
                    // Mencari jumlah barang yang beratnya mencukupi kapasitas keranjang sekarang
                    if(cekBerat(barang, j)) {
                        banyak = j;
                        break;
                    }
                }
                
                if(keranjang[index] != null) {
                    //Menambahkan banyakBarang Order jika sudah ada Order dengan barang yang sama
                    keranjang[index].setBanyakBarang(keranjang[index].getBanyakBarang()+banyak);
                } else {
                    //Membuat Order baru apabila belum ada Order dengan barang yang sesuai
                    keranjang[index] = new Order(barang, banyak);
                }
                
                // Menge-set stock barang tersebut (sekarang sudah berkurang karena diambil)
                barang.setStock(barang.getStock() - banyak);
                kapasitasKeranjang -= barang.getBerat()*banyak;
                
                return String.format("Maaf %d %s terlalu berat, tetapi %d %s berhasil ditambahkan\n", banyakBarang, barang.getNama(), banyak,barang.getNama());
            }
        }
    }
    

    public int totalHargaBarang(){
        int res = 0;
        for(int i = 0; i < this.keranjang.length; i++){
          if(keranjang[i] == null) continue;
          // Mengambil harga dari Barang yang diakses kemudian dikalikan dengan banyaknya
          res += keranjang[i].getBarang().getHarga() * keranjang[i].getBanyakBarang();
        }
        return res;
    }
    
    public String cekUang(){
        return String.format("Uang %s sekarang %d%n", nama, uang);
    }
    
    // Setter Getter
    public int getUang(){
        return this.uang;
    }

    public void setUang(int uang){
        this.uang = uang;
    }
    
    public String getNama(){
        return this.nama;
    }
    
    public Order[] getKeranjang(){
        return keranjang;
    }
    
    
    // Untuk mengosongkan kembali isi dari seluruh keranjang Pelanggan
    public void resetKeranjang(int banyakBarang){
        this.kapasitasKeranjang = 5000;
        this.keranjang = new Order[banyakBarang];
    }

}

