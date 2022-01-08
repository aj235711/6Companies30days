package amazon;

import java.util.*;

class Solution {
    public String FirstNonRepeating(String A) {
        // code here
        int[] mat = new int[26];
        StringBuilder ans = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            mat[ch - 'a']++;
            if (mat[ch - 'a'] == 1) {
                queue.add(ch);
            }
            while (!queue.isEmpty() && mat[queue.peek() - 'a'] > 1) {
                queue.poll();
            }
            if (!queue.isEmpty()) {
                ans.append(queue.peek());
            } else {
                ans.append('#');
            }
        }
        return ans.toString();
    }
}

public class NonRepeating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        Solution obj = new Solution();
        System.out.println(obj.FirstNonRepeating(A));
        sc.close();
    }
}
