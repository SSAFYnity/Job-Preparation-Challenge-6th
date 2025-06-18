def is_winner_with_gap(score, info):
    a = 0  # 어피치 점수
    b = 0  # 라이언 점수

    for i in range(11):
        if info[i] > 0 or score[i] > 0:
            if info[i] >= score[i]:
                a += (10 - i)
            else:
                b += (10 - i)

    return b > a, abs(b - a)


def dfs(L, cnt, info, score):
    global max_diff, answer
    if L == 11 or cnt == 0:
        is_winner, gap = is_winner_with_gap(score, info)
        if is_winner:
            if cnt >= 0:  # 화살이 남은 경우
                score[10] = cnt  # 남은거 0점에 다 쏴도 이김

            if gap > max_diff:
                max_diff = gap
                answer = score[:]
            elif gap == max_diff:  # 가장 낮은 점수를 많이 맞힌 경우로 업데이터
                for i in range(11):
                    if answer[i] > 0:
                        max_i_1 = i
                    if score[i] > 0:
                        max_i_2 = i

                if max_i_2 > max_i_1:
                    answer = score[:]
        return
    # k점을 어피치보다 많이 맞추거나 아예 안맞추거나
    if cnt > info[L]:
        score[L] = info[L] + 1
        dfs(L + 1, cnt - (info[L] + 1), info, score)
        score[L] = 0
    dfs(L + 1, cnt, info, score)


def solution(n, info):
    global max_diff, answer
    answer = [-1]
    max_diff = 0
    score = [0] * 11

    dfs(0, n, info, score)
    return answer