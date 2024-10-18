import java.util.Scanner;

public class  WordProcessing{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan sebuah kata: ");
        String word = input.nextLine();

        if (isDoubloon(word)) {
            System.out.println("kata " + word + " adalah doubloon.");
        } else {
            System.out.println("kata " + word + " adalah bukan doubloon.");
        }
    }

    public static int countLetter(String word, char c) {
        int count = 0;
        for (int i = 0 ; i< word.length() ; i++ ){
            if (word.charAt(i) == c){
                count += 1;
            }
        }
        return count;

    }  

    public static boolean isDoubloon(String word) {
        for (int i = 0 ; i < word.length() ; i++){
            if (countLetter(word, word.charAt(i)) != 2){
                return false;
            }
        }
        return true;       
    
    }
}

        











