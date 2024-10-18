/**
 * ParkingLot.java
 * Kelas ParkingLot merepresentasikan abstraksi dari tempat parkir
 **/
public class ParkingLot {
    private Vehicle[] listOfVehicles;
    private int parkingSize;

    private static final int MAX_SIZE = 100;

    public ParkingLot() {
        this.listOfVehicles = new Vehicle[MAX_SIZE];
        this.parkingSize = 0;
    }

    public void park(Vehicle vehicle) {
        this.listOfVehicles[this.parkingSize++] = vehicle;
    }

    public double rekapTotal() {
        double total = 0.;
        for (int i = 0; i < this.parkingSize; i++) {
            total += this.listOfVehicles[i].getTarif();
        }
        return total;
    }
}