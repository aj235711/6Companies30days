package adobe;

import java.util.*;

class Solution {
    int[] findSmallestRange(int[][] arr, int n, int k) {
        // add your code here
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        int max = 0, l = 0, h = 100000;
        for (int j = 0; j < k; j++) {
            int[] newArr = new int[3];
            newArr[0] = arr[j][0];
            newArr[1] = j;
            newArr[2] = 0;
            max = Math.max(arr[j][0], max);
            pq.add(newArr);
        }
        while (true) {
            int[] curr = pq.poll();
            if (max - curr[0] < h - l) {
                l = curr[0];
                h = max;
            }
            if (curr[2] == n - 1) {
                break;
            }
            int[] newArr = new int[3];
            newArr[0] = arr[curr[1]][curr[2] + 1];
            newArr[1] = curr[1];
            newArr[2] = curr[2] + 1;
            max = Math.max(max, newArr[0]);
            pq.add(newArr);
        }
        int ans[] = new int[2];
        ans[0] = l;
        ans[1] = h;
        return ans;
    }
}

public class KLists {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int range[];
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[][] = new int[k][n];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++)
                    arr[i][j] = sc.nextInt();
            }
            range = new Solution().findSmallestRange(arr, n, k);
            System.out.println(range[0] + " " + range[1]);
        }
        sc.close();
    }
}
