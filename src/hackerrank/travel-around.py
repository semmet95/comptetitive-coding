N, C = map(int, input().split())

a = list(map(int, input().split()))
b = list(map(int, input().split()))

city = [False] * N

def check_start_point_extra(i, extra_fuel, start_point):

    while True:
        if(i == start_point):
            return True

        total_fuel = a[i%N] + extra_fuel
        total_fuel = total_fuel if total_fuel <= C else C

        if(b[i%N] > total_fuel):
            return False

        if city[i%N]:
            return True
        
        extra_fuel = total_fuel - b[i%N]
        i = (i+1)%N

    #return check_start_point_extra((i+1)%N, total_fuel - b[i%N], start_point)


def check_start_point(i):
    if(b[i%N] > a[i%N] or b[i%N] > C):
        return False

    if(city[(i+1)%N]):
        return True

    total_fuel = a[i%N] if a[i%N] <= C else C
    return check_start_point_extra((i+1)%N, total_fuel - b[i%N], i)

for i in range(N-1, -1, -1):
    city[i] = check_start_point(i)

ctr = sum([1 if valid_start_point else 0 for valid_start_point in city])
print(ctr)