#!/bin/python3

import math
import os
import random
import re
import sys



#
# Complete the 'maxSubarrayValue' function below.
#
# The function is expected to return a LONG_INTEGER.
# The function accepts INTEGER_ARRAY arr as parameter.
#

def maxSubarrayValue(arr):
    # Write your code here
    matrix = [0] * 2
    for i in range(2):
        matrix[i] = [0] * len(arr)
        
    max_val = -1
    curr_sum = 0

    for col in range(len(arr)):
        if col%2 == 0:
            curr_sum += arr[col]
        else:
            curr_sum -= arr[col]
        
        matrix[0][col] = curr_sum

        if matrix[0][col] ** 2 > max_val:
            max_val = matrix[0][col] ** 2

    for i in range(1, len(arr)):
        for col in range(0, len(arr) - i):
            matrix[1][col] = matrix[0][0] - matrix[0][col+1]

            if matrix[1][col] ** 2 > max_val:
                max_val = matrix[1][col] ** 2

        matrix[0] = matrix[1]
        matrix[1] = [0] * len(arr)
    
    return max_val


if __name__ == '__main__':
    #fptr = open(os.environ['OUTPUT_PATH'], 'w')

    arr_count = int(input().strip())

    arr = []

    for _ in range(arr_count):
        arr_item = int(input().strip())
        arr.append(arr_item)

    result = maxSubarrayValue(arr)

    print(result)

    #fptr.write(str(result) + '\n')

    #fptr.close()
