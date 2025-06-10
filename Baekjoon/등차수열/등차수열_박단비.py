import sys
input = sys.stdin.readline

N = int(input())
nums = [0]
for i in range(N):
    n = int(input())
    nums.append(n)

answer = 0

if N == 1:
    answer = 1
else:
    nums.sort()
    # dp[i][j] : i번째와 j번째가 마지막 두 항인 등차수열의 최대 길이
    # 이 경우 공차는 nums[j] - nums[i]

    # 이중 for문 돌면서 i는 1부터 n-1까지, j는 i+1부터 n까지
    dp = [[0] * (N+1) for _ in range(N+1)]

    for i in range(1, N):
        for j in range(i+1, N+1):
            dp[i][j] = 2 # 기본적으로 i번째, j번째 수 이렇게 2개가 있으니깐 2

            pre = 2 * nums[i] - nums[j]
            # 2 * (nums[i] - nums[j]) + nums[j] -> 2 * nums[i] - nums[j]

            # 해당 공차에 해당하는 앞의 항이 몇번째 인덱스에 있는지 찾기
            for k in range(i-1, 0, -1):
                if nums[k] == pre:
                    dp[i][j] = max(dp[k][i] + 1, dp[i][j])
                    break

            answer = max(answer, dp[i][j])

print(answer)