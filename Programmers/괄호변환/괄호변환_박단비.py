# 균형잡힌 괄호 문자열인지 확인
import sys
sys.setrecursionlimit(10**9)

def check_len(w):
    cnt_1 = 0
    cnt_2 = 0
    for i in w:
        if i == '(':
            cnt_1 += 1
        else:
            cnt_2 += 1
    if cnt_1 == cnt_2:
        return True
    else:
        return False


# 올바른 괄호 문자열인지 확인
def check_gwalho(w):
    stack = []
    for i in w:
        if i == '(':
            stack.append('(')
        else:
            if stack:
                stack.pop()
            else:
                return False
    if stack:
        return False
    return True


def solution(p):
    answer = ''
    if p == "":
        return p

    if p == ')(':
        return '()'

    if check_gwalho(p):
        return p

    for i in range(2, len(p)+1, 2):
        u = p[:i]
        v = p[i:]
        # print('u : ', u, 'v : ', v)
        if not (check_len(u) and (check_len(v) or len(v) == 0)):
            continue

        if check_gwalho(u):
            new_p = u + solution(v)
            if check_gwalho(new_p):
                return new_p

        else:
            tmp = '('
            tmp += solution(v) + ')'
            new_arr = ''
            for j in range(1, len(u)-1):
                if u[j] == '(':
                    new_arr += ')'
                else:
                    new_arr += '('
            for j in new_arr:
                tmp += j
            if check_gwalho(tmp):
                return tmp