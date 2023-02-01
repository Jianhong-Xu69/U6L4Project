public class NumberConverter {
    private int[] digits;
    private int base;
    public static final String ALL_VALUES = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/";


    public NumberConverter(String number, int base) {
        String numberAsString = number;
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            int d = ALL_VALUES.indexOf(String.valueOf(number.charAt(i)));
            digits[i] = d;
        }
        this.base = base;
    }

    public String displayNumber(int[] array) {
        String o = "";
        for (int i = 0; i < array.length; i++) {
            o += ALL_VALUES.charAt(array[i]);
        }
        return o;
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
    public int[] convertToDecimal() {
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
        int temp;
        int power = 0;
        int[] any;
        if (base != convertTo) {
            if (base != 10) {
                temp = Integer.parseInt(displayNumber(convertToDecimal()));
            } else {
                temp = Integer.parseInt(displayNumber(digits));
            }
            while (Math.pow(convertTo, power) <= temp) {
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
