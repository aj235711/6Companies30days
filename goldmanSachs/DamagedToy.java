package goldmanSachs;

import java.util.*;

class Solution {
    int getKidNo(int n, int m, int k) {
        int ans = 0;
        if (k + m - 1 <= n) {
            ans = k + m - 1;
        } else {
            ans = (m - (n - k + 1)) % n;
        }
        if (ans == 0) {
            ans = n;
        }
        return ans;
    }
}

public class DamagedToy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        Solution obj = new Solution();
        System.out.println(obj.getKidNo(n, m, k));
        sc.close();
    }
}
