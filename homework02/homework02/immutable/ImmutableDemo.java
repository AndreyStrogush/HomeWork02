package homework02.immutable;

import java.util.Scanner;

public final class ImmutableDemo {

    private final int id;
    private final String name;
    private final Age age;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Age getAge() {return age; }

    public ImmutableDemo(int id, String name, Age age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static void testImmutableDemo() {
        int id;
        String name;
        Age age = new Age();

        System.out.println("Enter id");
        Scanner sc = new Scanner(System.in);
        id = sc.nextInt();

        System.out.println("Enter name");
        Scanner sc1 = new Scanner(System.in);
        name = sc1.nextLine();

        System.out.println("Enter Year");
        age.setYear(sc.nextInt());

        ImmutableDemo immutableDemo = new ImmutableDemo(id, name, age);
        System.out.println("New immutable object created, id =  "
                + immutableDemo.getId() + ", name is " + immutableDemo.getName() +
                ", age is " + immutableDemo.getAge().getYear());
    }
}
