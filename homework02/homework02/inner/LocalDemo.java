package homework02.inner;

public class LocalDemo {
    // instance method of the outer class
    void myMethod() {
        int num = 10;

        // method-local inner class
        class MethodInnerDemo {
            public void print() {
                System.out.println("This is method inner class " + num);
            }
        } // end of inner class

        // Accessing the inner class
        MethodInnerDemo inner = new MethodInnerDemo();
        inner.print();
    }
}
