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

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
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
        return null;
    }

    //use what base it is
    //start with left most and work across?

    public int[] convertToBinary() {

        return null;
    }

    public int[] convertToOctal() {
        return null;
    }
}
