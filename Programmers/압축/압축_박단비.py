def solution(msg):
    dic={}
    for i in range(1,27):
        dic[chr(i+64)]=i
    i=0
    answer=[]
    while 1:
        if i >=len(msg):
            break
        for j in range(len(msg),i,-1):
            if msg[i:j] in dic:
                answer.append(dic[msg[i:j]])
                dic[msg[i:j+1]] = len(dic)+1
                i=j-1
        i+=1
    return answer