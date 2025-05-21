function solution(msg) {
    var answer = [];
    
    const dict = new Map();
    let index = 1;
    while (index < 27) {
        dict.set(String.fromCharCode(64 + index), index++);
    }
    
    let i = 0;
    while (i < msg.length) {
        let prev = "";
        let word = msg[i];
        while (dict.has(word)) {
            if (dict.has(word)) {
                prev = word;
            }
            word += msg[++i];
        }
        answer.push(dict.get(prev));
        dict.set(word, index++);
    }
    
    console.log(answer);
    
    return answer;
}