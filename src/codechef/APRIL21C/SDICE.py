T = int(input())

pips_sums = [20, 36, 51, 60, 76, 88, 99, 104]

for _ in range(T):
    N = int(input())

    hidden_layers = ((N-1) // 4) -1
    if hidden_layers < 0:
        hidden_layers = 0

    sum = hidden_layers * 44
    remaining_die = N - (4 * hidden_layers)

    sum += pips_sums[remaining_die - 1]

    print(sum)