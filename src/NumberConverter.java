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

    public int displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        return Integer.parseInt(o);
    }

    public int[] getDigits() {
        return digits;
    }

    //use a temp to store the array?
    //try putting an int separated into array?
    //leftmost element, move right
    //multiply by respective power of 2 or 8
    //add to final
    //???
    //separate into array
    public int[] convertToDecimal() {
        int[] digitsTemp = getDigits();
        int temp = 0;
        for (int i = 0; i < digitsTemp.length; i++) {
            temp += Math.pow(8, digitsTemp[i]-1);
        }

        return null;
    }

    //use what base it is
    //start with left most and work across?

    public int[] convertToBinary() {
        int temp = displayOriginalNumber();
        int power = 0;
        int[] bin;
        if (base != 2) {
            if (base != 10) {
                temp = convertToDecimal();
            }
            while (Math.pow(2, power) <= displayOriginalNumber()) {
                power += 1;
            }
            bin = new int[power];
            int i = 0;
            while (temp > 0) {
                bin[bin.length-1-i] = temp % 2;
                temp /= 2;
                i++;
            }
            return bin;

        }
        return null;
    }

    public int[] convertToOctal() {
        return null;
    }
}
