package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator {

    private static final Logger logger = LogManager.getLogger(Calculator.class);
    public Calculator() {
    }

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        double n1, n2;
        do {
            System.out.println("Scientific Calculator using DevOps. \n Choose operation:");
            System.out.print("1. Factorial\n2. Square root\n3. Power\n4. Natural Logarithm\n" +
                    "5. Exit\nEnter your choice: ");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException error) {
                return;
            }

            switch (choice) {
                case 1:
                    // Factorial
                    System.out.print("Enter a number : ");
                    n1 = scanner.nextDouble();
                    System.out.println("Factorial of "+n1+" is : " + calculator.factoral(n1));
                    System.out.println("\n");

                    break;
                case 2:
                    // Square root
                    System.out.print("Enter a number : ");
                    n1 = scanner.nextDouble();
                    System.out.println("Square root of "+n1+" is : " + calculator.sqroot(n1));
                    System.out.println("\n");


                    break;
                case 3:
                    // Power
                    System.out.print("Enter the first number : ");
                    n1 = scanner.nextDouble();
                    System.out.print("Enter the second number : ");
                    n2 = scanner.nextDouble();
                    System.out.println(n1+ " raised to power "+n2+" is : " + calculator.power(n1, n2));
                    System.out.println("\n");
                    break;
                case 4:
                    // Natural log
                    System.out.print("Enter a number : ");
                    n1 = scanner.nextDouble();
                    System.out.println("Natural log of "+n1+" is : " + calculator.naturalLog(n1));
                    System.out.println("\n");

                    break;
                default:
                    System.out.println("Exiting....");
                    return;
            }
        } while (true);
    }


    public double factoral(double n1) {
        logger.info("[FACTORIAL] - " + n1);
        double result = fact(n1);
        logger.info("[RESULT - FACTORIAL] - " + result);
        return result;
    }



    public double sqroot(double n1) {
        logger.info("[SQ ROOT] - " + n1);
        double result = Math.sqrt(n1);
        logger.info("[RESULT - SQ ROOT] - " + result);
        return result;
    }


    public double power(double n1, double n2) {
        logger.info("[POWER - " + n1 + " RAISED TO] " + n2);
        double result = Math.pow(n1,n2);
        logger.info("[RESULT - POWER] - " + result);
        return result;
    }

    public double naturalLog(double n1) {
        logger.info("[NATURAL LOG] - " + n1);
        double result = 0;
        try {

            if (n1 <0 ) {
                result = Double.NaN;
                throw new ArithmeticException("Case of NaN 0.0/0.0");
            }
            else {
                result = Math.log(n1);
            }
        } catch (ArithmeticException error) {
            System.out.println("[EXCEPTION - LOG] - Cannot find log of negative numbers " + error.getLocalizedMessage());
        }
        logger.info("[RESULT - NATURAL LOG] - " + result);
        return result;
    }
    public double fact(double num) {
        double facto = 1;
        for(int i = 1; i <= num; ++i)
        { facto *= i;   }
        return  facto;
    }
}
