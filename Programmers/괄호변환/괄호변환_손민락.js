function split(str) {
    let countOpen = 0;
    let countClose = 0;
    let index = 0;
    let isBalanced = true;
    const stack = [];
    
    while (countOpen !== countClose || countOpen === 0) {
        if (str[index++] === '(') {
            ++countOpen;
            stack.push('(');
        } else {
            ++countClose;
            if (stack.length === 0 || stack.pop() !== '(') {
                isBalanced = false;
            }
        }
    }
    
    if (stack.length > 0) {
        isBalanced = false;
    }
    
    const u = str.substr(0, index);
    const v = str.slice(index);
    
    return [u, v, isBalanced];
}

function makeCorrect(str) {
    let result = '';
    let u, isBalanced;
    
    while (str.length > 0) {
        [u, str, isBalanced] = split(str);
        if (isBalanced) {
            result += u;
        } else {
            result += '(';
            if (str.length > 0) {
                result += makeCorrect(str);
            }
            result += ')';
            str = '';
            if (u.length > 2) {
                result += reverse(u.substr(1, u.length - 2));
            }
        }
    }
    
    return result;
}

function reverse(str) {
    let result = "";
    
    for (let i = 0; i < str.length; ++i) {
        if (str[i] === '(') {
            result += ')';
        } else {
            result += '(';
        }
    }
    
    return result;
}

function solution(p) {
    var answer = '';
    answer = makeCorrect(p);
    
    return answer;
}