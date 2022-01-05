package goldmanSachs;

import java.util.*;

class Solution {
    public boolean canPair(int[] nums, int k) {
        // Code here
        int[] rem = new int[k];
        for (int i = 0; i < nums.length; i++) {
            rem[nums[i] % k]++;
        }
        if (rem[0] % 2 == 1) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i] % k;
            if (x == 0) {
                continue;
            }
            rem[k - x]--;
            if (rem[k - x] == -1) {
                return false;
            }
        }
        return true;
    }
}

public class PairSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        System.out.println(obj.canPair(nums, k));
        sc.close();
    }
}
