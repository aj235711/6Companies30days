package adobe;

import java.io.*;

class Solution {
    public String amendSentence(String s) {
        // code here
        StringBuilder ans = new StringBuilder(s.substring(0, 1).toLowerCase());
        for (int i = 1; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                ans.append(" " + s.substring(i, i + 1).toLowerCase());
            } else {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}

public class StringAmendment {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            // input n array elements
            String s = read.readLine();

            Solution ob = new Solution();

            System.out.println(ob.amendSentence(s));
        }
    }
}
