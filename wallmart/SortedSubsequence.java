package wallmart;

import java.util.*;

class Solution {
    ArrayList<Integer> find3Numbers(ArrayList<Integer> arr, int n) {
        // add code here.
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stk = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && stk.peek() <= arr.get(i)) {
                stk.pop();
            }
            stk.push(arr.get(i));
            if (stk.size() == 3) {
                while (!stk.isEmpty()) {
                    ans.add(stk.pop());
                }
                return ans;
            }
        }
        return ans;
    }
}

public class SortedSubsequence {

}
