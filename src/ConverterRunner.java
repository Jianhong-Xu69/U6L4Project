import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8 or 10): ");

        Scanner s = new Scanner(System.in);
        String choice = "";
        int base = 0;
        for (int i = 0; i < 1; i++) {
            choice = s.nextLine();
            if (choice.equalsIgnoreCase("2") || choice.equalsIgnoreCase("8") || choice.equalsIgnoreCase("10")){
                base = Integer.parseInt(choice);
            } else {
                System.out.println("That's not valid!");
                System.out.print("Enter the base of your number (2, 8 or 10): ");
                i--;
            }
        }

        System.out.print("Enter your number: ");
        String number;
        int n = 0;
        boolean temp = false;
        for (int i = 0; i < 1; i++) {
            number = s.nextLine();
            for (int j = 0; j < number.length()-1; j++) {
                if (Integer.parseInt(String.valueOf(number.charAt(j))) < base){
                    temp = true;
                }
            }
            if (temp){
                n = Integer.parseInt(number);
            } else {
                System.out.println("That's not valid!");
                System.out.print("Enter your number: ");
                i--;
            }
        }

        NumberConverter nc = new NumberConverter(n, base);
        int[] digits = nc.getDigits();
        String temp2 = "";
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
        System.out.print("Additional base would you like to convert to (Only scales to base 64): ");
        for (int i = 0; i < 1; i++) {
            choice = s.nextLine();
            if (Integer.parseInt(choice) <= 64){
                base = Integer.parseInt(choice);
            } else {
                System.out.println("Have you considered that it only scales to 64");
                System.out.print("Additional base would you like to convert to (Only scales to base 64): ");
                i--;
            }
        }
        System.out.println("Base " + base + ": " + nc.displayNumber(nc.convertToAny(base)));
    }
}