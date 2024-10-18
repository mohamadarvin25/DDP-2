/*


 implementasikan class Book yang mempunyai 3 atribut:
 1. judul (String)
 2. author (String); asumsi penulis buku adalah tunggal
 3. harga (double)

 dan punya satu constructor yang punya 3 argumen untuk
 inisialisasi ketiga atribut tersebut.

 dan punya setter & getter untuk ketiga atribut tersebut.
*/
public class Book {

    private String judul;
    private String author;
    private double harga;

    public Book(String judul, String author, double harga){
        this.judul = judul;
        this.author = author;
        this.harga = harga;
    }

    public String getJudul(){
        return this.judul;
    }

    public String getAuthor(){
        return this.author;
    }

    public double getHarga(){
        return this.harga;
    }

    public void setJudul(String judul){
        this.judul = judul;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public void setHarga(double harga){
        this.harga = harga;
    }
    

}