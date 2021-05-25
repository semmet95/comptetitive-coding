## https://www.hackerrank.com/challenges/ctci-coin-change/problem

n, m = map(int, input().split())

coin_dp = [0] * (m+1)
for row in range(m+1):
    coin_dp[row] = [0] * (n+1)

coins = list(map(int, input().split()))
coins.insert(0, 0)

for col in range(n+1):
    coin_dp[0][col] = 0

for row in range(m+1):
    coin_dp[row][0] = 0

for index in range(1, m+1):
    coin = coins[index]

    for coin_sum in range(1, n+1):

        if coin_sum < coin:
            coin_dp[index][coin_sum]  = coin_dp[index-1][coin_sum]
        elif coin_sum > coin:
            coin_dp[index][coin_sum]  = coin_dp[index-1][coin_sum] + coin_dp[index][coin_sum - coin]
        elif coin_sum == coin:
            coin_dp[index][coin_sum]  = coin_dp[index-1][coin_sum] + 1

print(coin_dp[m][n])