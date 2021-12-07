package operation;


import java.util.Scanner;

public class main {
    public static void main(String[] args){
        ListTest test;
        System.out.println("Select how many times the collection methods will be called");
        System.out.println("1. 10000 \n2. 20000 \n3. 100000 \n4. Choose by yourself");
        int choice;
        Scanner scanner = new Scanner(System.in);
        String check= "Y";
        while (check.equals("Y")  || check.equals("y")){
        do {
            System.out.println("Please, enter a number from 1-4");
            while (!scanner.hasNextInt()) {
                System.out.println("That not a number!");
                System.out.println("Please, enter a number from 1-4");
                scanner.next();
            }
            choice = scanner.nextInt();
        } while (choice < 1 || choice > 4);

        System.out.println("Your choice is " + choice);

        switch (choice) {
            case 1: {
                test = new ListTest(1000);
                break;
            }
            case 2: {
                test = new ListTest(20000);
                break;
            }
            case 3: {
                test = new ListTest(100000);
                break;
            }
            case 4: {
                long outputFour;
                do {
                    System.out.println("Please, enter your number of repetitions. For example, 1000, 5000 ...");

                    while (!scanner.hasNextInt()) {
                        System.out.println("That not a number!");
                        System.out.println("Please, enter your number of repetitions. For example, 1000, 5000 ...");
                        scanner.next();
                    }
                    outputFour = scanner.nextInt();
                }while (outputFour < 1);
                test = new ListTest(outputFour);
                break;
            }
            default: {
                System.out.println("Incorrect value.Let's run option 1");
                test = new ListTest(10000);
            }
        }
        try {
            test.startTest();
            String[][] result = test.table();
            for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.printf("%-15s", result[i][j]);
            }
            System.out.println();
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
            System.out.println("Continue Y or N");
            check = scanner.next();
       }
    }
}
