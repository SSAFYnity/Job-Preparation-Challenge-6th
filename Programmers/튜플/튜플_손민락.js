function solution(s) {
    var answer = [];
    
    const count = [];
    let tupleLen = 0;
    let str = "";
    
    for (let i = 0; i < s.length; ++i) {
        if (s[i] >= '0' && s[i] <= '9') {
            str += s[i];
        } else {
            if (str) {
                const num = +str;
                if (!count[num]) {
                    ++tupleLen;
                    count[num] = 0;
                }
                ++count[num]
                str = "";
            }
        }
    }
    
    for (let i = 0; i < count.length; ++i) {
        if (count[i]) {
            answer[tupleLen - count[i]] = i;
        }
    }
    return answer;
}