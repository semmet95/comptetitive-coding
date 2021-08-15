
## https://leetcode.com/problems/counting-bits/
n = int(input())

ans = [0, 1]

for i in range(2, n+1):
    ans.append(ans[i//2] + i%2)

print(*ans, sep='')