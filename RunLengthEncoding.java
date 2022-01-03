import java.util.*;

class Solution {
    String encode(String str) {
        // Your code here
        int n = str.length();
        if (n == 1) {
            return str + "1";
        }
        StringBuffer ans = new StringBuffer();
        int i = 0, count = 1;
        while (i < n - 1) {
            count = 1;
            ans.append(str.charAt(i));
            if (str.charAt(i) == str.charAt(i + 1)) {
                while (i < n - 1 && str.charAt(i) == str.charAt(i + 1)) {
                    count++;
                    i++;
                }
            }
            ans.append(count);
            i++;
        }
        if (n > 1 && str.charAt(n - 1) != str.charAt(n - 2)) {
            ans.append(str.charAt(n - 1));
            ans.append("1");
        }
        return ans.toString();
    }
}

public class RunLengthEncoding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Solution obj = new Solution();
        System.out.println("Run length encoded string: " + obj.encode(str));
        sc.close();
    }
}
