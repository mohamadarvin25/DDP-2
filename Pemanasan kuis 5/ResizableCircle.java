public class ResizableCircle extends  Circle {

    public ResizableCircle(double radius){
        super(radius);
    }
    public void incRadius(double percent){
        super.setRadius(super.getRadius() + super.getRadius()*percent/100);
    }
    public void decRadius(double percent){
        super.setRadius(super.getRadius() - super.getRadius()*percent/100);
    }
    
}
