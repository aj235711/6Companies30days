package adobe;

import java.util.*;

class Solution {
    // Function to return the name of candidate that received maximum votes.
    public String[] winner(String arr[], int n) {
        // add your code
        int max = 0;
        String winner = "";
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : arr) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }
        for (String str : map.keySet()) {
            if (map.get(str) > max) {
                max = map.get(str);
                winner = str;
            } else if (map.get(str) == max) {
                winner = str.compareTo(winner) > 0 ? winner : str;
            }
        }
        String[] ans = new String[2];
        ans[0] = winner;
        ans[1] = "" + max;
        return ans;
    }
}

public class Election {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String arr[] = new String[n];

            for (int i = 0; i < n; i++)
                arr[i] = sc.next();

            Solution obj = new Solution();
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);

        }
        sc.close();

    }
}
