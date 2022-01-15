package microsoft;

import java.util.*;

class Solution {
    public String findOrder(String[] dict, int N, int K) {
        // Write your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        StringBuilder ans = new StringBuilder();
        for (String word : dict) {
            for (int i = 0; i < word.length(); i++) {
                if (!set.contains(word.charAt(i))) {
                    if (map.containsKey(i)) {
                        ans.insert(map.get(i) + 1, word.charAt(i));
                    } else {
                        ans.append(word.charAt(i));
                        map.put(i, ans.length() - 1);
                    }
                    set.add(word.charAt(i));
                }
            }
        }
        return ans.toString();
    }
}

public class AlienLanguage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.next());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.next());
            int k = Integer.parseInt(sc.next());

            String[] words = new String[n];

            for (int i = 0; i < n; i++) {
                words[i] = sc.next();
            }

            Solution ob = new Solution();
            // System.out.println(T.findOrder(words,k));
            String order = ob.findOrder(words, n, k);
            if (order.length() == 0) {
                System.out.println(0);
                continue;
            }
            String temp[] = new String[n];
            for (int i = 0; i < n; i++)
                temp[i] = words[i];

            Arrays.sort(temp, new Comparator<String>() {

                @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for (int i = 0; i < Math.min(a.length(), b.length())
                            && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }

                    if (index1 == index2 && a.length() != b.length()) {
                        if (a.length() < b.length())
                            return 1;
                        else
                            return 0;
                    }

                    if (index1 < index2)
                        return 1;
                    else
                        return 0;

                }
            });

            int flag = 1;
            for (int i = 0; i < n; i++) {
                if (!words[i].equals(temp[i])) {
                    flag = 0;
                    break;
                }
            }

            System.out.println(flag);
        }
        sc.close();
    }
}
