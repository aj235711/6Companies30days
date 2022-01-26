package intuit;

import java.util.*;

class Solution {
    public static boolean isInRange(int[] weights, int days, int n, int limit) {
        int sum = 0, count = 1;
        for (int i = 0; i < n; i++) {
            sum += weights[i];
            if (sum > limit) {
                sum = weights[i];
                count++;
                if (count > days) {
                    return false;
                }
            }
        }
        return true;
    }

    public int shipWithinDays(int[] weights, int days) {
        int sum = 0, n = weights.length, max = 0;
        for (int i = 0; i < n; i++) {
            sum += weights[i];
            max = Math.max(max, weights[i]);
        }
        int low = max, high = sum, ans = max;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isInRange(weights, days, n, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}

public class ShipPackages {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        Solution obj = new Solution();
        System.out.println(obj.shipWithinDays(arr, m));
        sc.close();

    }
}
