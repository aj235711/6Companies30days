package intuit;

import java.io.*;
import java.util.*;

class Solution {
    static String ans;

    // Function to find the largest number after k swaps.
    public static String swap(String s, int i, int j) {
        char ch[] = s.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return new String(ch);
    }

    public static void solve(String s, int k, int i) {
        if (k == 0 || i >= s.length()) {
            return;
        }
        char max = s.charAt(i);
        for (int j = i + 1; j < s.length(); j++) {
            if (s.charAt(j) > max) {
                max = s.charAt(j);
            }
        }
        if (max == s.charAt(i)) {
            solve(s, k, i + 1);
            return;
        }
        for (int j = s.length() - 1; j >= i; j--) {
            if (s.charAt(j) == max) {
                s = swap(s, i, j);
                if (s.compareTo(ans) > 0) {
                    ans = s;
                }
                solve(s, k - 1, i + 1);
                s = swap(s, i, j);
            }
        }
    }

    public String findMaximumNum(String str, int k) {
        // code here.
        ans = str;
        solve(str, k, 0);
        return ans;
    }
}

public class MaxNumberInKSwaps {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            String str = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.findMaximumNum(str, k));
        }
        sc.close();
    }
}
