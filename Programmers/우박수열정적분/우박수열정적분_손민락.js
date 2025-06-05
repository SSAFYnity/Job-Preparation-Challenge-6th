function guessCollatz(depth, n, arr) {
    if (n === 1 || depth === 199) {
        return arr;
    }
    n = n % 2 === 0 ? Math.floor(n / 2) : n * 3 + 1;
    arr.push(n);
    return guessCollatz(depth + 1, n, arr)
}

function solution(k, ranges) {
    var answer = [];
    const arr = guessCollatz(0, k, [k]);
    const areas = [];
    
    let prevValue = 0;
    let prevArea = 0;
    for (const value of arr) {
        const [high, low] = [prevValue, value].sort((a, b) => b - a);
        const area = prevValue === 0 ? 0 : prevArea + low + (high - low) / 2;
        areas.push(area);
        prevValue = value;
        prevArea = area;
    }
    
    for (const range of ranges) {
        const end = arr.length - 1 + range[1];
        if (range[0] > end) {
            answer.push(-1);
            continue;
        }
        answer.push(areas[end] - areas[range[0]]);
    }
    
    return answer;
}