package goldmanSachs;

import java.util.*;

class Solution {
    int[] getMaxTen(int[] arr) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for (int i = 0; i < arr.length; i++) {
            q.add(arr[i]);
            if (q.size() > 10) {
                q.poll();
            }
        }
        return q.stream().filter(t -> t != null).mapToInt(t -> t).toArray();
    }
}

public class Max10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        int[] ans = obj.getMaxTen(arr);
        Arrays.sort(ans);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        sc.close();
    }
}
