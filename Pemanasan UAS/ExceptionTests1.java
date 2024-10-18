public class ExceptionTests1 {

    public static void main(String[] args) throws Exception {
        System.out.println("ExceptionTests1");
        int res = 0;
        try {
            // line 7
            C();
            B();
            System.out.println("statement1");
        } catch (ExceptionType1 e) {
            System.out.println("catchMain1");
        } catch (ExceptionType2 e) {
            System.out.println("catchMain2");
        } finally {
            System.out.println("finallyMain");
        }
        System.out.println("statement2");
    }

    public static void A() throws Exception {
        try {
            B();
            System.out.println("statement5");
        } catch (ExceptionType3 e) {
        } finally {
            System.out.println("finallyA");
        }
    }

    public static void B() throws Exception {
        throw new ExceptionType2("Exception 2");
    }

    public static void C() throws Exception {
        try {
            A();
            System.out.println("statement3");
        } catch (ExceptionType2 e) {
        }
        System.out.println("statement4");
    }

    public static int D(int a, int b) throws ExceptionType2 {
        if (b == 0)
            throw new ExceptionType2("Exception 2");

        return a / b;
    }

    public static int E(int a, int b) throws ExceptionType2 {
        int res = -1;
        res = D(a, b);
        try {
            System.out.println("statement5");
            return res;
        } finally {
            System.out.println("finallyE");
        }
    }
}

class ExceptionType1 extends RuntimeException {
    public ExceptionType1(String msg) {
        super(msg);
    }
}

class ExceptionType2 extends RuntimeException {
    public ExceptionType2(String msg) {
        super(msg);
    }
}

class ExceptionType3 extends Exception {
    public ExceptionType3(String msg) {
        super(msg);
    }
}
