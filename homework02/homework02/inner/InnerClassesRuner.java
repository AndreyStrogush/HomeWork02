package homework02.inner;

public class InnerClassesRuner {
    public static void runInnerClasses() {

        System.out.println("Inner Class example:");

        NestedSimple.InnerDemo inner = new NestedSimple().new InnerDemo();
        inner.show();
        inner.getValue();

        System.out.println("\nMethod-local Inner Class example: \n");

        LocalDemo local = new LocalDemo();
        local.myMethod();

        System.out.println("\nAnonymous Inner Class example: \n");

        AnonymousInner anonymousInner = new AnonymousInner() {
            public void myMethod() {
                System.out.println("This is an example of anonymous inner class");
            }
        };
        anonymousInner.myMethod();

        System.out.println("\nAnonymous Inner Class as Argument example: \n");
        // Anonymous Inner Class as implementer of the specified interface:
        // passing an anonymous inner class as an argument
        anonymousInner.displayMessage(new Message() {
            public String hello() {
                return "Hello";
            }
        });

        System.out.println("\nStatic Nested Class e[amle \n");
        StaticNested.NestedDemo nested = new StaticNested.NestedDemo();
        nested.nestedMethod();
    }
}
