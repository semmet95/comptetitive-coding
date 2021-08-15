## https://leetcode.com/problems/climbing-stairs/

class Solution:
        
    def climbStairs(self, n: int) -> int:
        if n == 1:
            return 1
        if n == 2:
            return 2
        
        step1 = 2
        step2 = 1

        total_steps = 0

        for _ in range(3, n+1):
            total_steps = step1 + step2
            step2 = step1
            step1 = total_steps

        return total_steps

solution = Solution()

solution.climbStairs(38)