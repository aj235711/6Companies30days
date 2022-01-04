package goldmanSachs;

import java.util.*;

class Solution {
    String printMinNumberForPattern(String S) {
        // code here
        StringBuilder ans = new StringBuilder("");
        int i = 0;
        while (i < S.length()) {
            int count = 1;
            while (i < S.length() - 1 && S.charAt(i) == S.charAt(i + 1)) {
                i++;
                count++;
            }
            ans.append(solve(ans.length(), S.charAt(i), count, i == S.length() - 1));
            i++;
        }
        return ans.toString();
    }

    static String solve(int max, char op, int n, boolean end) {
        char[] ch;
        if (op == 'D') {
            ch = new char[n + 1];
            int x = max + n + 1;
            for (int i = 0; i <= n; i++) {
                ch[i] = (char) (48 + x);
                x--;
            }
        } else {
            if (max == 0 && end) {
                ch = new char[n + 1];
            } else if (max == 0 || end) {
                ch = new char[n];
            } else {
                ch = new char[n - 1];
            }
            int x = max + 1;
            for (int i = 0; i < ch.length; i++) {
                ch[i] = (char) (48 + x);
                x++;
            }
        }
        return new String(ch);
    }
}

public class NumberPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        Solution obj = new Solution();
        System.out.println(obj.printMinNumberForPattern(S));
        sc.close();
    }
}
