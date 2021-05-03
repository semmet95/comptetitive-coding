#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'gridSearch' function below.
#
# The function is expected to return a STRING.
# The function accepts following parameters:
#  1. STRING_ARRAY G
#  2. STRING_ARRAY P
#

def gridSearch(G, P):
    # Write your code here

    R = len(G)
    C = len(G[0])
    r = len(P)
    c = len(P[0])

    for row in range(0, R-r+1):
        if P[0] in G[row]:
            
            for slider in range(0, C-c+1):
                rows_matched = True
                for check_row in range(row, row+r):
                    if not G[check_row][slider: slider+c] == P[check_row-row]:
                        rows_matched = False
                        break
                if rows_matched:
                    return "YES"

    return "NO"

if __name__ == '__main__':
    fptr = open('/home/amit/Rems/out', 'w')

    t = int(input().strip())

    for t_itr in range(t):
        first_multiple_input = input().rstrip().split()

        R = int(first_multiple_input[0])

        C = int(first_multiple_input[1])

        G = []

        for _ in range(R):
            G_item = input()
            G.append(G_item)

        second_multiple_input = input().rstrip().split()

        r = int(second_multiple_input[0])

        c = int(second_multiple_input[1])

        P = []

        for _ in range(r):
            P_item = input()
            P.append(P_item)

        result = gridSearch(G, P)

        fptr.write(result + '\n')

    fptr.close()
