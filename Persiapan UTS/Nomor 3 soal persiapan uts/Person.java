class Person {
    public Person() {
        this("Person");
        System.out.println("Person - Cons 1");
    }

    public Person(String name) {
        System.out.println(name);
    }
}