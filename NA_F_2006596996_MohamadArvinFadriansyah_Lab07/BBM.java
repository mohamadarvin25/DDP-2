// BBM is kind of EngineBEhavoiur
public class BBM implements EngineBehaviour {

    // Method untuk menyalakan mobil bahan bakar BBM
    @Override
    public String start(Mobil mobil) {
        return String.format("%s menyalakan mesin, NGENG!", mobil.getNama());
    }

    // Method untuk menghitung besin penggunaan mobil bahan bakar BBM
    @Override
    public int gas(int persenFuel) {
        return persenFuel - 25;
    }

    /// Method untuk mematikan mobil bahan bakar BBM
    @Override
    public String stop(Mobil mobil) {
        return String.format("%s mesin mati, mobil istirahat dulu.", mobil.getNama());
    }
}