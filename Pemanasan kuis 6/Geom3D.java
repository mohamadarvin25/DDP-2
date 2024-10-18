import java.util.Date;

public abstract class Geom3D {
  private Date whenCreated;

  protected Geom3D() {
    this.whenCreated = new Date();
  }

  public Date getWhenCreated() {
    return this.whenCreated;
  }

  protected abstract void resize(double percent);

  protected abstract double getVolume();
}