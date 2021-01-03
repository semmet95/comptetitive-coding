## optimized solution for the Knapsack 0/1 problem

t = int(input())

for i in range(t):
    n, k = map(int, input().split())
    arr = list(map(int, input().split()))

    arr[1:n+1] = arr[0:n]
    arr[0] = 0

    matrix = [[0] * (k+1)] * (n+1)
    for row in range(n+1):
        matrix[row] = [0] * (k+1)

    for row in range(1, n+1):
        for col in range(1, k+1):
            prev_optimized_weight = matrix[row-1][col]

            if col < arr[row]:
                matrix[row][col] = prev_optimized_weight
            else:
                curr_item_val = arr[row]
                max_curr_item_val = curr_item_val + max(matrix[row][col-arr[row]], matrix[row-1][col-arr[row]])
                matrix[row][col] = max(prev_optimized_weight, max_curr_item_val)

    print(matrix[n][k])