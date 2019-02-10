package SwordForOffer;

public class Test16 {
    static boolean invalidInput = false;
    public static double power(double base, int exponent) {
        if (Double.compare(base, 0.0) == 0 && (exponent < 0)) {
            invalidInput = true;
            return 0.0;
        }

        int absExponenet = exponent;
        if (exponent < 0) {
            absExponenet = Math.abs(exponent);
        }

        double result = powerWithUnsignedExponent2(base, absExponenet);
        if (exponent < 0) {
            result = 1/ result;
        }

        return result;
    }

    // O(n)
    private static double powerWithUnsignedExponent(double base, int exponent) {
        double result = 1;
        for(int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    // O(logn)时间
    private static double powerWithUnsignedExponent2(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        else if ((exponent & 1) == 0) {
            double tempRes = powerWithUnsignedExponent2(base, exponent >> 1);
            return tempRes * tempRes;
        }
        else {
            double tempRes = powerWithUnsignedExponent2(base, exponent >> 1);
            return tempRes * tempRes * base;
        }
    }

    public static void main(String[] args) {
        System.out.println("2^3="+power(2,3)+"\t是否报错:"+invalidInput);
        System.out.println("2^-3="+power(2,-3)+"\t是否报错:"+invalidInput);
        System.out.println("0^3="+power(0,3)+"\t是否报错:"+invalidInput);
        System.out.println("0^-3="+power(0,-3)+"\t是否报错:"+invalidInput);
    }
}
