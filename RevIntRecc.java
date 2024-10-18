/*
Name : Mohamad Arvin Fadriansya
NPM : 2006596996
Desc. : Program untuk mereverse posisi angka
*/


public class RevIntRecc {
    public static void main(String[] args){
        System.out.println(revInt(0));
        System.out.println(revInt(34287));
        System.out.println(revInt(1234567));
    }

    public static long revInt(long num){
        return revIntRecc(num, 0);
    }
    public static long revIntRecc(long num, long acc){
        
        if (num == 0){
            return acc;
        }

        long digitTerakhir = num % 10;
        num = num / 10;
        acc = acc * 10 + digitTerakhir ;
        return revIntRecc(num, acc);
        
        
        
        
    }

   
}
