public class ComparablePoint extends Point implements Comparable <ComparablePoint> {

    public ComparablePoint(double x, double y){
        super(x, y);
    }
    
    @Override
    public int compareTo(ComparablePoint o) {
        if (this.getX() > o.getX())
            return 1;
        else if (this.getX() < o.getX())
            return -1;
        else{
            if (this.getY() > o.getY())
                return 1;
            else if (this.getY() < o.getY())
                return -1;
            else{
                return 0;
            }
        }
    }

    @Override
    public  String toString(){
        return "point(x=" + this.getX() + ", y=" + this.getY() + ")";
    }

 }