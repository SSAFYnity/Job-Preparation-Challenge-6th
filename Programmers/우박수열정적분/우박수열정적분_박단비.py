def Ubak(k):
    result = []
    while k != 1:
        result.append(k)
        if k % 2 == 0:
            k //= 2
        else:
            k = k * 3 + 1
    result.append(k)
    return result


def solution(k, ranges):
    answer = []
    ubak = Ubak(k)

    for r in ranges:
        total = 0
        ubakRange = ubak[r[0]: len(ubak) + r[1]]

        # 주어진 구간의 시작점이 끝점보다 커서 유효하지 않은 구간
        if r[0] >= r[1] + len(ubak):
            answer.append(-1)
            continue

        for i in range(len(ubakRange) - 1):
            total += (((ubakRange[i] + ubakRange[i + 1]) * 1) / 2)
        answer.append(total)
    return answer