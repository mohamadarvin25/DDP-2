/*
Name : Mohamad Arvin Fadriansya
NPM : 2006596996
Desc. : Program untuk membuat music player sederhana
*/

// Digunakan pada saat inisialisasi scanner
import java.util.Scanner;

public class Lab03 {
    // Inisialisasi pointer
    static int pointer = 0;

    // Inialisasi array untuk playlist musik
    static String[][] playlist = new String[1][4];

    // Inisialisasi scanner untuk input
    static Scanner in = new Scanner(System.in);

    // Inisialisai jumlah musik
    static int jumlahMusik = 0;

    public static void main(String[] args) {
        System.out.println("Selamat Datang di Pacilfy!");

        // Digunakan untuk looping
        int perintah = 1;

        // Nilainya bertambah 1 karena karena playlistnya akan diisi array musik
        jumlahMusik = 1;

        // Inisialisasi untuk melakukan input musik
        int musik = 0;

        while (perintah != 0) {

            // Berhenti ketika length playlist sama dengan length jumlah musik
            while (musik < jumlahMusik) {

                System.out.println("Silahkan masukkan lagu anda");

                // Input judul lagu
                System.out.print("Judul : ");
                playlist[musik][0] = in.nextLine();

                // Input artist
                System.out.print("Artist: ");
                playlist[musik][1] = in.nextLine();

                // Input album
                System.out.print("Album : ");
                playlist[musik][2] = in.nextLine();

                // Input tahun
                System.out.print("Tahun : ");
                playlist[musik][3] = in.nextLine();
                musik++;

            }
            System.out.println("Lanjut menambahkan lagu?");

            // ketika perintah bernilai 0 loop selsai
            System.out.println("[1] Lanjut");
            System.out.println("[0] Berhenti");
            System.out.print("Perintah: ");
            perintah = in.nextInt();

            // ketiha perintah bernilai length playlist bertambah 1
            if (perintah == 1) {
                in.nextLine();
                jumlahMusik++;

                // Temporary variable
                String[][] original = playlist;

                // Inisialiasi length baru
                playlist = new String[jumlahMusik][4];

                // Loop untuk mengcopy lagi pada playlist yang sudah ada
                for (int i = 0; i < original.length; i++) {
                    for (int j = 0; j < original[0].length; j++) {
                        playlist[i][j] = original[i][j];
                    }
                }
            }
        }
        in.nextLine();

        System.out.println("Pacilfy siap dimulai");

        System.out.println("\nSELAMAT DATANG DI\n");
        System.out.println(" /$$$$$$$                     /$$ /$$  /$$$$$$");
        System.out.println("| $$__  $$                   |__/| $$ /$$__  $$");
        System.out.println("| $$  \\ $$ /$$$$$$   /$$$$$$$ /$$| $$| $$  \\__//$$   /$$");
        System.out.println("| $$$$$$$/|____  $$ /$$_____/| $$| $$| $$$$   | $$  | $$");
        System.out.println("| $$____/  /$$$$$$$| $$      | $$| $$| $$_/   | $$  | $$");
        System.out.println("| $$      /$$__  $$| $$      | $$| $$| $$     | $$  | $$");
        System.out.println("| $$     |  $$$$$$$|  $$$$$$$| $$| $$| $$     |  $$$$$$$");
        System.out.println("|__/      \\_______/ \\_______/|__/|__/|__/      \\____  $$");
        System.out.println("                                               /$$  | $$");
        System.out.println("                                              |  $$$$$$/");
        System.out.println("                                               \\______/");

        int command = 1;
        while (true) {
            display();
            System.out.print("Command (0 untuk exit) : ");
            command = Integer.parseInt(in.nextLine());
            if (command == 1) {
                prevMusic();
            } else if (command == 2) {
                addMusic();
            } else if (command == 3) {
                detailsMusic();
            } else if (command == 4) {
                deleteMusic();
            } else if (command == 5) {
                nextMusic();
            } else if (command == 0) {
                break;
            } else {
                System.out.println("Maaf, command yang anda masukan salah");
            }
        }

        System.out.println("Terima kasih sudah menggunakan Pacilfy!");
    }

    /**
     * Method untuk Memutar musik yang selanjutnya
     * Jika berada di posisi akhir playlist,
     * maka yang akan diputar adalah musik posisi awal dalam playlist
     */
    private static void nextMusic() {
        if (pointer >= (playlist.length - 1)) {
            pointer = 0;
        } else {
            pointer++;
        }

    }

