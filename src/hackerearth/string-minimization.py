def minimize_swapped(inp_swapped, left, right):
    if inp_swapped[left] != inp_swapped[right]:
        return 0

    left_start = left
    right_end = right

    while left_start >= 0 and right_end < len(inp_swapped):
        char_to_match = None

        if inp_swapped[left_start] == inp_swapped[right_end]:
            char_to_match = inp_swapped[left_start]
        else:
            break

        while left_start >= 0 and inp_swapped[left_start] == char_to_match:
            left_start -= 1

        while right_end < len(inp_swapped) and inp_swapped[right_end] == char_to_match:
            right_end += 1
    return right_end - left_start - 1

def string_minimization (inp):
    # Write your code here
    max_chars_removed = 0

    for pivot in range(1, len(inp)):
        inp_swapped = inp[pivot:] + inp[:pivot]
        chars_removed = minimize_swapped(inp_swapped, len(inp)-pivot-1, len(inp)-pivot)

        if chars_removed > max_chars_removed:
            max_chars_removed = chars_removed

    return len(inp) - max_chars_removed

inp = input()

out_ = string_minimization(inp)
print (out_)