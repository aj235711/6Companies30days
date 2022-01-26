package intuit;

import java.util.*;

class Solution {
    public static boolean isInRange(int[] nums, int n, int limit, int m) {
        int sum = 0, count = 1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > limit) {
                count++;
                sum = nums[i];
            }
        }
        return count <= m;
    }

    public int splitArray(int[] nums, int m) {
        int sum = 0, n = nums.length, max = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }
        int low = max, high = sum, ans = max;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isInRange(nums, n, mid, m)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}

public class SplitArrayMaxSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        Solution obj = new Solution();
        System.out.println(obj.splitArray(arr, m));
        sc.close();
    }
}
