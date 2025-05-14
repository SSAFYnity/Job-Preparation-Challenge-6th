from collections import deque

que = deque([2, 3])
prime_lst = deque([2, 3])

# 소수 판별 함수
def is_divisor(n):
    for x in range(2, n):
        if n % x == 0:
            return False
    return True

# 소수 목록 만들기
for i in range(4, 10000):
    flg = True
    for j in prime_lst:
        if i % j == 0:
            flg = False
            break
    if flg and is_divisor(i):
        prime_lst.append(i)

def two_pointer(n):
    mid = n//2
    min_d = 10000
    mid_i = 10000
    for x in range(0, len(prime_lst)):
        if mid - prime_lst[x] < 0:
            break
        if mid - prime_lst[x] < min_d:
            min_d = mid - prime_lst[x]
            mid_i = x
    left = mid_i
    right = mid_i
    while prime_lst[left] + prime_lst[right] != n:
        if prime_lst[left] + prime_lst[right] < n:
            right += 1
        else:
            left -= 1
    print(prime_lst[left], prime_lst[right])

T = int(input())
for _ in range(T):
    num = int(input())
    two_pointer(num)