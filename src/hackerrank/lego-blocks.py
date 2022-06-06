## https://www.hackerrank.com/challenges/lego-blocks/problem

all_n = []
all_m = []
MOD = (10 ** 9) +7

t = int(input())

for _ in range(t):
    n, m = map(int, input().split())

    all_n.append(n)
    all_m.append(m)

max_n = max(all_n)
max_m = max(all_m)

all_walls = [0] * (max_n+1)
solid_walls = [0] * (max_n+1)
prev_products = [0] * (max_n+1)

for index in range(max_n+1):
    all_walls[index] = [0] * (max_m+1)
    solid_walls[index] = [0] * (max_m+1)
    prev_products[index] = [0] * (max_m+1)

all_walls[1][0] = 1
all_walls[1][1] = 1
all_walls[1][2] = 2
all_walls[1][3] = 4
all_walls[1][4] = 8

for col in range(5, max_m+1):
    all_walls[1][col] = sum([all_walls[1][col-x] for x in range(1, 5)]) % MOD

for row in range(2, max_n+1):
    for col in range(1, max_m+1):
        all_walls[row][col] = (all_walls[1][col] * all_walls[row-1][col]) % MOD

for row in range(1, max_n+1):
    solid_walls[row][1] = 1

for col in range(1, 5):
    solid_walls[1][col] = 1

for row, col in zip(all_n, all_m):

    for col2 in range(2, col+1):
        prev_products[row][col2] = sum([(solid_walls[row][x] * all_walls[row][col2-x]) % MOD for x in range(1, col2)]) % MOD

        solid_walls[row][col2] = (all_walls[row][col2] - prev_products[row][col2] + MOD) % MOD
    
    print(solid_walls[row][col])