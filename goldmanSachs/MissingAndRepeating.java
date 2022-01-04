package goldmanSachs;

import java.util.*;
import java.math.BigInteger;

class Solution {
    int[] findTwoElement(int arr[], int n) {
        // code here
        BigInteger N = BigInteger.valueOf(n);
        BigInteger one = BigInteger.valueOf(1);
        BigInteger two = BigInteger.valueOf(2);
        BigInteger six = BigInteger.valueOf(6);
        BigInteger sum = (N.multiply(N.add(one))).divide(two);
        BigInteger sqSum = ((N.multiply(N.add(one))).multiply((two.multiply(N)).add(one))).divide(six);
        System.out.println(sum + " " + sqSum);
        for (int i = 0; i < arr.length; i++) {
            sum = sum.subtract(BigInteger.valueOf(arr[i]));
            sqSum = sqSum.subtract(BigInteger.valueOf(arr[i]).multiply(BigInteger.valueOf(arr[i])));
        }
        int s = sum.intValue();
        int ss = sqSum.intValue();
        int ans[] = new int[2];
        int div = ss / s;
        ans[1] = (s + div) / 2;
        ans[0] = (div - s) / 2;
        return ans;
    }
}

public class MissingAndRepeating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        int ans[] = obj.findTwoElement(arr, n);
        System.out.println(ans[0] + " " + ans[1]);
        sc.close();
    }
}
