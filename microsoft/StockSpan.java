package microsoft;

import java.util.*;

class Solution {
    public int[] calculateSpan(int price[], int n) {
        // Your code here
        int[] ans = new int[n];
        Stack<Integer> stk = new Stack<Integer>();
        ans[0] = 1;
        stk.push(0);
        for (int i = 1; i < n; i++) {
            while (!stk.isEmpty() && price[stk.peek()] <= price[i]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                ans[i] = i - stk.peek();
            } else {
                ans[i] = i + 1;
            }
            stk.push(i);
        }
        return ans;
    }

}

public class StockSpan {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            int i = 0;
            for (i = 0; i < n; i++)
                a[i] = sc.nextInt();

            int[] s = new Solution().calculateSpan(a, n);

            for (i = 0; i < n; i++) {
                System.out.print(s[i] + " ");
            }

            System.out.println();
        }
        sc.close();
    }
}
