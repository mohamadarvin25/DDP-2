public class Cuboid implements Prism {
  private double height;
  private double baseWidth;
  private double baseLength;

  public Cuboid(double height, double baseWidth, double baseLength) {
    this.height = height;
    this.baseWidth = baseWidth;
    this.baseLength = baseLength;
  }

  @Override
  public double getBaseArea() {
      return baseLength*baseWidth;
  }

  @Override
  public double getHeight() {
      // TODO Auto-generated method stub
      return height;
  }

  @Override
  public double getVolume() {
      // TODO Auto-generated method stub
      return getBaseArea() * getHeight();
  }

  // lengkapi
  public static void main(String[] args) {
    Prism cub = new Cuboid(10, 5, 5);
    System.out.println(cub.getBaseArea()); // 25.0
    System.out.println(cub.getHeight()); // 10.0
    System.out.println(cub.getVolume()); // 250.0

    Geom3D geom = cub;
    System.out.println(geom.getVolume()); // 250.0
  }

}

interface Geom3D {
  double getVolume();
}

interface Prism extends Geom3D {
  double getBaseArea();

  double getHeight();
}
