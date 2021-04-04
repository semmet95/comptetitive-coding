from itertools import imap
T = int(raw_input())

for _ in xrange(T):
    N, M, K = imap(int, raw_input().split())

    matrix = []

    for _ in xrange(N):
        matrix.append(list(imap(int, raw_input().split())))

    dp = [0] * N
    for row in xrange(N):
        dp[row] = [0] * M

    dp[0][0] = matrix[0][0]
    for col in xrange(M):
        dp[0][col] = matrix[0][col] + dp[0][col-1]

    for row in xrange(N):
        dp[row][0] = matrix[row][0] + dp[row-1][0]

    for row in xrange(1, N):
        for col in xrange(1, M):
            dp[row][col] = dp[row-1][col] + dp[row][col-1] - dp[row-1][col-1] + matrix[row][col]

    ans = 0

    for row in xrange(N):
        for col in xrange(M):
            if matrix[row][col] >= K:
                ans += 1

    row_start_prev = None

    for l in xrange(2, min(N, M) + 1):

        submatrix_sum = dp[l-1][l-1]

        if submatrix_sum >= K * l * l:
            ans += (M - (l-1)) * (N - (l-1))
            continue

        row_start = None
        if row_start_prev == None:
            row_start_prev = l-1

        for i in xrange(row_start_prev, N):
            if sum(matrix[i][-l:]) >= l * K:
                row_start = i
                break
        if row_start == None:
            continue
        row_start_prev = max(row_start, l)

        prev_submatrix_sum = 0
        rest_worthy = False
        for row in xrange(row_start, N):

            col_start = None
            left = l-1
            right = M-1

            while left <= right:
                mid = (left + right) / 2

                submat_sum = dp[row][mid] \
                                - (0 if row - l < 0 else dp[row-l][mid]) \
                                - (0 if mid - l < 0 else dp[row][mid-l]) \
                                + (0 if mid - l < 0 or row - l < 0 else dp[row-l][mid-l])

                if submat_sum < K * l * l:
                    left = mid + 1
                elif submat_sum >= K * l * l:
                    right = mid - 1
                    col_start = mid
                '''else:
                    col_start = mid
                    break'''

            if col_start != None:
                if col_start == l-1:
                    ans += (M - col_start) * (N - row)
                    break
                else:
                    ans += (M - col_start)
                    continue

    print ans
