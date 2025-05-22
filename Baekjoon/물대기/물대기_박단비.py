from heapq import heappush, heappop

N = int(input())
wells = []
q = []

for i in range(N):
    cost = int(input())
    wells.append(cost)
    heappush(q, (cost, i))

board = [list(map(int, input().split())) for _ in range(N)]
cost = 0
visited = [0] * N

while q:
    c, cur = heappop(q)
    if visited[cur] == 0:
        visited[cur] = 1
        cost += c

        for next in range(N):
            if cur != next:
                if wells[next] > board[cur][next]:
                    wells[next] = board[cur][next]
                heappush(q, (wells[next], next))

print(cost)