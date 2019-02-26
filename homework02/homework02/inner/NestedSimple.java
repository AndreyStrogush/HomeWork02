package homework02.inner;

public class NestedSimple {
    // private variable of the outer class
    private int privateValue = 100;

    // Simple nested inner class
    class InnerDemo {
        public void show() {
            System.out.println("In a nested class method");
        }

        public int getValue() {
            System.out.println("This is the getValue method of the inner class " + privateValue);
            return privateValue;
        }
    }

}
