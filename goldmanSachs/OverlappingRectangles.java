package goldmanSachs;

import java.util.*;

class Solution {
    int doOverlap(int[] L1, int[] R1, int[] L2, int[] R2) {
        if (L1[0] > R2[0] || L2[0] > R1[0] || R2[1] > L1[1] || R1[1] > L2[1]) {
            return 0;
        }
        return 1;
    }
}

public class OverlappingRectangles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] L1 = new int[2], R1 = new int[2], L2 = new int[2], R2 = new int[2];
        L1[0] = sc.nextInt();
        L1[1] = sc.nextInt();
        R1[0] = sc.nextInt();
        R1[1] = sc.nextInt();
        L2[0] = sc.nextInt();
        L2[1] = sc.nextInt();
        R2[0] = sc.nextInt();
        R2[1] = sc.nextInt();
        Solution obj = new Solution();
        if (obj.doOverlap(L1, R1, L2, R2) == 1) {
            System.out.println("Rectangles overlap");
        } else {
            System.out.println("Rectangles do not overlap");
        }
        sc.close();
    }
}
