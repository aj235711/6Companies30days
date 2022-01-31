package wallmart;

import java.util.Random;

class Solution {
    private static final Random random = new Random();
    double rad, xc, yc;

    public Solution(double radius, double x_center, double y_center) {
        this.rad = radius;
        this.xc = x_center;
        this.yc = y_center;
    }

    public double[] randPoint() {
        double r = Math.sqrt(random.nextDouble()) * this.rad, theta = random.nextDouble() * 2 * Math.PI;
        double x = this.xc + r * Math.cos(theta), y = this.yc + r * Math.sin(theta);
        double[] ans = { x, y };
        return ans;
    }
}

public class RandomPoint {

}
