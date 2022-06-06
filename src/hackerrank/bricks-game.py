t = int(input())

for case in range(t):
    n = int(input())
    arr = list(map(int, input().split()))

    dp = [0] * n
    dp[n-1] = sum(arr[n-1:])
    dp[n-2] = sum(arr[n-2:])
    dp[n-3] = sum(arr[n-3:])

    running_total = sum(arr[n-3:])

    for index in range(n-4, -1, -1):
        running_total += arr[index]
        p2_score = min(dp[index+1: index+4])

        dp[index] = running_total - p2_score

    print(dp[0])