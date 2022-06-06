n = int(input())
ranked = list(map(int, input().split()))

m = int(input())

player = list(map(int, input().split()))
player_copy = [ele for ele in player]
player = list(set(player))

ranked_unq = list(set(ranked))
ranked_unq.sort(reverse = True)

ranks = {}
curr_rank = 0
index_player = len(player) - 1

for score in ranked_unq:
    curr_rank += 1

    while player[index_player] > score and index_player >= 0:

        ranks[player[index_player]] = curr_rank
        index_player -= 1

    if index_player < 0:
        break

    if player[index_player] == score:

        ranks[player[index_player]] = curr_rank
        index_player -= 1

while index_player >= 0:

    ranks[player[index_player]] = curr_rank 
    index_player -= 1

for player_score in player_copy:
    print(ranks[player_score])
