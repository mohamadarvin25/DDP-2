import java.util.Arrays;

public class Test {
  public static void main(String[] args) {

    Point[] points = { new ComparablePoint(1.0, 3.0),
        new ComparablePoint(2.0, 9.0),
        new ComparablePoint(1.0, 2.0),
        new ComparablePoint(2.0, 7.0) };

    Arrays.sort(points);

    System.out.println(Arrays.toString(points));
    // [Point(x=1.0, y=2.0), Point(x=1.0, y=3.0), Point(x=2.0, y=7.0), Point(x=2.0,
    // y=9.0)]

  }
}