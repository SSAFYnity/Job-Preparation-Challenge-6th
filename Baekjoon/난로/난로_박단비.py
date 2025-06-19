from heapq import heappush, heappop
import sys
input = sys.stdin.readline
N, K = map(int, input().split())
friends = []
heap = []
answer = N
for i in range(N):
    f = int(input())
    friends.append(f)
    if i != 0:
        t = friends[i] - friends[i-1]
        heappush(heap, (t, i-1))

if K >= N:
    print(N)
else:
    while N-K > 0:
        tmp = heappop(heap)
        answer += tmp[0] - 1
        N -= 1
    print(answer)



