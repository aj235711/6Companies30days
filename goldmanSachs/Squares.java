package goldmanSachs;

import java.util.*;

class Solution {
    Long squaresInChessBoard(Long N) {
        // code here
        return (N * (N + 1) * (2 * N + 1)) / 6;
    }
};

public class Squares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long N = sc.nextLong();
        Solution obj = new Solution();
        System.out.println(obj.squaresInChessBoard(N));
        sc.close();
    }
}
