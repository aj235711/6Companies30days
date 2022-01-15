package microsoft;

import java.io.*;
import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        for (int i = 0; i < arr.length - 3; i++) {
            for (int j = i + 1; j < arr.length - 2; j++) {
                int l = j + 1, r = arr.length - 1;
                while (l < r) {
                    int sum = arr[l] + arr[r] + arr[i] + arr[j];
                    if (sum == k) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(arr[l]);
                        list.add(arr[r]);
                        if (!set.contains(list)) {
                            ans.add(list);
                        }
                        set.add(list);
                        l++;
                        r--;
                    } else if (sum < k) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return ans;
    }
}

public class Quadruples {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
