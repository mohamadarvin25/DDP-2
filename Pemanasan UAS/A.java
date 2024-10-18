public interface A {
    /** default method */
    public default void doSomething() {
        System.out.println("Do something");
    }

    /** static method */
    public static int getAValue() {
        return 0;
    }
}
