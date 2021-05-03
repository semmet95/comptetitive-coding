T = int(input())

for _ in range(T):
    N, R = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))

    tfr = B[0]
    tfr_max = tfr

    for i in range(1, N):
        relaxed_tension = (R * (A[i] - A[i-1])) if tfr - (R * (A[i] - A[i-1])) >= 0 else tfr

        tfr = tfr - relaxed_tension + B[i]

        if tfr > tfr_max:
            tfr_max = tfr

    print(tfr_max)