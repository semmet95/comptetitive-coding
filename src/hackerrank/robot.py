import random

N = int(input())
V = []
P = []

for i in range(N):
    Vi, Pi = map(int, input().split())

    V.append(Vi)
    P.append(Pi)

score = 0

def Go(step, energy):
    global score

    if(step == N-1):
        score += V[step]
        return score
    
    else:
        #way = random.choice((1,2))

        way = 1 if energy > 0 else 2

        if way == 1:
            score += V[step]

        else:
            energy = P[step]

        if energy > 0:
            Go(step+1, energy-1)

        else:
            exit()

Go(1,0)

print(score)