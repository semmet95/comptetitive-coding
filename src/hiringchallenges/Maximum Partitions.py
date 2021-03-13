def maximize(arr, idx):
    ele_sum = arr[idx]
    idx += 1

    while(idx < len(arr) and (ele_sum + arr[idx] >= ele_sum)):
        ele_sum += arr[idx]
        idx += 1

    return ele_sum, idx

def minimize(arr, idx):
    ele_sum = arr[idx]
    idx += 1

    while(idx < len(arr) and (ele_sum + arr[idx] <= ele_sum)):
        ele_sum += arr[idx]
        idx += 1

    return ele_sum, idx

N = int(input())
arr = list(map(int, input().strip().split()))

arr_sum = 0
idx = 0
func_switch = True

while(idx < len(arr)):
    if(func_switch):
        temp_sum, idx = maximize(arr, idx)
        arr_sum += temp_sum

    else:
        temp_sum, idx = minimize(arr, idx)
        arr_sum -= temp_sum

    func_switch = not func_switch

print(arr_sum)