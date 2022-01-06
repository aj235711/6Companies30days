package amazon;

import java.util.*;

class Solution {
    public int longestMountain(int[] arr) {
        int ans = 0, i = 0, j = 0;
        boolean climb = false, fall = false;
        while (i < arr.length - 2) {
            while (i < arr.length - 1 && arr[i] >= arr[i + 1]) {
                i++;
            }
            j = i;
            climb = false;
            fall = false;
            while (j < arr.length - 1 && arr[j] < arr[j + 1]) {
                climb = true;
                j++;
            }
            while (j < arr.length - 1 && arr[j] > arr[j + 1]) {
                fall = true;
                j++;
            }

            if (climb && fall) {
                ans = Math.max(ans, j - i + 1);
            }
            i = j;
        }
        if (climb && fall) {
            ans = Math.max(ans, j - i + 1);
        }
        return ans >= 3 ? ans : 0;
    }
}

public class Mountain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        System.out.println(obj.longestMountain(arr));
        sc.close();
    }
}
