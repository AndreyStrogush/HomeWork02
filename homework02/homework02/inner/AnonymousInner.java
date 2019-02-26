package homework02.inner;

abstract class AnonymousInner {
    // a) As subclass of specified type
    public abstract void myMethod();

    // b) An anonymous class that implements  interface -
    // method which accepts the object of interface Message
    public void displayMessage(Message m) {
        System.out.println(m.hello() +
                ", This is an example of anonymous inner class as an argument");
    }
}
