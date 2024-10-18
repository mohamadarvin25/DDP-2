public class ShopCart {
    private Product[] products;
    private int size;

    private static final int MAX_SIZE = 10;

    public ShopCart(int maxSize){
        this.products = new Product[maxSize];
        this.size = 0;
    }

    public ShopCart(){
        this(MAX_SIZE);
    }

    // menambahkan sebuah product ke dalam daftar product
    public void add(Product product){
        this.products[this.size] = product;
        this.size++;


    }

    // memperbesar ukuran array products menjadi 2 kali lipat
    // PPPOOOO -> PPPOOOOOOOOOOO
    // P berisi product, O berisi null/kosong
    // size tetap sama!
    private void enlarge() {
    Product[] newProducts = new Product[(this.products.length)*2];
    for(int i=0 ; this.products.length; i++){
        newProducts[i] =  this.products[i];
    }
    products = newProducts;
    }

    // hapus semua product pada daftar yang mempunyai nama
    // yang sama dengan nama pada argumen method
    // mungkin perlu shift/menggeser beberapa object Product pada array
    public void delete(String nama) {
        int pointer = 0;
        for(int i =0; products.length; i++){
            if(products[i].equals(nama)){
                products[i] =  null;
            }
            else{
                products[pointer] = products[i];
                pointer++;
            }
        }


        


    }
    
}
