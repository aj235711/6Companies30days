package goldmanSachs;

import java.util.*;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE, sum = 0, i = 0, j = 0;
        while (i < nums.length) {
            sum += nums[i];
            while (sum >= target) {
                ans = Math.min(ans, i - j + 1);
                sum -= nums[j];
                j++;
            }
            i++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

public class MinimumSubArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        System.out.println(obj.minSubArrayLen(target, nums));
        sc.close();
    }
}
