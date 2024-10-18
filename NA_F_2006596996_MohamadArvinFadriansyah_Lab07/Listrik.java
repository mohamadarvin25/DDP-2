// Listrik is kind of EngineBEhavoiur
public class Listrik implements EngineBehaviour {

    /// Method untuk menyalakan mobil bahan bakar Listrik
    @Override
    public String start(Mobil mobil) {
        return String.format("%s menyalakan listrik, SIAP DIGAS!", mobil.getNama());
    }

    // Method untuk menghitung besin penggunaan mobil bahan bakar listrik
    @Override
    public int gas(int persenFuel) {
        return persenFuel - 20;
    }

    /// Method untuk mematikan mobil bahan bakar BBM
    @Override
    public String stop(Mobil mobil) {
        return String.format("%s listrik dimatikan, mobil telah berhenti", mobil.getNama());
    }

}