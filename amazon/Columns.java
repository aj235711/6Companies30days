package amazon;

import java.util.*;

class Solution {
    String colName(long n) {
        StringBuilder ans = new StringBuilder("");
        while (n > 0) {
            long x = n % 26;
            if (x == 0) {
                x = 26;
                n--;
            }
            n = n / 26;
            ans.insert(0, (char) (64 + (int) x));
        }
        return ans.toString();
    }
}

public class Columns {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        Solution obj = new Solution();
        System.out.println(obj.colName(n));
        sc.close();
    }
}
