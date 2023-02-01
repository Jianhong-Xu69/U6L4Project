import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (Only supports up to base 64): ");
        int count = 0;

        Scanner s = new Scanner(System.in);
        String choice = "";
        int base = 0;
        for (int i = 0; i < 1; i++) {
            choice = s.nextLine();
            if (Integer.parseInt(choice) > 0 && Integer.parseInt(choice) < 65){
                base = Integer.parseInt(choice);
            } else {
                System.out.println("That's not valid!");
                count++;
                if (count == 5){
                    System.out.println("Were you looking for a secret message or something? If so, here it is.");
                }
                System.out.print("Enter the base of your number (Only supports up to base 64): ");
                i--;
            }
        }

        System.out.print("Enter your number (must be positive!): ");
        String number;
        String n = "";
        boolean temp = true;
        for (int i = 0; i < 1; i++) {
            number = s.nextLine();
            for (int j = 0; j < number.length(); j++) {
                if (NumberConverter.ALL_VALUES.indexOf(number.charAt(j)) > base || NumberConverter.ALL_VALUES.indexOf(number.charAt(j)) < 0){
                    temp = false;
                }
            }
            if (temp){
                n = number;
            } else {
                System.out.println("That's not valid!");
                count++;
                if (count == 5){
                    System.out.println("Were you looking for a secret message or something? If so, here it is.");
                }
                System.out.print("Enter your number (must be positive!): ");
                i--;
                temp = true;
            }
        }

        NumberConverter nc = new NumberConverter(n, base);
        int[] digits = nc.getDigits();
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