# 풀이 : 크루스칼 알고리즘으로 트리를 연결하고
#        x, y를 연결할 때 x 그래프에 y 넣고, y 그래프에 x 넣으면 트리 완성

import sys
input = sys.stdin.readline
from heapq import heappush, heappop

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a = find(a)
    b = find(b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

N = int(input())
q = []

for i in range(1, N):
    data = list(map(int, input().split()))
    for j in range(i+1, N+1):
        heappush(q, (data[j-(i+1)], i, j))

parent = [i for i in range(N+1)]
tree = [[] for _ in range(N+1)]

for i in range(N-1):
    while True:
        cost, x, y = heappop(q)
        if find(x) == find(y):
            continue
        union(x, y)
        tree[x].append(y)
        tree[y].append(x)
        break

for i in range(1, N+1):
    print(len(tree[i]), *sorted(tree[i]))
