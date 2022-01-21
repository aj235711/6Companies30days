package adobe;

import java.util.*;

class Solution {
    int atoi(String str) {
        // Your code here
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            return -1;
        }
    }
}

public class Atoi {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String str = sc.nextLine();

            Solution obj = new Solution();
            System.out.println(obj.atoi(str));
            t--;
        }
        sc.close();
    }
}
