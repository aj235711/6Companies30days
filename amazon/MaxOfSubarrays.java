package amazon;

import java.util.*;

class Solution {
    ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Deque<Integer> dq = new LinkedList<Integer>();
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        ans.add(arr[dq.peekFirst()]);
        for (int i = k; i < n; i++) {
            if (!dq.isEmpty() && dq.peekFirst() + k == i) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
            ans.add(arr[dq.peekFirst()]);
        }
        return ans;
    }
}

public class MaxOfSubarrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        ArrayList<Integer> ans = obj.max_of_subarrays(arr, n, k);
        System.out.println(ans);
        sc.close();
    }
}
