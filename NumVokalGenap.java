public class NumVokalGenap {
    static char[] valueToChar = "aiueo".toCharArray();
    public static void main(String[] args){
        System.out.println(isNumVokalGenap(""));
        System.out.println(isNumVokalGenap("abc"));
        System.out.println(isNumVokalGenap("aduh"));
        System.out.println(isNumVokalGenap("akiku"));

    }

    public static boolean isNumVokalGenap(String word){
        // Inisiasi nilai count
        int count = 0 ;          

        for (int x = 0 ; x < word.length() ; x++) {
            for(int y = 0 ; y < valueToChar.length ; y++) {
                if (word.charAt(x) == valueToChar[y]) {
                    count ++;
                }
            }
        }
        
        return count % 2 == 0;    

    }
    
}
