
/**
 * Vehicle.java
 * 
 * Implementasikan kelas Vehicle yang merepresentasikan abstraksi dari
 * sebuah kendaraan.
 * 
 * ada 2 atribut:
 * 1. isMesinBermotor: boolean --> True jika kendaraan bermotor dan False jika
 * tidak
 * 2. numRoda: int --> banyaknya roda
 * 
 * ada 1 constructor:
 * constructor yang mempunyai 2 argumen untuk inisialisasi 2 atribut di atas
 * 
 * ada 3 method:
 * 1. getIsMesinBermotor(): getter dari isMesinBermotor
 * 2. getNumRoda(): getter dari numRoda
 * 3. getTarif(): method ini mengembalikan tarif parkir dari kendaraan
 * tergantung
 * jenis mesin penggerak dan juga banyaknya roda:
 * -> jika bukan kendaraan bermotor: tarif adalah 5000 rupiah
 * -> jika kendaraan bermotor maka dikenakan tarif sebesar 10000 rupiah per
 * roda.
 * contoh, jika sepeda motor (2 roda), maka tarifnya adalah 20000 rupiah.
 * 
 **/
public class Vehicle {

    boolean isMesinBermotor;
    int numRoda;

    public Vehicle(boolean isMesinBermotor, int numRoda) {
        this.isMesinBermotor = isMesinBermotor;
        this.numRoda = numRoda;

    }

    public Boolean getIsMesinBermotor(boolean isMesinBermotor) {
        return this.isMesinBermotor;
    }

    public int getNumRoda(int numRoda) {
        return this.numRoda;
    }

    public int getTarif() {
        if (this.isMesinBermotor) {
            return (10000 * numRoda);
        }
        return 5000;
        

    }
}
