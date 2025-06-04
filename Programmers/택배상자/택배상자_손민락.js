function solution(order) {
    var answer = 0;
    
    const subContainer = [];
    
    let idx = 0;
    for (let i = 1; i <= order.length; ++i) {
        if (order[idx] !== i) {
            subContainer.push(i);
            continue;
        }
        
        ++idx;
        ++answer;
        
        while (subContainer.length > 0 && subContainer[subContainer.length - 1] === order[idx]) {
            subContainer.pop();
            ++idx;
            ++answer;
        }
    }
    return answer;
}