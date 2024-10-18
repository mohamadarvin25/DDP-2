public class MyClass {
    static int a;
    int b;

    public MyClass(){
        a++;
        mysteryB();
    }

    public MyClass(int x){
        b = x;
        a++;
        mysteryB();

    }

    public static void mysteryA() {
        a++;
        
    }

    public void mysteryB() {
        b++;
        a += 3;
    }

    public static void main(String[] args) {
        int a = 4;
        System.out.println(a);

        mysteryA();
        MyClass obj1 = new MyClass();
        obj1.mysteryB();
        MyClass obj2 = new MyClass(5);
        obj2.mysteryB();
        MyClass.a++;
        MyClass.mysteryA();
        System.out.println(obj1.a);
        System.out.println(obj1.b);
        System.out.println(obj2.b);
        
    
        
    }
    
    
}
