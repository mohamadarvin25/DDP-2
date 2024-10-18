class Foo extends Exception {
}

class Bar extends Foo {
}

class Main {
    public static void main(String args[]) {
        try {
            throw new Bar();
        } catch (Foo f) {
            System.out.println("Foo exception berhasil ditangani");
        } catch (Bar b) {
            System.out.println("Bar exception berhasil ditangani");
        }
    }
}
