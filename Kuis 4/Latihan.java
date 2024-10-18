/**
 * Latihan.java
 * Program utama
 **/


public class Latihan {
    public static void main(String[] args) {
        ParkingLot parkLot = new ParkingLot();

        parkLot.park(new Vehicle(false, 2));
        parkLot.park(new Vehicle(true, 2));
        parkLot.park(new Vehicle(true, 4));

        System.out.println("rekapitulasi total tarif: " + parkLot.rekapTotal()); // 65000
    }
}