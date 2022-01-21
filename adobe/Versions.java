package adobe;

import java.util.*;

class Solution {
    String getLatestVersion(String v1, String v2) {
        if (v1.length() == 0 && v2.length() == 0) {
            return "-1";
        } else if (v1.length() == 0) {
            return v2;
        } else if (v2.length() == 0) {
            return v1;
        }
        String[] arr1 = v1.split(".");
        String[] arr2 = v2.split(".");
        for (int i = 0; i < arr1.length && i < arr2.length; i++) {
            if (Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[i])) {
                return v1;
            }
            if (Integer.parseInt(arr1[i]) < Integer.parseInt(arr2[i])) {
                return v2;
            }
            if (i == arr1.length - 1 && i < arr2.length) {
                return v2;
            }
            if (i == arr2.length - 1 && i < arr1.length) {
                return v1;
            }
        }
        return "Same";
    }
}

public class Versions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String v1 = sc.next();
        String v2 = sc.next();
        Solution obj = new Solution();
        System.out.println(obj.getLatestVersion(v1, v2));
        sc.close();
    }
}
