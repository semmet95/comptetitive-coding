T = int(input())

for _ in range(T):

    n, x = map(int, input().split())

    A = list(map(int, input().split()))
    dstnct_flavs = len(set(A))

    if dstnct_flavs <= len(A) - x:
        print(dstnct_flavs)

    else:
        print(dstnct_flavs - (x - (n - dstnct_flavs)))