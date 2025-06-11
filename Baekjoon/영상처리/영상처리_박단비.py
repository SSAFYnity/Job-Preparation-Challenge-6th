from collections import deque

N, M = map(int, input().split())
board = [[0] * M for _ in range(N)]
for i in range(N):
    arr = list(map(int, input().split()))
    for j in range(0, 3 * M, 3):
        tmp = (arr[j] + arr[j+1] + arr[j+2]) / 3
        board[i][j//3] = tmp

T = int(input())
for i in range(N):
    for j in range(M):
        if board[i][j] >= T:
            board[i][j] = 1
        else:
            board[i][j] = 0

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

def bfs(i, j):
    q = deque()
    q.append((i, j))
    visited[i][j] = True
    while q:
        r, c = q.popleft()
        for k in range(4):
            nr = r + dr[k]
            nc = c + dc[k]
            if 0 <= nr < N and 0 <= nc < M:
                if board[nr][nc] == 1 and not visited[nr][nc]:
                    q.append((nr, nc))
                    visited[nr][nc] = True

visited = [[False] * M for _ in range(N)]
ans = 0
for i in range(N):
    for j in range(M):
        if board[i][j] == 1 and not visited[i][j]:
            bfs(i, j)
            ans += 1

print(ans)