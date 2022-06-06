T = int(input())

for _ in range(T):
    k1, k2, k3, v = map(float, input().split())

    v_final = k1 * k2 * k3 * v
    time_taken = round(100/v_final, 2)

    print('YES' if time_taken <  9.58 else 'NO')