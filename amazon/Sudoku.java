package amazon;

import java.util.*;

class Solution {
    int isValid(int mat[][]) {
        // code here
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < 9; i++) {
            set.clear();
            for (int j = 0; j < 9; j++) {
                if (mat[i][j] != 0 && set.contains(mat[i][j])) {
                    return 0;
                }
                set.add(mat[i][j]);
            }
        }
        for (int i = 0; i < 9; i++) {
            set.clear();
            for (int j = 0; j < 9; j++) {
                if (mat[j][i] != 0 && set.contains(mat[j][i])) {
                    return 0;
                }
                set.add(mat[j][i]);
            }
        }
        for (int l = 0; l < 9; l += 3) {
            for (int k = 0; k < 9; k += 3) {
                set.clear();
                for (int i = k; i < k + 3; i++) {
                    for (int j = l; j < l + 3; j++) {
                        if (mat[i][j] != 0 && set.contains(mat[i][j])) {
                            return 0;
                        }
                        set.add(mat[i][j]);
                    }
                }
            }
        }
        return 1;
    }
}

public class Sudoku {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mat[][] = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        Solution obj = new Solution();
        System.out.println(obj.isValid(mat));
        sc.close();
    }
}
