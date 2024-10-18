public class Kuis9 {
    public static void main(String[] args) {
        Dictionary<Integer, String> dict = new Dictionary<>();

        dict.addPair(10, "Rani");
        dict.addPair(20, "Rudi");
        dict.addPair(30, "Anto");
        dict.addPair(20, "Caca"); // Rudi di-override dengan Caca

        System.out.println(dict);
        // <10, Rani><20, Caca><30, Anto>
    }
}