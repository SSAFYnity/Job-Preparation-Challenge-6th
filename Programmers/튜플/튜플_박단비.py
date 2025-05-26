def solution(s):
    answer = []
    tmp = []
    for i in s.split("},"):
        tmp.append(i.replace("{", "").replace("}", "").split(","))
    tmp.sort(key = lambda x : len(x))
    for i in tmp:
        for j in i:
            if j not in answer:
                answer.append(j)
    return list(map(int, answer))