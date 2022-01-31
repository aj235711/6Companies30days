package wallmart;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = null;
        right = null;
    }
}

class Solution {
    public static int solve(Node root) {
        if (root == null) {
            return 0;
        }
        int x = root.data;
        root.data = solve(root.left) + solve(root.right);
        return x + root.data;
    }

    public void toSumTree(Node root) {
        // add code here.
        solve(root);
    }
}

public class SumTree {

}
