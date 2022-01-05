package goldmanSachs;

import java.util.*;

class Solution {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int ans[] = new int[2];
        int map[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            map[arr[i]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (map[i] == 0) {
                ans[1] = i;
            }
            if (map[i] > 1) {
                ans[0] = i;
            }
        }
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
