import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8 or 10): ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        int base = Integer.parseInt(choice);

        System.out.print("Enter your number: ");
        String number = s.nextLine();
        int n = Integer.parseInt(number);

        NumberConverter nc = new NumberConverter(n, base);
        int[] digits = nc.getDigits();
        String temp = "";
        System.out.println("\n\nDigit array: " + Arrays.toString(digits));
        System.out.println("Number: " + nc.displayNumber(nc.getDigits()));
        if (base != 2) {
            System.out.println("Binary: " + nc.displayNumber(nc.convertToAny(2)));
        }
        if (base != 8) {
            System.out.println("Octo: " + nc.displayNumber(nc.convertToAny(8)));
        }
        if (base != 10) {
            System.out.println("Decimal: " + nc.displayNumber(nc.convertToDecimal()));
        }
        System.out.println("Additional base would you like to convert to (Only scales to base 64): ");
        choice = s.nextLine();
        base = Integer.parseInt(choice);
        System.out.println("Base " + base + ": " + nc.displayNumber(nc.convertToAny(base)));
    }
}