package amazon;

import java.util.*;

class TrieNode {
    TrieNode[] arr;
    ArrayList<String> list;

    TrieNode() {
        this.arr = new TrieNode[26];
        this.list = new ArrayList<String>();
    }

    boolean containsKey(char x) {
        return this.arr[x - 'a'] != null;
    }

    void put(char x, TrieNode node) {
        this.arr[x - 'a'] = node;
    }

    TrieNode getNext(char x) {
        return this.arr[x - 'a'];
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String str) {
        TrieNode node = root;
        for (int i = 0; i < str.length(); i++) {
            if (!node.containsKey(str.charAt(i))) {
                node.put(str.charAt(i), new TrieNode());
            }
            node = node.getNext(str.charAt(i));
            node.list.add(str);
        }
    }
}

class Solution {
    ArrayList<ArrayList<String>> displayContacts(int n, String contact[], String s) {
        contact = Arrays.stream(contact).distinct().toArray(String[]::new);
        Arrays.sort(contact);
        ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
        Trie trie = new Trie();
        for (String str : contact) {
            trie.insert(str);
        }
        TrieNode node = trie.root;
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (!node.containsKey(x)) {
                while (i < s.length()) {
                    ArrayList<String> curr = new ArrayList<String>();
                    curr.add("0");
                    ans.add(curr);
                    i++;
                }
            } else {
                node = node.getNext(x);
                ans.add(node.list);
            }
        }
        return ans;
    }
}

public class PhoneDirectory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String arr[] = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        String s = sc.next();
        Solution obj = new Solution();
        ArrayList<ArrayList<String>> ans = obj.displayContacts(n, arr, s);
        for (ArrayList<String> curr : ans) {
            System.out.println(curr);
        }
        sc.close();
    }
}
