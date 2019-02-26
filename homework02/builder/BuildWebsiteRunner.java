package homework02.builder;

import java.util.Scanner;

public class BuildWebsiteRunner {

    public static void runWebsiteBuilder() {
        System.out.println("Выберите сайт для создания: \n" +
                "1. Сайт - \"визитка\"  \n" +
                "2. Корпаративный сайт ");

        Scanner sc = new Scanner(System.in);
        Integer choice = sc.nextInt();

        Director director = new Director();

        switch (choice) {
            case 1:
                director.setBuilder(new VisitCardWebsiteBuilder());
                break;
            case 2:
                director.setBuilder(new EnterpriseWebsiteBuilder());
                break;
            default:
                System.out.println("Ошибка ввода");
                break;
        }

        Website website = director.buildWebsite();

        System.out.println(website);
    }
}
