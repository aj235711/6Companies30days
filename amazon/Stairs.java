package amazon;

import java.util.*;

class Solution {
    Long countWays(int m) {
        return (long) (m) / 2 + 1;
    }
}

public class Stairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        Solution obj = new Solution();
        System.out.println(obj.countWays(m));
        sc.close();
    }
}
