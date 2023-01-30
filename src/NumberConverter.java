import java.lang.reflect.Array;

public class NumberConverter {
    int[] digits;
    int base;

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i, i + 1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
    }

    public int displayNumber(int[] array) {
        String o = "";
        for (int i = 0; i < array.length; i++) {
            o += array[i];
        }
        return Integer.parseInt(o);
    }

    public int[] getDigits() {
        return digits;
    }

    //use a temp to store the array?
    //try putting an int separated into array?
    //leftmost element, move right
    //multiply by respective power
    //add to final
    //???
    //separate into array
    public int[] convertToDecimal(int base) {
        int[] digitsTemp;
        int temp = 0;
        int power = 0;
        int j = 0;
        for (int i = getDigits().length-1; i >= 0; i--) {
            temp += getDigits()[i] * Math.pow(base, j);
            j++;
        }
        j = 0;
        while (Math.pow(10, power) <= temp){
            power++;
        }
        digitsTemp = new int[power];
        power--;
        for (int i = 0; i < digitsTemp.length; i++) {
            digitsTemp[i] = (int) (temp / Math.pow(10, power));
            temp -= digitsTemp[i] * (Math.pow(10, power));
            power--;
        }
        return digitsTemp;
    }

    //use what base it is
    //start with left most and work across?

    public int[] convertToAny(int convertTo) {
        int temp = displayNumber(digits);
        int power = 0;
        int[] any;
        if (base != convertTo) {
            if (base != 10) {
                temp = displayNumber(convertToDecimal(base));
            }
            while (Math.pow(convertTo, power) <= displayNumber(digits)) {
                power++;
            }
            any = new int[power];
            power--;
            for (int i = 0; i < any.length; i++) {
                any[i] = temp / (int) (Math.pow(convertTo,power));
                temp %= (int) (Math.pow(convertTo,power));
                power--;
            }
            return any;
        }
        return null;
    }
}
