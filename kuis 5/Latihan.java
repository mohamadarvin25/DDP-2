public class Latihan {
    public static void main(String[] args) {
        MoveablePoint mp = new MoveablePoint(5, 10, 2, 3);
        System.out.println(mp.getX());  // 5
        System.out.println(mp.getY());  // 10
        mp.move();
        System.out.println(mp.getX());  // 7
        System.out.println(mp.getY());  // 13
    }
        
}
