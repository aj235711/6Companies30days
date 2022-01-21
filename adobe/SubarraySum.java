package adobe;

import java.util.*;

class Solution {
    // Function to find a continuous sub-array which adds up to a given number.
    ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0, j = 0, sum = 0;
        while (j < n) {
            sum += arr[j];
            while (i <= j && sum > s) {
                sum -= arr[i];
                i++;
            }
            if (sum == s) {
                ans.add(i + 1);
                ans.add(j + 1);
                return ans;
            }
            j++;
        }
        ans.add(-1);
        return ans;
    }
}

public class SubarraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();

            int[] m = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(m, n, s);
            for (int ii = 0; ii < res.size(); ii++)
                System.out.print(res.get(ii) + " ");
            System.out.println();
        }
        sc.close();
    }
}
