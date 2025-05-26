def solution(tickets):
    answer = []
    visited = [False] * len(tickets)

    def dfs(airport, path):
        # 모든 티켓을 한번씩 다 사용해서 갈 수 있는 모든 경로가 answer에 저장됨
        if (len(path) == len(tickets) + 1):
            answer.append(path)
            return
        for idx, ticket in enumerate(tickets):
            if ticket[0] == airport and visited[idx] == False:
                visited[idx] = True
                dfs(ticket[1], path + [ticket[1]])
                visited[idx] = False

    dfs("ICN", ["ICN"])
    # 저장 된 모든 경로 중에 알파벳 순서가 앞서는 순서들로 이뤄진 첫번째 경로 반환하기 위해서
    answer.sort()
    return answer[0]
