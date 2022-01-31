package wallmart;

import java.util.*;

class StringComp implements Comparator<String> {
    public int compare(String a, String b) {
        if (a.length() != b.length()) {
            return b.length() - a.length();
        }
        return b.compareTo(a);
    }
}

class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<String>(new StringComp());
        for (String x : nums) {
            pq.add(x);
        }
        for (int i = 1; i < k; i++) {
            pq.poll();
        }
        return pq.poll();
    }
}

public class KthLargest {

}
