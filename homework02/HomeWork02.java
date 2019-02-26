package homework02;

import homework02.builder.BuildWebsiteRunner;
import homework02.immutable.ImmutableDemo;
import homework02.inner.InnerClassesRuner;

import java.util.Scanner;

public class HomeWork02 {
    public static void main(String[] args) {
        int choice;

        System.out.println("Выберите пункт: \n" +
                "\t1 - Паттерн Builder \n" +
                "\t2 - Внутренние классы \n" +
                "\t3 - Неизменяемый класс ");
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                BuildWebsiteRunner.runWebsiteBuilder();
                break;
            case 2:
                InnerClassesRuner.runInnerClasses();
                break;
            case 3:
                ImmutableDemo.DemoBuilder();
                break;
            default:
                System.out.println("Ошибка ввода");
                break;
        }
    }
}
