# from math import sqrt
# import sys
# input = sys.stdin.readline
#
# def find(x):
#     for k in range(2, int(sqrt(x)) + 1):
#         if x % k == 0:
#             return False
#     return True
#
# prime = [False] * 10001
# prime[2] = True
# for i in range(3, 10001):
#     if find(i):
#         prime[i] = True
#
# num_info = dict()
# for i in range(10001):
#     for j in range(10001):
#         if prime[i] and prime[j]:
#             if i+j in num_info:
#                 if abs(i-j) < abs(num_info[i+j][0] - num_info[i+j][1]):
#                     num_info[i+j] = [i, j]
#             else:
#                 num_info[i+j] = [i, j]
#
# T = int(input())
# for _ in range(T):
#     n = int(input())
#     print(*num_info[n])

from math import sqrt
import sys
input = sys.stdin.readline

def isPrime(x):
    if x == 1:
        return False
    for k in range(2, int(sqrt(x)) + 1):
        if x % k == 0:
            return False
    return True

T = int(input())
for _ in range(T):
    num = int(input())
    a, b = num // 2, num // 2

    while a > 0:
        if isPrime(a) and isPrime(b):
            print(a, b)
            break
        else:
            a -= 1
            b += 1
