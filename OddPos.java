public class OddPos {
    public static void main(String[] args){
        System.out.println(oddPos("ab"));
        System.out.println(oddPos("hello"));
        System.out.println(oddPos("heey"));
        
    }

    public static String oddPos(String word){
        if (word.length() <= 1){
            return word;
        }

        else {
           word = word.charAt(0) + oddPos(word.substring(2));
           return word;
            
        
        }

   
    }
} 
