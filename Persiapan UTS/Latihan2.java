public class Latihan2 {
    public static void main(String[] args) {
        Product p1 = new Product("buku", 1000);
        Product p2 = new Product("buku", 1000);

        System.out.println(p1.equals(p2)); //true
        System.out.println(p1); // nama: buku dan harga: 1000
    }
}


