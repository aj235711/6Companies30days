package wallmart;

import java.util.*;

class Solution {
    public int maxPerformance(int n, int[] speed, int[] eff, int k) {
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = speed[i];
            a[i][1] = eff[i];
        }
        Arrays.sort(a, (x, y) -> Integer.compare(y[1], x[1]));
        PriorityQueue<Integer> q = new PriorityQueue<>();
        long tot = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            q.add(a[i][0]);
            tot += q.size() <= k ? a[i][0] : a[i][0] - q.poll();
            ans = Math.max(ans, tot * a[i][1]);
        }
        return (int) (ans % (long) 1000000007);
    }
}

public class MaxPerformance {

}
