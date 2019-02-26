package homework02;

import homework02.sort.Sort;
import homework02.builder.BuildWebsiteRunner;
import homework02.immutable.ImmutableDemo;
import homework02.inner.InnerClassesRuner;

import java.util.Scanner;

public class ConsolApplication {

    public static void main(String[] args) {
        choose();
    }

    static void choose (){
        int choice;

        System.out.println("Choose article: \n" +
                "\t1 - Builder pattern \n" +
                "\t2 - Inner classes \n" +
                "\t3 - Immutable class \n" +
                "\t4 - Sorts ");
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
                ImmutableDemo.testImmutableDemo();
                break;
            case 4:
                Sort.measure();
                break;
            default:
                System.out.println("Input error");
                break;
        }
    }//end choose
}
