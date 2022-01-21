package adobe;

import java.util.*;

class Solution {
    public static void solve(List<String> ans, int n, String s, int c1, int c2) {
        if (c2 > c1) {
            return;
        }
        if (s.length() == n * 2) {
            if (c1 == c2) {
                ans.add(s);
            }
            return;
        }
        solve(ans, n, s + '(', c1 + 1, c2);
        solve(ans, n, s + ')', c1, c2 + 1);
    }

    public List<String> AllParenthesis(int n) {
        // Write your code here
        List<String> ans = new ArrayList<>();
        solve(ans, n, "", 0, 0);
        return ans;
    }
}

public class BalancedParenthesis {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.next());
        while (t > 0) {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for (int i = 0; i < k; i++) {
                System.out.println(sequences[i]);
            }

            t--;

        }
        sc.close();
    }
}
