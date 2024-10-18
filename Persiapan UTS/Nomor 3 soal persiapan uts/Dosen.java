class Dosen extends Staff {
    public Dosen() {
        this("Dosen");
        System.out.println("Dosen - Cons 1");
    }

    public Dosen(String name) {
        super(name);
        System.out.println("Dosen - Cons 2");
    }
}
