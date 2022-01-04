package goldmanSachs;

import java.util.*;

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String small = str1.length() <= str2.length() ? str1 : str2;
        String big = str1.length() > str2.length() ? str1 : str2;
        String x = small;
        while (x.length() > 0) {
            if (check(small, x) && check(big, x)) {
                break;
            }
            x = x.substring(0, x.length() - 1);
        }
        return x;
    }

    public static boolean check(String str, String x) {
        if (str.length() == 0) {
            return true;
        }
        if (str.length() % x.length() != 0) {
            return false;
        }
        if (!str.substring(0, x.length()).equals(x)) {
            return false;
        }
        return check(str.substring(x.length()), x);
    }
}

public class StringGCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        Solution obj = new Solution();
        System.out.println(obj.gcdOfStrings(str1, str2));
        sc.close();
    }
}
