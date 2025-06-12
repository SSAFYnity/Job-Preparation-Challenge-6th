function solution(k, d) {
    var answer = 0;
    for (let i = 0; i <= d; i+=k) {
        answer += Math.floor(Math.sqrt(d**2 - i**2) / k) + 1
    }
    
    return answer;
}