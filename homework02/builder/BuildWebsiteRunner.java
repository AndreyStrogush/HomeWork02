package homework02.builder;

import java.util.Scanner;

public class BuildWebsiteRunner {

    public static void runWebsiteBuilder() {
        System.out.println("Select a site to create: \n" +
                "1. Site - \"promo\"  \n" +
                "2. Enterprise site ");

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
                System.out.println("Input error");
                break;
        }

        Website website = director.buildWebsite();

        System.out.println(website);
    }
}
