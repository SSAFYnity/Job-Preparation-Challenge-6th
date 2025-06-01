def solution(storey):
    answer = 0
    while storey > 0:
        digit = storey % 10
        storey //= 10

        if digit == 5:
            if storey % 10 >= 5:
                answer += 5
                storey += 1
            else:
                answer += 5
        elif digit > 5:
            answer += 10 - digit
            storey += 1
        else:
            answer += digit
    return answer