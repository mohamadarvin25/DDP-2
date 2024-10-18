
// apa yang harus di-import?
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Soal {
    public static void main(String[] args) {
        String filename = "input.txt";
        Scanner input = null;
        PrintWriter output = null;
        ArrayList<Integer> jumlahHurufVokalTiapKalimat = new ArrayList<Integer>();
        try {
            input = new Scanner(new File(filename));
            output = new PrintWriter("output.txt");

            while (input.hasNextLine()) {
                String sentence = input.nextLine();
                int count = 0;
                for (int i = 0; i < sentence.length(); i++) {
                    if (sentence.charAt(i) == 'a' || sentence.charAt(i) == 'i' ||
                            sentence.charAt(i) == 'u' || sentence.charAt(i) == 'e' || sentence.charAt(i) == 'o') {
                        count++;
                    }
                }
                jumlahHurufVokalTiapKalimat.add(count);

            }
            output.print(jumlahHurufVokalTiapKalimat);

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File masukan tidak ditemukan.");

        } finally {
            if (input != null) {
                input.close();
            }
            if (output != null) {
                output.close();
            }
        }

    }
}