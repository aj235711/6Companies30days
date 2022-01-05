package goldmanSachs;

import java.util.*;

class Solution {
    String decodedString(String s) {
        // code here
        Stack<String> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (48 <= s.charAt(i) && s.charAt(i) <= 57) {
                int n = Integer.parseInt(s.substring(i, i + 1));
                int j = i + 1;
                while (j < s.length() && 48 <= s.charAt(j) && s.charAt(j) <= 57) {
                    n = n * 10 + Integer.parseInt(s.substring(j, j + 1));
                    j++;
                }
                i = j - 1;
                stk.push("" + n);
                continue;
            }
            if (s.substring(i, i + 1).equals("]")) {
                StringBuilder x = new StringBuilder();
                while (!(stk.peek().equals("["))) {
                    x.insert(0, stk.pop());
                }
                stk.pop();
                int n = Integer.parseInt(stk.pop());
                StringBuilder y = new StringBuilder();
                for (int j = 1; j <= n; j++) {
                    y.append(x);
                }
                stk.push(y.toString());
            } else {
                stk.push(s.substring(i, i + 1));
            }
        }
        return stk.pop();
    }
}

public class StringDecode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Solution obj = new Solution();
        System.out.println(obj.decodedString(s));
        sc.close();
    }
}
