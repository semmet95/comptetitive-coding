import re

T = int(input())

for _ in range(T):
    N, K = map(int, input().split())
    S = input()

    star_groups = re.split("[a-z]", S)
    biggest_seq = max([len(group) for group in star_groups])

    print('YES' if biggest_seq >= K else "NO")