T = int(input())

for _ in range(T):
    
    a_min, b_min, c_min, t_min, a, b, c = map(int, input().split())

    if a >= a_min and b >= b_min and c >= c_min and a + b + c >= t_min:
        print("YES")
    else:
        print("NO")