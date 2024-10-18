public class Latihan {
    public static void main(String[] args) {
  
      BookCatalogue bookCat = new BookCatalogue();
  
      bookCat.add(new Book("Python", "Guido", 50000));
      bookCat.add(new Book("Java", "James", 60000));
  
      System.out.println(bookCat.totalHarga());
    }      //110000

}