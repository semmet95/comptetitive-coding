## problem source: https://www.hackerrank.com/challenges/construct-the-array/problem

## create a table with x on X-Axis (with max value of k) and n on the Y-Axis to better understand the algorithm

n, k, x = map(int, input().split())

last_n_row = [k-2] * k
last_n_row.insert(1, k-1)
last_n_row[0] = 0

if n == 3:
    print(last_n_row[x])

else:
    for i in range(4, n+1):
        
        last_n_row_sum = (last_n_row[1] + ((last_n_row[2] * (k-1)) %  1000000007)) % 1000000007

        curr_n_row = [0] * 3
        curr_n_row[2] = (last_n_row_sum - last_n_row[2]) % 1000000007
        curr_n_row[1] = (last_n_row_sum - last_n_row[1]) % 1000000007
        curr_n_row[0] = 0
        last_n_row = curr_n_row

    print(last_n_row[1] if x == 1 else last_n_row[2])