from math import sqrt
R, G = map(int, input().split())

def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a % b)

tmp = gcd(R, G)
ans = []

for i in range(1, int(sqrt(tmp)) + 1):
    if tmp % i == 0:
        ans.append(i)
        if tmp // i == i:
            continue
        ans.append(tmp // i)

for i in ans:
    print(i, R//i, G//i)
