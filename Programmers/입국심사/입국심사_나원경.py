# 250515
def solution(n, times):
    start, end = 0, min(times) * n
    while start <= end:
        mid = (start + end) // 2
        headcount = 0
        for time in times:
            headcount += mid // time

        if headcount >= n:
            end = mid - 1
        else:
            start = mid + 1

    return start

'''
정확성  테스트
테스트 1 〉	통과 (0.01ms, 9.09MB)
테스트 2 〉	통과 (0.06ms, 9.17MB)
테스트 3 〉	통과 (3.60ms, 9.21MB)
테스트 4 〉	통과 (152.86ms, 13.4MB)
테스트 5 〉	통과 (491.01ms, 13.4MB)
테스트 6 〉	통과 (317.79ms, 13.2MB)
테스트 7 〉	통과 (407.69ms, 13.4MB)
테스트 8 〉	통과 (606.93ms, 13.5MB)
테스트 9 〉	통과 (0.02ms, 9.2MB)
'''