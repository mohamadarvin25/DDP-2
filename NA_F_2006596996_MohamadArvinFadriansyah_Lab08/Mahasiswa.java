public class Mahasiswa {
    private static int MINIMUM_TINGKAT_KESEHATAN = 70;
    private String nama;
    private int tingkatKesehatan;

    public Mahasiswa(String nama, int tingkatKesehatan) {
        this.nama = nama;
        this.tingkatKesehatan = tingkatKesehatan;
    }

    public String getStatus() {
        // Jika tingkat kesehatan mahasiswa dibawah syarat minimum
        if (this.tingkatKesehatan < MINIMUM_TINGKAT_KESEHATAN) {
            return "Tidak layak mengikuti program";
        }

        // Jika tingkat kesehatan mahasiswa memenuhi syarat minimum
        return "Layak mengikuti program";
    }

    // Untuk mencetak sebagai output di file
    @Override
    public String toString() {
        return String.format("%-24s| %s\n", this.nama, this.getStatus());
    }
}
