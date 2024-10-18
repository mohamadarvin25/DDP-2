/*
Name : Mohamad Arvin Fadriansya
NPM : 2006596996
Desc. : Program ini mengecek apakah sebuah matriks merupakan matriks markov
*/

import java.util.Scanner;

public class MarkovMatrix{

    public static void main(String[] args){
        double m[][] = new double[3][3];
       if (isMarkovMatrix(m)){
            System.out.println("It is a Markov matrix"); 
       }
       else{
            System.out.println("It is not a Markov matrix"); 
       }
    }

    public static boolean isMarkovMatrix(double[][] m){
        int i,j;
        Scanner in = new Scanner(System.in);
        int count = 0;
        double countColumn = 0;
        System.out.println("Enter a 3-by-3 matrix row by row: ");
        for (i = 0; i<m.length; i++){
            for (j = 0; j < m[0].length ; j++){
                m[i][j] = in.nextDouble(); 
                if (m[i][j] < 0){
                    return false;
                }           
                
            } 
                      
        }

        for (int column = 0; column < m[0].length; column++){
            for (int row = 0; row < m.length ; row++){
               countColumn += m[row][column];
              
            }
            if (countColumn == 1){
                count++;
            }
            countColumn = 0;            
        }
        return (count == 3);
    }
        
}