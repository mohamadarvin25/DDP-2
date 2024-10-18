import java.util.Scanner;

public class SolusiLab03 {
    static int pointer = 0;
    static String[][] playlist = new String[1][4];
    static Scanner in = new Scanner(System.in);
    static int jumlahMusik = 0;

    public static void main(String[] args) {
        System.out.println("Selamat Datang di Pacilfy!");
        // loop inisialisasi playlist
        int exit = 1;
        while(exit != 0){
            addMusic();
            System.out.print("Lanjut menambahkan lagu?\n" +
                    "[1] Lanjut\n" +
                    "[0] Berhenti\n" +
                    "Perintah: ");
            exit = Integer.parseInt(in.nextLine());
        }

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
        while (true){
            display();
            System.out.print("Command (0 untuk exit) : ");
            command = Integer.parseInt(in.nextLine());
            if(command == 1){
                prevMusic();
            }
            else if(command == 2){
                addMusic();
            }
            else if(command == 3){
                detailsMusic();
            }
            else if(command == 4){
                deleteMusic();
            }
            else if(command == 5){
                nextMusic();
            }
            else if(command == 0){
                break;
            }
            else {
                System.out.println("Maaf, command yang anda masukan salah");
            }
        }

        System.out.println("Terima kasih sudah menggunakan Pacilfy!");
    }

    private static void nextMusic() {

        if(pointer+1 == playlist.length){
            pointer = 0;
        }
        else{
            pointer++;
        }

    }


    private static void deleteMusic() {

        if(jumlahMusik == 1){
            System.out.println("Minimal ada satu musik dalam sistem");
        }
        else{
            String[][] newPlaylist = new String[playlist.length-1][4];
            int shifter = 0;
    
            for (int i = 0; i < playlist.length; i++) {
                if(pointer == i) continue;
                newPlaylist[shifter] = playlist[i];
                shifter++;
            }
    
            if(pointer == playlist.length-1) pointer = 0;
            playlist = newPlaylist;
            jumlahMusik--;
        }

    }

    private static void detailsMusic() {
        System.out.print("Judul yang ingin dicari: ");
        String judul = in.nextLine();

        String[] details = findMusic(judul);

        if (details == null) {
            System.out.println("Lagu tidak ditemukan");
        } else {
            System.out.println("Data lagu:");
            System.out.println("Judul : " + details[0]);
            System.out.println("Artist: " + details[1]);
            System.out.println("Album : " + details[2]);
            System.out.println("Tahun : " + details[3]);
        }
    }

    private static String[] findMusic(String title) {
        for (String[] music : playlist) {
            if (music[0].equalsIgnoreCase(title)) {
                return music;
            }
        }
        return null;
    }

    private static void prevMusic() {
        if(pointer == 0){
            pointer = playlist.length-1;
        }
        else{
            pointer--;
        }
 
    }

    private static void addMusic() {
        System.out.println("Silahkan masukan lagu anda");
        System.out.print("Judul : ");
        String judul = in.nextLine();
        System.out.print("Artist: ");
        String artist = in.nextLine();
        System.out.print("Album : ");
        String album = in.nextLine();
        System.out.print("Tahun : ");
        String tahun = in.nextLine();

        if(jumlahMusik >= playlist.length){

            // buat array baru dengan panjang +1 dari array sebelumnya
            // dan copy lagu-lagu dari array lama ke array baru
            String[][] playlistBaru = new String[playlist.length + 1][4];
            for (int i = 0; i < playlist.length; i++) {
                playlistBaru[i] = playlist[i];
            }
    
            // playlist lama akan direplace dengan playlist baru
            playlist = playlistBaru;

        }

        playlist[jumlahMusik][0] = judul;
        playlist[jumlahMusik][1] = artist;
        playlist[jumlahMusik][2] = album;
        playlist[jumlahMusik][3] = tahun;
        jumlahMusik++;

    }


    private static void display() {
        System.out.println();
        System.out.println("Currently Playing");

        String displayedMusic = " " + playlist[pointer][1] + " - " + playlist[pointer][0] + " ";
        String command = "|[1] prev |[2] add music |[3] details |[4] delete music |[5] next|";

        if (displayedMusic.length() < command.length()){
            int width = 62;
            String s = displayedMusic;

            int padSize = width - s.length();
            int padStart = s.length() + padSize / 2;

            s = String.format("%" + padStart + "s", s);
            s = String.format("%-" + width  + "s", s);


            System.out.println(new String(new char[66]).replace("\0", "="));
            System.out.println("= "+ s +" =");
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