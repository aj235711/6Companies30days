package microsoft;

import java.util.*;

class Solution {
    // Function to generate binary numbers from 1 to N using a queue.
    public ArrayList<String> generate(int N) {
        // Your code here
        ArrayList<String> ans = new ArrayList<String>();
        for (int i = 1; i <= N; i++) {
            StringBuilder sb = new StringBuilder("");
            int x, n = i;
            while (n > 0) {
                x = n % 2;
                sb.insert(0, x);
                n = n / 2;
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}

public class BinaryNumbers {
    public static void main(String args[]) {
        // Taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // Taking the number of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // taking the range
            int n = sc.nextInt();

            // creating an ArrayList
            ArrayList<String> res = new ArrayList<String>();

            // calling the generate method of class Solution
            // and storing the result in an ArrayList
            res = new Solution().generate(n);

            // printing all the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        }
        sc.close();
    }
}
