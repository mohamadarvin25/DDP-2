import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;

public class Dictionary<K, V> {
    private ArrayList<Pair<K, V>> pairs;

    public Dictionary() {
        this.pairs = new ArrayList<Pair<K, V>>();
    }

    // Menambahkan pasangan <key, value> ke dalam
    // arraylist. Jika key sudah ada, nilai value
    // sebelumnya akan ditimpa dengan nilai value
    // yang baru.
    public void addPair(K key, V value) {
        // lengkapi method ini
        Pair<K, V> newPair = new Pair<K, V>(key, value);
        boolean flag = false;
        if (pairs.size() == 0) {
            pairs.add(newPair);
        }
        if (pairs.size() > 0) {

            for (int i = 0; i < pairs.size(); i++) {
                if (newPair.getKey() == pairs.get(i).getKey()) {
                    pairs.get(i).setValue(newPair.getValue());
                    flag = true;

                }
            }
            if (flag == false){
                pairs.add(newPair);
            }
        }

    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < pairs.size(); i++) {
            out.append(pairs.get(i).toString());
        }
        return out.toString();
    }
}