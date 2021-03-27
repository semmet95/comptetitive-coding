magic_sols =   [
            [[8, 1, 6], [3, 5, 7], [4, 9, 2]],
            [[6, 1, 8], [7, 5, 3], [2, 9, 4]],
            [[4, 9, 2], [3, 5, 7], [8, 1, 6]],
            [[2, 9, 4], [7, 5, 3], [6, 1, 8]], 
            [[8, 3, 4], [1, 5, 9], [6, 7, 2]],
            [[4, 3, 8], [9, 5, 1], [2, 7, 6]], 
            [[6, 7, 2], [1, 5, 9], [8, 3, 4]], 
            [[2, 7, 6], [9, 5, 1], [4, 3, 8]],
        ]

matrix = []
for _ in range(3):
    matrix.append(list(map(int, input().split())))

all_difs = []
for each_sol in magic_sols:

    curr_dif = 0
    for row1, row2 in zip(matrix, each_sol):

        curr_dif += sum([abs(ele1-ele2) for ele1, ele2 in zip(row1, row2)])

    all_difs.append(curr_dif)

print(min(all_difs))