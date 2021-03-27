## reutrn number of ways to get a sum of n given an array of integers




def get_ways(n, arr):
    num_ints = len(arr)

    matrix = [[0] * (n+1)] * (num_ints+1)
    for row in range(n+1):
        matrix[row] = [0] * (n+1)

    for i in range(num_ints + 1):
        num = arr[i]

        for curr_sum in range(1, n+1):
            if curr_sum < num:
                matrix[i][curr_sum] = matrix[i-1][curr_sum]
            else:
                matrix[i][curr_sum] = 1 + matrix[i][curr_sum - num]

    return matrix[arr[-1]][-1]