    /**
     * Method untuk Menghapus musik yang sedang dimainkan
     * kemudian memutar ke musik selanjutnya
     */
    private static void deleteMusic() {
        // Jika haya ada satu musik
        if (jumlahMusik == 1) {
            System.out.println("Minimal ada satu musik dalam sistem");
        }

        // Jika terdiri lebih dari satu musik
        else {
            // Temporary variable
            String[][] original = playlist;

            // Inisialisasi length baru (nerkurang satu)
            playlist = new String[jumlahMusik - 1][4];

            // Jumlah musik berkurang karena ada lagu yang di hapus
            jumlahMusik--;

            // Jika musik yang diputar berada di posisi akhir array playlist
            if (pointer == original.length - 1) {
                for (int i = 0; i < playlist.length; i++) {
                    for (int j = 0; j < playlist[0].length; j++) {

                        playlist[i][j] = original[i][j];
                    }
                    pointer = 0;
                }
            }

            // Jika musik yang diputar berada di posisi awal array playlist
            else if (pointer == 0) {
                for (int i = 0; i < playlist.length; i++) {
                    for (int j = 0; j < playlist[0].length; j++) {

                        playlist[i][j] = original[i + 1][j];
                    }
                }
            }

            // Jika musik yang diputar berada di posisi awal array playlist
            else {
                for (int i = 0; i < playlist.length; i++) {
                    for (int j = 0; j < playlist[0].length; j++) {
                        if (i < pointer) {
                            playlist[i][j] = original[i][j];
                        }
                        if (i >= pointer) {
                            playlist[i][j] = original[i + 1][j];
                        }
                    }

                }

            }
        }

    }

    /**
     * Method untuk Menampilkan detail lagu
     * berupa judul, artist, album,
     * dan tahun rilis berdasarkan pencarian judul
     */
    private static void detailsMusic() {
        System.out.print("Judul yang ingin dicari: ");
        String judul = in.nextLine();
        System.out.println("Data Lagu: ");
        for (int i = 0; i < playlist.length; i++) {
            if (((playlist[i][0]).toLowerCase()).equals(judul.toLowerCase())) {
                System.out.print("Artist: ");
                System.out.println(playlist[i][1]);
                System.out.print("Album : ");
                System.out.println(playlist[i][2]);
                System.out.print("Tahun : ");
                System.out.println(playlist[i][3]);
            }

            // Jika judul lagu tidak ditemukan pada array plasylist
            else {
                System.out.println("Lagu tidak ditemukan");
            }

        }
    }

    /**
     * Method untuk Memutar musik yang sebelumnya
     * Jika berada di posisi awal playlist,
     * maka yang akan diputar adalah musik posisi terakhir dalam playlist
     */
    private static void prevMusic() {
        if (pointer == 0) {
            pointer = playlist.length - 1;
        } else {
            pointer--;
        }

    }

    /**
     * Method untuk Menambahkan lagu baru ke akhir playlist
     */
    private static void addMusic() {

        jumlahMusik++;
        String[][] original = playlist;
        playlist = new String[jumlahMusik][4];

        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[0].length; j++) {
                playlist[i][j] = original[i][j];
            }
        }
        System.out.println("Silahkan masukkan lagu anda");

        // Input judul lagu
        System.out.print("Judul : ");
        playlist[jumlahMusik - 1][0] = in.nextLine();

        // Input artist
        System.out.print("Artist: ");
        playlist[jumlahMusik - 1][1] = in.nextLine();

        // Input album
        System.out.print("Album : ");
        playlist[jumlahMusik - 1][2] = in.nextLine();

        // Input tahun
        System.out.print("Tahun : ");
        playlist[jumlahMusik - 1][3] = in.nextLine();

    }

    /**
     * Method untuk menampilkan output serta formatting
     */
    private static void display() {
        System.out.println();
        System.out.println("Currently Playing");

        String displayedMusic = " " + playlist[pointer][1] + " - " + playlist[pointer][0] + " ";
        String command = "|[1] prev |[2] add music |[3] details |[4] delete music |[5] next|";

        if (displayedMusic.length() < command.length()) {
            int width = 62;
            String s = displayedMusic;

            int padSize = width - s.length();
            int padStart = s.length() + padSize / 2;

            s = String.format("%" + padStart + "s", s);
            s = String.format("%-" + width + "s", s);

            System.out.println(new String(new char[66]).replace("\0", "="));
            System.out.println("= " + s + " =");
            System.out.println(new String(new char[66]).replace("\0", "="));
            System.out.println(command);

            return;
        }

        System.out.println("=" + new String(new char[displayedMusic.length()]).replace("\0", "=") + "=");
        System.out.println("=" + displayedMusic + "=");
        System.out.println("=" + new String(new char[displayedMusic.length()]).replace("\0", "=") + "=");
        System.out.println(command);
    }

}
