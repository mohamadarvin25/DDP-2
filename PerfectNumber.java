/*
Name : Mohamad Arvin Fadriansya
NPM : 2006596996
Desc. : Program ini mencari perfect number antara 0 sampai 10000
*/

public class PerfectNumber {
    public static void  main(String[] Args){
        int faktor = 0;
        for (int n = 2 ; n < 10000 ; n++){
            for(int i=1; i<n ; i++){
                if (n%i == 0){
                    faktor += i;                   
                }                       
            }
            
            if (n == faktor){
                System.out.println(n);
            } 

            faktor = 0;               
        }            
    }
}