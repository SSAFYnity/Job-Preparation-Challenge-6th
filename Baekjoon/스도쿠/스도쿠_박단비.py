board = []
empty = []

for i in range(9):
    arr = list(map(int, input()))
    for j in range(9):
        if arr[j] == 0:
            empty.append((i, j))
    board.append(arr)

def func(idx):
    if idx == len(empty):
        for i in range(9):
            for j in range(9):
                print(board[i][j], end='')
            print()
        exit()
    r, c = empty[idx][0], empty[idx][1]
    for n in range(1, 10):
        possible = True
        # 가로, 세로 확인하기
        for i in range(9):
            if board[r][i] == n:
                possible = False
                break

            if board[i][c] == n:
                possible = False
                break
        if possible:
            # 9칸 확인하기
            for i in range(3):
                for j in range(3):
                    if board[3 * (r//3) + i][3 * (c//3) + j] == n:
                        possible = False
                        break
        if possible:
            board[r][c] = n
            func(idx+1)
            board[r][c] = 0


func(0)