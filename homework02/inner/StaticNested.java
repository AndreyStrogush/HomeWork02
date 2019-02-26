package homework02.inner;

public class StaticNested {
    private static void outerMethod() {
        System.out.println("inside outerMethod");
    }

    // A static inner class
    static class NestedDemo {
        public void nestedMethod() {
            System.out.println("This is my nested class");
            outerMethod();
        }
    }
}