# import sys
# input = sys.stdin.readline
# S = list(input().rstrip())
# cnt_arr = [[0] * 26 for _ in range(len(S))]
# cnt_arr[0][ord(S[0]) - 97] = 1
#
# for i in range(1, len(S)):
#     cnt_arr[i][ord(S[i])-97] = 1
#     for j in range(26):
#         cnt_arr[i][j] += cnt_arr[i-1][j]
#
# q = int(input())
# for _ in range(q):
#     arr = list(input().rstrip().split())
#     target, s, e = arr[0], int(arr[1]), int(arr[2])
#     if s == 0:
#         print(cnt_arr[e][ord(target)-97])
#     else:
#         print(cnt_arr[e][ord(target)-97] - cnt_arr[s-1][ord(target)-97])

import sys
input = sys.stdin.readline
S = list(input().rstrip())
q = int(input().rstrip())

count = [[0] * 26]
for i in range(len(S)):
    count.append(count[len(count)-1][:])
    count[i+1][ord(S[i])-97] += 1

for _ in range(q):
    target, s, e = input().rstrip().split()
    answer = count[int(e)+1][ord(target)-97] - count[int(s)][ord(target)-97]
    print(answer)