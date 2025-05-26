while True:
    N, A, B = map(int, input().split())
    if N == 0 and A == 0 and B == 0:
        break
    ans = 0
    team = [list(map(int, input().split())) for _ in range(N)]
    team.sort(key=lambda x : -abs(x[1] - x[2]))

    for i in range(N):
        # A방에 있는거 빼야하는 경우
        if team[i][1] < team[i][2]:
            if A >= team[i][0]:
                ans += team[i][0] * team[i][1]
                A -= team[i][0]
            else:
                tmp = team[i][0] - A
                ans += A * team[i][1]
                A = 0
                ans += tmp * team[i][2]
                B -= tmp
        # B방에 있는거 빼야하는 경우
        else:
            if B >= team[i][0]:
                ans += team[i][0] * team[i][2]
                B -= team[i][0]
            else:
                tmp = team[i][0] - B
                ans += B * team[i][2]
                B = 0
                ans += tmp * team[i][1]
                A -= tmp
    print(ans)