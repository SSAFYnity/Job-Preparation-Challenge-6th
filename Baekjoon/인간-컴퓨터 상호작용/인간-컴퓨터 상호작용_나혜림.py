data = input()
T = int(input())
basic = {
    'a': 0,
    'b': 0,
    'c': 0,
    'd': 0,
    'e': 0,
    "f": 0,
    "g": 0,
    "h": 0,
    "i": 0,
    "j": 0,
    "k": 0,
    "l": 0,
    "m": 0,
    "n": 0,
    "o": 0,
    "p": 0,
    "q": 0,
    "r": 0,
    "s": 0,
    "t": 0,
    "u": 0,
    "v": 0,
    "w": 0,
    "x": 0,
    "y": 0,
    "z": 0,
}

apt = list(basic.keys())
lst = []
for j in range(0, len(data)):
    if j == 0:
        lst.insert(j, basic)
    else:
        lst.insert(j, lst[j-1].copy())
    w = data[j]
    if w in lst[j].keys():
        if j != 0:
            x = lst[j-1][w] + 1
            lst[j][w] = x
        else:
            lst[j][w] += 1
    # lst[j]에 해당하는 알파벳의 숫자를 그 전 데이터와 비교해서 더해주기
for i in range(T):
    S, l, r = input().split()
    num1 = int(l)
    num2 = int(r)
    if data[num1] != S:
        print(lst[num2][S] - lst[num1][S])
    else:
        print(lst[num2][S] - lst[num1][S]+1)