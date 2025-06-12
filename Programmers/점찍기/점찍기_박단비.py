import math
def solution(k, d):
    answer = 0
    d2 = d * d
    for x in range(0, d+1, k):
        y = math.sqrt(d2 - (x*x))
        answer += y // k + 1
    return answer