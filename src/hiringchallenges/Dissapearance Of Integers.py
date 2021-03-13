def dissappear_even_idx(ans_matrix, row=1):
    for idx in range(0, len(ans_matrix[0]), 2):
        ans_matrix[row] = [ele for ele in ans_matrix[row-1]]

        ans_matrix[row][idx] = -1
        row += 1

    return row

def dissappear_odd_idx(ans_matrix, row):
    for idx in range(1, len(ans_matrix[0]), 2):
        ans_matrix[row] = [ele for ele in ans_matrix[row-1]]

        ans_matrix[row][idx] = -1
        row += 1

    return row

def reappear_even_idx(ans_matrix, row, arr):
    for idx in range(0, len(ans_matrix[0]), 2):
        ans_matrix[row] = [ele for ele in ans_matrix[row-1]]

        ans_matrix[row][idx] = arr[idx]
        row += 1

    return row

def reappear_odd_idx(ans_matrix, row, arr):
    for idx in range(1, len(ans_matrix[0]), 2):
        ans_matrix[row] = [ele for ele in ans_matrix[row-1]]

        ans_matrix[row][idx] = arr[idx]
        row += 1

        if(row == len(ans_matrix)):
            return

N = int(input())
arr = list(map(int, input().strip().split()))

ans_matrix = [[-1 for _ in arr] for _ in range(2 * N)]
ans_matrix[0] = [ele for ele in arr]

row = dissappear_even_idx(ans_matrix)
row = dissappear_odd_idx(ans_matrix, row)
row = reappear_even_idx(ans_matrix, row, arr)
row = reappear_odd_idx(ans_matrix, row, arr)

#print(ans_matrix)

Q = int(input())

for _ in range(Q):
    t, M = map(int, input().strip().split())
    t %= 2 * N

    arr_at_t = ans_matrix[t]

    ctr = 0
    for ele in arr_at_t:
        if ele != -1:
            ctr += 1

            if(ctr == M):
                print(ele)
                break

    if ctr < M:
        print(-1)    