# 250513
def solution(tickets):
    N = len(tickets)
    result, path = [], ['ICN']
    visited = [False] * N
    info = {}

    for i in range(N):
        a, b = tickets[i]
        info[a] = info.get(a, []) + [(b, i)]

    def dfs(level, now):
        for new_level in range(level+1, N+1):
            if not info.get(now):
                return
            if len(info[now]) == 1:
                new, i = info[now][0]
                path.append(new)
                now = new
            else:
                break
        else:
            result.append(path[:])
            return

        for new, i in info[now]:
            if not visited[i]:
                path.append(new)
                visited[i] = True
                dfs(new_level, new)
                path.pop()
                visited[i] = False

        for _ in range(new_level - level - 1):
            path.pop()

    dfs(0, 'ICN')
    result.sort()
    return result[0]

'''
테스트 1 〉	통과 (187.25ms, 13.8MB)
테스트 2 〉	통과 (0.01ms, 9.21MB)
테스트 3 〉	통과 (0.01ms, 9.13MB)
테스트 4 〉	통과 (0.01ms, 9.22MB)
'''