def time_c(t):  # 시간계산
    return int(t.split(':')[0]) * 60 + int(t.split(':')[1])


def change(x):  # #음 치환
    exc = {'C#': '1', 'D#': '2', 'F#': '3', 'G#': '4', 'A#': '5', 'B#': '6'}
    for k, v in exc.items():
        x = x.replace(k, v)
    return x


def solution(m, musicinfos):
    answer = []
    for info in musicinfos:
        info = info.split(',')
        info[3] = change(info[3])
        T = time_c(info[1]) - time_c(info[0])  # 시간계산

        if T >= len(info[3]):  # 시간이 길이보다 길면
            M = info[3] * (T // len(info[3])) + info[3][:T % len(info[3])]
        else:  # 시간이 길이보다 짧으면
            M = info[3][:T]

        if change(m) in M:  # 들은음이 있으면
            answer.append([T, info[2]])

    if len(answer) == 0:
        return '(None)'
    else:
        return sorted(answer, key=lambda x: -x[0])[0][1]