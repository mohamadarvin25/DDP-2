public class Latihan {
  public static void main(String[] args) {
    Circle c1 = new Circle(10);
    System.out.println(c1.getRadius()); //10.0

    ResizableCircle c2 = new ResizableCircle(10);
    c2.incRadius(10); // increase radius by 10%
    System.out.println(c2.getRadius()); // 11.0

    c2.decRadius(30); // decrease radius by 30%
    System.out.println(c2.getRadius());
    System.out.println(c2.getArea()); // 7.7
  }
}