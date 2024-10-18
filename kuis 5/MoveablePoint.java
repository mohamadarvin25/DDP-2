public class MoveablePoint extends Point {
    private double moveableX;
    private double moveableY;

    public MoveablePoint(double x, double y, double moveableX, double moveableY){
        super(x,y);
        this.moveableX = moveableX;
        this.moveableY = moveableY;
    }

    public void move(){
        super.setXY(super.getX() + moveableX, super.getY() + moveableY);
    }
    
}
