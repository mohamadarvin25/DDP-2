/*
Name : Mohamad Arvin Fadriansya
NPM : 2006596996
Desc. : Program ini mencari index dari angka terkecil dalam matriks
*/

import java.util.Scanner;
import java.util.Arrays;

public class LocateSmallest {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int rowAndColumn[] = new int[2];
        System.out.print("Enter the number of rows and columns of the array: ");
        for (int i = 0; i < 2; i++){
            rowAndColumn[i] = in.nextInt();
            
        }
        double a[][] = new double[rowAndColumn[0]][rowAndColumn[1]];
        System.out.println("Enter the Array: ");

        for(int row = 0; row < rowAndColumn[0]; row++){
            for(int column = 0; column < rowAndColumn[1]; column++){
                 a[row][column] = in.nextDouble();

            }
        }

      

        System.out.print("The Location of the smallest element is at " + "(" + locateSmallest(a)[0] + ", " + locateSmallest(a)[1] + ")" );
    } 
    
    public static int[] locateSmallest(double[][] a){
        double lowestNumber = a[0][0];
        int rowOfLowest = 0;
        int columnOfLowest = 0;
        for(int row = 0; row < a.length; row++){
            for(int column = 0; column < a[0].length; column++){
                    if (a[row][column] < lowestNumber){
                        lowestNumber = a[row][column];
                        rowOfLowest = row;
                        columnOfLowest = column;
                    }
            }
        }
        int[] indexOfLowestNumber = {rowOfLowest,columnOfLowest};

        return indexOfLowestNumber;
    }

}
