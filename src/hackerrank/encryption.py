## https://www.hackerrank.com/challenges/encryption/problem

import math

s = input()
s = s.replace(' ', '')

L = len(s)
rows = math.floor(math.sqrt(L))
cols = math.ceil(math.sqrt(L))

if rows * cols < L:
    rows = cols

matrix = []
for i in range(rows):
    start = i * cols
    end = start + cols
    matrix.append(s[start:end])

for col in range(cols):
    for row in range(rows):
        if col < len(matrix[row]):
            print(matrix[row][col], end = '')
    print(' ', end = '')

print()