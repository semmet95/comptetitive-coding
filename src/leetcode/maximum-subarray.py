## https://leetcode.com/problems/maximum-subarray/

class Solution:
    def maxSubArray(self, nums) -> int:
        if len(nums) == 1:
            return nums[0]

        window_sum = 0
        right = 0
        max_sum = -10**10

        while right < len(nums):
            window_sum += nums[right]
            if window_sum > max_sum:
                max_sum = window_sum
            
            if window_sum < 0 and right < len(nums)-1:
                window_sum = 0

            right += 1
        return max_sum

sol = Solution()
print(sol.maxSubArray([-1,-2]))