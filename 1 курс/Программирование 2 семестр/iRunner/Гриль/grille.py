from itertools import chain

with open('grille.in', 'r') as f:
    data = f.readlines()

N = int(data[0])
m = [[ 1 if e=='*' else 0 for e in row] for row in data[1:]]
result = [ [m[i][j] + m[N-1-j][i] + m[N-1-i][N-1-j] + m[j][N-1-i] for i in range(N//2)] for j in range(N//2)]
print('YES' if all(x==1 for x in chain(*result)) else 'NO', file=open('grille.out', 'w'))

