public class BookCatalogue {
    private Book[] listOfBooks;
    private int numBooks;

    private static final int MAX_BOOKS = 100;

    public BookCatalogue() {
        this.listOfBooks = new Book[MAX_BOOKS];
        this.numBooks = 0;
    }

    public void add(Book aBook) {
        this.listOfBooks[this.numBooks++] = aBook;
    }

    // kembalikan total harga dari semua buku yang ada di katalog
    // hint: pakai loop ke array of books di atas
    public double totalHarga() {
        double totalHarga = 0;
        for (int i = 0; i < this.numBooks; i++){
            totalHarga += this.listOfBooks[i].getHarga();
        }

        return totalHarga;

        // lengkapi...

    }
}