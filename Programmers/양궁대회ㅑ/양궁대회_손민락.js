function solution(n, info) {
    var answer = Array(11).fill(0);
    let apichiScore = 0;
    
    // 해당 과녁에서 점수를 얻기 위해 필요한 화살 수
    const needed = info.map((arrows) => arrows + 1);
    // 해당 과녁을 맞추면 얻게 되는 실제 이득 (어피치가 얻을 점수를 얻었다면 2배 이득)
    const gain = needed.map((need, index) => {
        if (need === 1) {
            return 10 - index;
        } else {
            apichiScore += 10 - index;
            return (10 - index) * 2;
        }
    })
    
    const dp = Array.from({ length: n + 1 }, () => [0, []]);
    for (let i = 0; i < 11; ++i) {
        for (let j = n; j >= needed[i]; --j) {
            if (dp[j-needed[i]][0] + gain[i] >= dp[j][0]) {
                dp[j][0] = dp[j-needed[i]][0] + gain[i];
                dp[j][1] = [...dp[j-needed[i]][1], i];
            }
        }
    }
    
    let count = 0;
    for (const choose of dp[n][1]) {
        answer[choose] += needed[choose];
        count += needed[choose];
    }
    answer[10] += n - count;
    
    return apichiScore < dp[n][0] ? answer : [-1];
}