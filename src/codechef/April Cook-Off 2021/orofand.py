T = int(input())

for _ in range(T):
    N, Q = map(int, input().split())
    A = list(map(int, input().split()))

    or_of_and = 0

    for i in A:
        or_of_and = or_of_and | i

    print(or_of_and)

    for _ in range(Q):
        X, V = map(int, input().split())
        A[X-1] = V

        or_of_and = 0

        for i in A:
            or_of_and = or_of_and | i

        print(or_of_and)
