import java.io.*;
import java.util.Scanner;

public class Kuis {
    public static void main(String[] args) {
        try {
            // berpotensi FileNotFoundException
            Scanner input = new Scanner(new File("input.txt"));

            // berpotensi FileNotFoundException
            PrintWriter output = new PrintWriter("output.txt");

            try {
                int j = 1;
                while (input.hasNext()) {
                    String baris = input.nextLine();
                    
                    if (baris.length() > 50) {
                        throw new LineTooLongException("baris terlalu panjang, maksimal 50 karakter");
                    }

                    output.println(String.format("[baris %d] %s", j, baris));
                    j++;
                }

            } finally {
                input.close();
                output.close();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found: " + e.getMessage());
        } catch (LineTooLongException e) {
            System.out.println(e.getMessage());
        }
    }
}