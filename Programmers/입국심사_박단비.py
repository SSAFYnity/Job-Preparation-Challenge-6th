def solution(n, times):
    answer = 0
    left = 0
    right = max(times) * n;
    while (left <= right):
        mid = (left + right) // 2;
        people = 0
        for time in times:
            people += mid // time
            if people >= n:
                break

        # n명을 넘겨서 심사 한거면 시간이 너무 많은 상황
        # 딱 n명을 심사했더라도 시간은 남을 수 있음
        if people >= n:
            answer = mid
            right = mid - 1
        else:
            left = mid + 1

    return answer