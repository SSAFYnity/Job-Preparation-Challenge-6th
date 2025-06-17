import math
N, R, G, B = map(int, input().split())

dp = [[[[0] * (B+1) for _ in range(G+1)] for _ in range(R+1)] for _ in range(N+1)]
# dp[i][r][g][b] : 빨간색 r개, 초록색 g개, 파란색 b개의 장식품으로 i단 트리를 꾸미는 경우

for i in range(N+1):
    for r in range(R+1):
        for g in range(G+1):
            for b in range(B+1):
                # 초기값 세팅
                if i == 0:
                    dp[i][r][g][b] = 1
                    continue
                # i단을 하나의 색으로만 꾸미는 경우
                if r - i >= 0:
                    dp[i][r][g][b] += dp[i-1][r-i][g][b] * 1
                if g - i >= 0:
                    dp[i][r][g][b] += dp[i-1][r][g-i][b] * 1
                if b - i >= 0:
                    dp[i][r][g][b] += dp[i-1][r][g][b-i] * 1

                # i단을 2개의 색으로 꾸미는 경우
                if i % 2 == 0:
                    tmp = i // 2
                    if r - tmp >= 0 and g - tmp >= 0:
                        dp[i][r][g][b] += dp[i - 1][r - tmp][g - tmp][b] * math.comb(i, tmp)
                    if r - tmp >= 0 and b - tmp >= 0:
                        dp[i][r][g][b] += dp[i - 1][r - tmp][g][b - tmp] * math.comb(i, tmp)
                    if g - tmp >= 0 and b - tmp >= 0:
                        dp[i][r][g][b] += dp[i - 1][r][g - tmp][b - tmp] * math.comb(i, tmp)

                # i단을 3개의 색으로 꾸미는 경우
                if i % 3 == 0:
                    tmp = i // 3
                    if r - tmp >= 0 and g - tmp >= 0 and b - tmp >= 0:
                        dp[i][r][g][b] += dp[i - 1][r - tmp][g - tmp][b - tmp] * math.comb(i, tmp) * math.comb(i-tmp, tmp)

print(dp[N][R][G][B])