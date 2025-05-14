# 250514
# 95436 KB / 544 ms
def main():
    from sys import stdin

    def convert(input_str):
        return int(input_str) if input_str.isdigit() else input_str

    new_input = stdin.readline
    S = new_input().rstrip()
    start_ord = ord('a')
    alp_to_idx = {chr(start_ord+i): i for i in range(26)}

    N = len(S)
    check_table = [[] for _ in range(N+1)]
    temp = [0] * 26
    check_table[0].extend(temp)

    for i in range(N):
        alp_idx = alp_to_idx[S[i]]
        temp[alp_idx] += 1
        check_table[i+1].extend(temp)

    q = int(input())
    for _ in range(q):
        alp, l, r = tuple(map(convert, new_input().split()))
        alp_idx = alp_to_idx[alp]
        print(check_table[r+1][alp_idx] - check_table[l][alp_idx])

main()




# 205648 KB / 756 ms
def main():
    from sys import stdin

    def convert(input_str):
        return int(input_str) if input_str.isdigit() else input_str

    new_input = stdin.readline
    S = new_input().rstrip()

    N = len(S)
    check_table = [{} for _ in range(N+1)]

    start_ord = ord('a')
    temp = {chr(start_ord+i): 0 for i in range(26)}
    check_table[0].update(temp)

    for i in range(N):
        temp[S[i]] += 1
        check_table[i+1].update(temp)

    q = int(input())
    for _ in range(q):
        alp, l, r = tuple(map(convert, new_input().split()))
        print(check_table[r+1][alp] - check_table[l][alp])

main()



# 95436 KB / 604 ms
def main():
    from sys import stdin

    def convert(input_str):
        return int(input_str) if input_str.isdigit() else input_str

    def new_input():
        return stdin.readline().rstrip()

    S = new_input()
    start_ord = ord('a')
    alp_to_idx = {chr(start_ord+i): i for i in range(26)}

    N = len(S)
    check_table = [[] for _ in range(N+1)]
    temp = [0] * 26
    check_table[0].extend(temp)

    for i in range(N):
        alp_idx = alp_to_idx[S[i]]
        temp[alp_idx] += 1
        check_table[i+1].extend(temp)

    q = int(input())
    for _ in range(q):
        alp, l, r = tuple(map(convert, new_input().split()))
        alp_idx = alp_to_idx[alp]
        print(check_table[r+1][alp_idx] - check_table[l][alp_idx])

main()




# 95436 KB / 572 ms
def main():
    from sys import stdin

    def convert(input_str):
        return int(input_str) if input_str.isdigit() else alp_to_idx[input_str]

    new_input = stdin.readline
    S = new_input().rstrip()
    start_ord = ord('a')
    alp_to_idx = {chr(start_ord+i): i for i in range(26)}

    N = len(S)
    check_table = [[] for _ in range(N+1)]
    temp = [0] * 26
    check_table[0].extend(temp)

    for i in range(N):
        alp_idx = alp_to_idx[S[i]]
        temp[alp_idx] += 1
        check_table[i+1].extend(temp)

    q = int(input())
    for _ in range(q):
        alp_idx, l, r = tuple(map(convert, new_input().split()))
        print(check_table[r+1][alp_idx] - check_table[l][alp_idx])

main()