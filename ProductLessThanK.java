import java.util.*;

class Solution {
    public int countSubArrayProductLessThanK(long a[], long n, long k) {
        int i = 0, j = 0, count = 0;
        long prod = 1;
        while (i < n) {
            prod *= a[i];
            while (prod >= k && j <= i) {
                prod /= a[j];
                j++;
            }
            count += i - j + 1;
            i++;
        }
        return count;
    }
}

public class ProductLessThanK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();
        long[] a = new long[(int) n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        System.out.println("Number of contiguous subarrays with product less than k: "
                + obj.countSubArrayProductLessThanK(a, n, k));
        sc.close();
    }
}
