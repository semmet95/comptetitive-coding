// https://leetcode.com/problems/climbing-stairs/description/

public class ClimbingStairs {
    private int pathsTaken = 0;
    public int climbStairs(int n) {
        int pathCounter[] = new int[n+1];
        pathCounter[1] = 1;
        pathCounter[2] = 2;
        
        for(int step = 3; step <= n; step++) {
            pathCounter[step] = pathCounter[step-2] * 2 + 1;
        }

        return pathCounter[n];
    }
}