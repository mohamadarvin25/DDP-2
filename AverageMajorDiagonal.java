/*
Name : Mohamad Arvin Fadriansya
NPM : 2006596996
Desc. : Program ini mencari rata rata dari diagonal utama
*/

import java.util.Scanner;

public class AverageMajorDiagonal {

    public static void main(String[] args) {

        // Declare the m
        double m[][] = new double[4][4];
        System.out.print("Average of the elements in the major diagonal is " + averageMajorDiagonal(m));
    }

    public static double averageMajorDiagonal(double[][] m) {
        int i, j;
        Scanner in = new Scanner(System.in);

        double count = 0;

        // Read the m values
        System.out.println("Enter a 4-by-4 matrix row by row:");
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {
                m[i][j] = in.nextDouble();
                if (i == j) {
                    count += m[i][j];
                }
            }

        }

        return (count / 4);

    }

}
