import java.util.Scanner;
public class PerkalianDigit {
    public static void main(String[] Args){
        int r, n, num,
        mul = 1;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number between 0 and 1000:");
        n = sc.nextInt();
        num = n;
        if (num > 0 & num < 1000 ){
            while (num > 0){
                r = num % 10;
                mul = mul * r;
                num = num / 10;
            } 
            System.out.print("The multiplication of all digit in " + n + " is " + mul );           
        }      
        else {
            System.out.print("Wrong input");
        }
    
        
   
    }
}
