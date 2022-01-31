package wallmart;

class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if (divisor == 1) {
            return dividend;
        }
        if (dividend > 0 && divisor > 0) {
            return divide(-dividend, -divisor);
        } else if (dividend > 0) {
            return -divide(-dividend, divisor);
        } else if (divisor > 0) {
            return -divide(dividend, -divisor);
        }
        if (divisor < dividend || dividend == 0) {
            return 0;
        }
        int sum = divisor;
        int mult = 1;
        while ((sum + sum) < sum && (sum + sum) >= dividend) {
            sum += sum;
            mult += mult;
        }
        return mult + divide(dividend - sum, divisor);
    }
}

public class Divide {

}
