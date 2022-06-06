## https://www.hackerrank.com/challenges/mandragora/problem

t = int(input())

for _ in range(t):
    n = int(input())
    H = list(map(int, input().split()))
    H.sort()
    
    s = 1
    cumulative_sum = [0] * n
    cumulative_sum[-1] = H[-1]

    if n == 1:
        print(cumulative_sum[-1])
        continue

    for index in range(len(H)-2, -1, -1):
        cumulative_sum[index] = cumulative_sum[index+1] + H[index]

    index = 0
    max_sum = s * cumulative_sum[index]
    
    while index < len(cumulative_sum)-1 and s * cumulative_sum[index] < (s+1) * cumulative_sum[index+1]:
        s += 1
        max_sum = s * cumulative_sum[index+1]
        index += 1

    print(max_sum)
