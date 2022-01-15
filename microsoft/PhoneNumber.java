package microsoft;

import java.util.*;

class Solution {
    // Function to find list of all words possible by pressing given numbers.
    static void solve(int a[], int i, HashMap<Integer, String> map, String s, ArrayList<String> ans) {
        String str = map.get(a[i]);
        for (int j = 0; j < str.length(); j++) {
            if (i == a.length - 1) {
                ans.add(s + str.charAt(j));
            } else {
                solve(a, i + 1, map, s + str.charAt(j), ans);
            }
        }
    }

    ArrayList<String> possibleWords(int a[], int N) {
        // your code here
        HashMap<Integer, String> map = new HashMap<>();
        ArrayList<String> ans = new ArrayList<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        solve(a, 0, map, "", ans);
        return ans;
    }
}

public class PhoneNumber {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();// testcases

        while (t-- > 0) {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; // input the elements of array that are keys to be pressed

            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();// input the elements of array that are keys to be pressed
            ArrayList<String> res = new Solution().possibleWords(arr, n);
            for (String i : res)
                System.out.print(i + " ");
            System.out.println();

        }
        sc.close();
    }
}
