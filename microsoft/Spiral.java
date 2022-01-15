package microsoft;

import java.util.*;

class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c) {
        // code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        char dir = 'R';
        int count = 0, i = 0, j = 0, left = 0, right = c - 1, top = 0, bottom = r - 1;
        while (count < r * c) {
            if (dir == 'R') {
                for (j = left; j <= right; j++) {
                    ans.add(matrix[i][j]);
                    count++;
                }
                top++;
                j--;
                dir = 'D';
            } else if (dir == 'D') {
                for (i = top; i <= bottom; i++) {
                    ans.add(matrix[i][j]);
                    count++;
                }
                right--;
                i--;
                dir = 'L';
            } else if (dir == 'L') {
                for (j = right; j >= left; j--) {
                    ans.add(matrix[i][j]);
                    count++;
                }
                bottom--;
                j++;
                dir = 'U';
            } else if (dir == 'U') {
                for (i = bottom; i >= top; i--) {
                    ans.add(matrix[i][j]);
                    count++;
                }
                left++;
                i++;
                dir = 'R';
            }
        }
        return ans;
    }
}

public class Spiral {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++)
                    matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val : ans)
                System.out.print(val + " ");
            System.out.println();
        }
        sc.close();
    }
}
