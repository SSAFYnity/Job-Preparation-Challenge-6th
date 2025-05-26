N = int(input())
flowers = [list(map(int, input().split())) for _ in range(N)]
flowers.sort()

idx = 0;
count = 0;
end_date = (3, 1) # 3월 1일부터 확인

while idx < N:
    sm, sd, em, ed = flowers[idx]
    if (sm, sd) <= end_date < (em, ed):
        max_end = (em, ed)

        while idx < N-1:
            nsm, nsd, nem, ned = flowers[idx+1]

            if end_date < (nsm, nsd):
                break
            if max_end < (nem, ned):
                max_end = (nem, ned)
            idx += 1
        count += 1
        end_date = max_end

        if (11, 30) < end_date:
            print(count)
            exit()
    idx += 1
print(0)
