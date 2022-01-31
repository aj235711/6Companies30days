package wallmart;

class Solution {
    public boolean winnerOfGame(String colors) {
        int numA = 0, numB = 0, countA = 0, countB = 0;
        char ch = colors.charAt(0);
        for (int i = 0; i <= colors.length(); i++) {
            if (i < colors.length() && colors.charAt(i) == ch) {
                if (ch == 'A') {
                    countA++;
                } else {
                    countB++;
                }
            } else {
                if (ch == 'A') {
                    if (countA >= 3) {
                        numA += countA - 2;
                    }
                    countA = 0;
                    countB = 1;
                    ch = 'B';
                } else {
                    if (countB >= 3) {
                        numB += countB - 2;
                    }
                    countB = 0;
                    countA = 1;
                    ch = 'A';
                }
            }
        }
        return numA > numB;
    }
}

public class ColouredNeighbors {

}
