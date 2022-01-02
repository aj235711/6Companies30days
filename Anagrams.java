import java.util.*;

class Helper {
    int freqArr[];
    List<String> list;

    Helper(int[] freqArr, String str) {
        this.freqArr = freqArr;
        this.list = new ArrayList<>();
        this.list.add(str);
    }
}

class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
        List<Helper> helpers = new ArrayList<>();
        for (String str : string_list) {
            int[] freqArr = getFreqArray(str);
            boolean flag = false;
            for (Helper helper : helpers) {
                if (areFreqArraysSame(freqArr, helper.freqArr)) {
                    helper.list.add(str);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                Helper newHelper = new Helper(getFreqArray(str), str);
                helpers.add(newHelper);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (Helper helper : helpers) {
            ans.add(helper.list);
        }
        return ans;
    }

    public static int[] getFreqArray(String str) {
        int arr[] = new int[26];
        Arrays.fill(arr, 0);
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 97]++;
        }
        return arr;
    }

    public static boolean areFreqArraysSame(int[] arr1, int[] arr2) {
        return Arrays.toString(arr1).equals(Arrays.toString(arr2));
    }
}

public class Anagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String string_list[] = new String[n];
        for (int i = 0; i < n; i++) {
            string_list[i] = sc.next();
        }
        Solution obj = new Solution();
        List<List<String>> ans = obj.Anagrams(string_list);
        for (List<String> list : ans) {
            for (String str : list) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}