## https://www.hackerrank.com/challenges/bigger-is-greater/problem

T = int(input())

for _ in range(T):
    w = input()
    if len(w) == 1:
        print("no answer")
        continue

    switch_index = None

    case_handled = False
    found_index = False
    right = len(w) - 1

    while right > 0 and w[right-1] >= w[right]:
        right -= 1

    if right == 0 and w[0] >= w[1]:
        print("no answer")
        continue
    
    switch_index = right - 1
    min_greatest = right

    for i in range(right, len(w)):
        if w[i] > w[switch_index] and w[i] < w[min_greatest]:
            min_greatest = i

    temp = w[:right-1] + w[min_greatest] + w[right:min_greatest] + w[right-1] + w[min_greatest+1:]
    temp = temp[:right] + ''.join(sorted(temp[right:]))

    print(temp)