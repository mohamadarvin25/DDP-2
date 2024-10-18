import java.util.Arrays;

public class Test {
  public static void main(String[] args) {
    Sphere[] spheres = { new Sphere(5.0),
        new Sphere(2.0),
        new Sphere(3.0) };

    spheres[2].resize(100.0);

    Arrays.sort(spheres);

    for (int i = 0; i < spheres.length; i++){
      System.out.println(spheres[i].getVolume());
    }

    System.out.println(Arrays.toString(spheres));
    // [Sphere 2.0, Sphere 5.0, Sphere 6.0]

  }
}