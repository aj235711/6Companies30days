package intuit;

import java.util.*;

class Solution {
    public static boolean isPossible(int[] piles, int h, int n, int speed) {
        int count = 0;
        for (int x : piles) {
            if (x % speed == 0) {
                count += x / speed;
            } else {
                count += x / speed + 1;
            }
            if (count > h) {
                return false;
            }
        }
        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = 0, n = piles.length;
        for (int x : piles) {
            max = Math.max(x, max);
        }
        int low = 1, high = max, ans = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(piles, h, n, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}

public class Bananas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        Solution obj = new Solution();
        System.out.println(obj.minEatingSpeed(arr, m));
        sc.close();
    }
}
