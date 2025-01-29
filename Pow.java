package gfg160;

public class Pow {
    static double power(double b, int e) {
        // Worst case

        /*
         * if (e == 0) { // for zero
         * return 1;
         * }
         * if (e > 1) { // For positive integers
         * return b * power(b, e - 1);
         * } else {
         * return 1 / power(b, -e); // for negative exponents, we compute 1 / (b^|e|)
         * }
         */

        // better case

        /*
         * double n = 1;
         * for(int i = 0; i < Math.abs(e); i++){
         * n = n * b;
         * }
         * if(e < 0){
         * return 1 / n;
         * }
         * return n;
         */

        // Optimal

        if (e == 0) {
            return 1;
        }
        if (e < 0) {
            return 1 / power(b, -e);
        }
        double half = power(b, e / 2);

        if (e % 2 == 0) {
            return half * half;
        } else {
            return b * half * half;
        }
    }

    public static void main(String[] args) {
        System.out.println(power(3.00000, 5));
    }

}
