import java.lang.Math;

public class Sphere extends Geom3D implements Comparable<Sphere> {
  private double radius;

  public Sphere(double radius) {
    super();
    this.radius = radius;
  }

  public double getRadius() {
      return this.radius;
  }

  @Override
  public int compareTo(Sphere o){
    if(this.getRadius() > o.getRadius())
      return 1;
    else if (this.getRadius() < o.getRadius())
      return -1;
    else
      return 0;
  }

  @Override
  public double getVolume() {
    return  0.75 * Math.PI * this.getRadius() * this.getRadius() * this.getRadius();    
  }

  @Override
  public void resize(double percent) {
    this.radius = this.radius + this.radius * (percent / 100);
  }

  @Override
  public String toString() {
    return "Sphere " + this.radius;
  }

}