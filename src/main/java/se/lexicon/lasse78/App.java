package se.lexicon.lasse78;
import java.util.Scanner;

public class App {

    public static void mainMenu() {
        int menuchoice;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Simple Console Calculator");
            System.out.println("-------------------------\n");
            System.out.println("1) Simple calculation using two values");
            System.out.println("2) Add several values");
            System.out.println("3) Subtract several values");
            System.out.println("4) End program\n");
            System.out.println("Please make a selection:");
            menuchoice = scanner.nextInt();

            switch (menuchoice) {
                case 1:
                    simpleCalculation();
                    break;
                case 2:
                    addSeveralValues();
                    break;
                case 3:
                    subtractSeveralValues();
                    break;
                case 4:
                    System.out.println("\n------------------------------------------\nThank you for using this program, goodbye!\n------------------------------------------"); // The 'while' condition is fulfilled, will end afterwards
                    break;
                default:
                    System.out.println("Incorrect selection!\n");
            }
        } while (menuchoice != 4);
    }

    public static void simpleCalculation() { // Is assuming user will always choose proper input format
        double result = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please insert value 1: ");
        double value1 = scanner.nextDouble();
        System.out.println("Please choose operator (+ - * /): ");
        char operator = scanner.next().charAt(0);
        System.out.println("Please insert value 2: ");
        double value2 = scanner.nextDouble();
        switch (operator) {
            case '+':
                result = calcAdd(value1, value2);
                break;
            case '-':
                result = calcSubtract(value1, value2);
                break;
            case '*':
                result = calcMultiply(value1, value2);
                break;
            case '/':
                result = calcDivide(value1, value2);
        }

        if (operator == '*' && (value1 == 0 || value2 == 0)) { // Accounts for mathematical errors.
            System.out.println("Any value multiplied by zero becomes zero.\n");
        } else if (operator == '/' && value2 == 0) {
            System.out.println("Division by zero is not possible.\n");
        } else if (operator == '/' && value1 == 0) {
            System.out.println("A zero divided by another number will always be zero.\n");
        } else {
            System.out.println(value1 + " " + operator + " " + value2 + " = " + result + "\n");
        }
        return;
    }

    public static double calcAdd(double value1, double value2) {
        return (value1 + value2);
    }

    public static double calcSubtract(double value1, double value2) {
        return (value1 - value2);
    }

    public static double calcDivide(double value1, double value2) {
        return (value1 / value2);
    }

    public static double calcMultiply(double value1, double value2) {
        return (value1 * value2);
    }

    public static void addSeveralValues() {
        double result = 0, value = 0;
        int numbercount = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("\nHow many values would you like to add together: ");
            numbercount = scanner.nextInt();
            if (numbercount < 2) {
                System.out.println("This operation will not work unless you enter a value of 2 or greater."); }// Not strictly true, code works fine regardless of chosen integer
            else { break; };

        } while (true);

        for (int i = 0; i < numbercount; i++) {
            System.out.println("Please add value " + (i + 1) + " out of " + numbercount + ":");
            value = scanner.nextInt();
            result = calcAdd(result, value);
        }
        System.out.println("The result is: " + result + "\n");
    }

    public static void subtractSeveralValues() {
        double result = 0, value = 0;
        int numbercount = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("\nHow many values would you like to subtract: ");
            numbercount = scanner.nextInt();
            if (numbercount < 2 ) {
                System.out.println("This operation will not work unless you enter a value of 2 or greater."); }// Not strictly true, code works fine regardless of chosen integer
            else { break; };

        } while (true);

        System.out.println("Please add first value out of " + numbercount + ":"); // This part is needed to determine the first value that will be subtracted
        value = scanner.nextInt();
        result = calcAdd(result, value);

        for (int i = 1; i < numbercount; i++) {
            System.out.println("Please add value " + (i + 1) + " out of " + numbercount + ":");
            value = scanner.nextInt();
            result = calcSubtract(result, value);
        }
        System.out.println("The result is: " + result + "\n");
    }

    public static void main(String[] args) {
        mainMenu();
    }
}
