import java.util.*;

class Solution {
    /* Function to get the nth ugly number */
    long getNthUglyNo(int n) {
        long arr[] = new long[n];
        arr[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            arr[i] = Math.min(arr[p2] * 2, Math.min(arr[p3] * 3, arr[p5] * 5));
            if (arr[i] == arr[p2] * 2) {
                p2++;
            }
            if (arr[i] == arr[p3] * 3) {
                p3++;
            }
            if (arr[i] == arr[p5] * 5) {
                p5++;
            }
        }
        return arr[n - 1];
    }
}

public class UglyNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution obj = new Solution();
        System.out.println(obj.getNthUglyNo(n));
        sc.close();
    }
}
