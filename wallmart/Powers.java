package wallmart;

class Solution {
    static int mod = 1000000007;

    static long solve(int x, int y) {
        if (y == 0) {
            return 1;
        } else if (y % 2 == 0) {
            long pow = solve(x, y / 2) % mod;
            return (pow % mod * pow % mod) % mod;
        } else {
            long pow = solve(x, y / 2) % mod;
            return (x % mod * pow % mod * pow % mod) % mod;
        }
    }

    long power(int N, int R) {
        // Your code here
        return solve(N, R) % 1000000007;
    }

}

public class Powers {

}
