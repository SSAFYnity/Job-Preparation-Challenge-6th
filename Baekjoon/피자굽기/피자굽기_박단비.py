D, N = map(int, input().split())
oven = list(map(int, input().split()))
pizza = list(map(int, input().split()))

# 1. oven 재정렬. 이전 오븐 기준으로 그거보다 큰 도우는 들어갈 수 없음
# ex) 5 6 4 3 6 2 3 -> 5 5 4 3 3 2 2
for i in range(len(oven)-1):
    if oven[i] < oven[i+1]:
        oven[i+1] = oven[i]

# 반죽 넣기
p = 0 # 오븐에 넣은 피자 개수
idx = D - 1 # 오븐 인덱스
while idx >= 0:
    if pizza[p] <= oven[idx]:
        p += 1
        if p == N:
            break

    idx -= 1
if p == N:
    print(idx + 1)
else:
    print(0)