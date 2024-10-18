import java.util.ArrayList;
import java.util.Collections;

public class DaftarPesanan<T extends Pesanan> {
    // TODO: tambahkan attributes
    private ArrayList<T> pesanans;

    public DaftarPesanan() {
        // TODO: Lengkapi Constructor berikut
        pesanans = new ArrayList<T>();

    }

    // Penambahan pesanan
    public void tambahPesanan(T pesanan) {
        // TODO: proses tambah pesanan
        this.getPesanans().add(pesanan);
    }

    // Melayani Pesanan
    public T nextPesanan() {
        // TODO: return sesuai dengan urutan prioritas

        // Pesanan prioritas
        T firstElement = pesanans.get(0);
        pesanans.remove(0);

        return firstElement;

    }

    // Mengurutkan pesanan sesuai prioritas
    public void sortPesanans() {
        Collections.sort(pesanans);
    }

    // Tambahkan getter-setter apabila diperlukan

    public ArrayList<T> getPesanans() {
        return pesanans;
    }

    public int getSize() {
        return pesanans.size();
    }

}
