package intuit;

import java.util.*;

class Solution {
    public int missingNumber(String s) {
        // add code here.
        int[] arr = { 9, 99, 999, 9999, 99999, 999999 };
        for (int i = 1; i <= 6; i++) {
            int k = i, f = 0, x = 0, ans = -1;
            boolean isBorder = false;
            if (k <= s.length()) {
                x = Integer.parseInt(s.substring(0, k));
            } else {
                break;
            }
            for (int j = k; j < s.length(); j += k) {
                if (isBorder) {
                    k++;
                    isBorder = false;
                }
                if (j + k > s.length()) {
                    f = -1;
                    break;
                }
                int y = 0;
                if (x == arr[k - 1] - 1) {
                    if (j + k + 1 <= s.length()) {
                        y = Integer.parseInt(s.substring(j, j + k + 1));
                        if (y == arr[k - 1] + 1) {
                            isBorder = true;
                            j -= k;
                            continue;
                        }
                    }
                }
                int z = Integer.parseInt(s.substring(j, j + k));
                if (z <= x || z - x > 2) {
                    f = -1;
                    break;
                } else if (z - x == 1) {
                    x = z;
                } else {
                    f++;
                    if (f == 2) {
                        f = -1;
                        break;
                    }
                    x = z;
                    ans = x - 1;
                }
                if (x == arr[k - 1]) {
                    if (k == 6) {
                        f = -1;
                        break;
                    } else {
                        isBorder = true;
                    }
                }
            }
            if (f == 1) {
                return ans;
            }
        }
        return -1;
    }
}

public class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution g = new Solution();
            System.out.println(g.missingNumber(s));
        }
        sc.close();
    }
}
