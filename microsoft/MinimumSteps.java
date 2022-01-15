package microsoft;

import java.io.*;

class Solution {
    int minSteps(int D) {
        // code here
        int count = 0, sum = 0;
        while (count < D) {
            count++;
            sum += count;
            if (sum == D) {
                return count;
            }
            if (sum > D) {
                while ((sum - D) % 2 != 0) {
                    count++;
                    sum += count;
                }
                break;
            }
        }
        return count;
    }
}

public class MinimumSteps {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int D = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            System.out.println(ob.minSteps(D));
        }
    }
}
