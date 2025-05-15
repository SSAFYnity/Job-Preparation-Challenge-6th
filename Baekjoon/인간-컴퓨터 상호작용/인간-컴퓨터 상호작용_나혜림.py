import sys
input = sys.stdin.readline

data = input().strip()
T = int(input())

# 누적합 배열 초기화: 각 알파벳에 대해 누적합을 저장
prefix = [[0] * (len(data) + 1) for _ in range(26)]

# 누적합 계산
for i in range(len(data)):
    for j in range(26):
        prefix[j][i+1] = prefix[j][i]  # 이전 값 복사
    prefix[ord(data[i]) - 97][i+1] += 1  # 해당 알파벳 개수 증가

# 질의 처리
for _ in range(T):
    char, l, r = input().split()
    x = ord(char) - 97
    l = int(l)
    r = int(r)
    print(prefix[x][r+1] - prefix[x][l])