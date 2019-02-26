package homework02.immutable;

import java.util.Scanner;

final public class ImmutableDemo {

    private final int id;
    private final String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ImmutableDemo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void DemoBuilder() {
        int id;
        String name;

        System.out.println("Введите возраст");
        Scanner sc = new Scanner(System.in);
        id = sc.nextInt();
        System.out.println("Введите имя");
        Scanner sc1 = new Scanner(System.in);
        name = sc1.nextLine();
        ImmutableDemo immutableDemo = new ImmutableDemo(id, name);
        System.out.println("Созданн новый неизменяемый объект, id =  "
                + immutableDemo.getId() + ", имя - " + immutableDemo.getName());
    }
}
