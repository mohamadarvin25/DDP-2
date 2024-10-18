class ItemForSale {
    private double price;
}

class Jewelry extends ItemForSale {
    private double age;

    public Jewelry(int age) {
        this.age = age;
    }
}

class Ring extends Jewelry {
    private int size;

    public Ring(int age, int size) {
        super(age);
        this.size = size;
    }
}
