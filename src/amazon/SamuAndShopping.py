# https://www.hackerearth.com/problem/algorithm/samu-and-shopping-165-5691d19b/

T = int(input())

for _ in range(T):
    N = int(input())
    all_shops = []

    for _ in range(N):
        all_shops.append(list(map(int, input().strip().split())))

    foo = 0
    min_total_costs = [[foo for i in range(3)] for j in range(N)]

    min_total_costs[0][0] = all_shops[0][0]
    min_total_costs[0][1] = all_shops[0][1]
    min_total_costs[0][2] = all_shops[0][2]

    for i in range(1, len(all_shops)):

        min_total_costs[i][0] = all_shops[i][0] + min(min_total_costs[i-1][1], min_total_costs[i-1][2])
        min_total_costs[i][1] = all_shops[i][1] + min(min_total_costs[i-1][0], min_total_costs[i-1][2])
        min_total_costs[i][2] = all_shops[i][2] + min(min_total_costs[i-1][0], min_total_costs[i-1][1])

    print(min(min_total_costs[-1]))