public interface CanFly {
    void fly();
}

class Superman implements CanFly {
    public void fly() {
        System.out.println("Superman flies");
    }
}

abstract class Bird implements CanFly {
    String habitat;
    String gender;
    String color;

    abstract void eat();

    @Override
    public void fly() {
        System.out.println("Burung terbang");

    }
}

class Pigeon extends Bird {
    @Override
    void eat() {
        // TODO Auto-generated method stub

    }

}

class Chicken extends Bird {
    @Override
    void eat() {
        // TODO Auto-generated method stub

    }

}

class T {
    public static void main(String[] args) {
        CanFly s = new Superman();
        CanFly p = new Pigeon();
        CanFly c = new Chicken();

        CanFly[] fliers = { s, p, c };
        for (CanFly f : fliers)
            f.fly();

        Bird[] birds =  { (Bird) p, (Bird) c };
        for (Bird b : birds)
            b.eat();
    }
}
