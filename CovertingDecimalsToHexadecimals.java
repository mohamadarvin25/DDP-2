/*
Name : Mohamad Arvin Fadriansya
NPM : 2006596996
Desc. : Program ini akan mengubah bilangan decimal ke hexadecimal
*/

import java.util.Scanner;
public class CovertingDecimalsToHexadecimals {
    public static void main(String[] Args){
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan angka decimal: ");
        int numberInDecimal =  input.nextInt();
        
        int remainder; // Sisa pembagian input dibagi 16
        String numberInHexadecimal = "";  

        char hex[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        while (numberInDecimal != 0){
            remainder = numberInDecimal % 16;
            numberInHexadecimal = hex[remainder] + numberInHexadecimal ;
            numberInDecimal /= 16;
        }
        System.out.print(numberInHexadecimal);

    }
}
