from collections import deque


def solution(n, t, m, timetable):
    answer = 100
    new_timetable = []
    for i in range(len(timetable)):
        hour, minute = timetable[i].split(":")
        time = 60 * int(hour) + int(minute)
        new_timetable.append(time)
    new_timetable.sort()
    timetable_q = deque(new_timetable)

    now = 9 * 60
    while n > 1:
        cnt = 0
        while cnt < m and timetable_q[0] <= now:
            cnt += 1
            timetable_q.popleft()
        n -= 1
        now += t
    if len(timetable_q) < m:
        answer = now
    else:
        tmp = 0
        for i in range(m):
            if timetable_q[i] <= now:
                tmp = max(tmp, timetable_q[i])
            else:
                tmp = now + 1
                break
        answer = tmp - 1

    hour = answer // 60
    minute = answer % 60
    if (hour < 10):
        hour = '0' + str(hour)
    if (minute < 10):
        minute = '0' + str(minute)
    answer = str(hour) + ":" + str(minute)
    return answer