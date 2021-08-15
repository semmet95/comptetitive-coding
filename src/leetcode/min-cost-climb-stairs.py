## https://leetcode.com/problems/min-cost-climbing-stairs/

cost = list(map(int, input().split()))

cost_optimized = cost.copy()

if len(cost) == 2:
    print(min(cost))

else:
    for i in range(2, len(cost)):
        cost_optimized[i] += min(cost_optimized[i-1], cost_optimized[i-2])

    print(cost_optimized[-1])