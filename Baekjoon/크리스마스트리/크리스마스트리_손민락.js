function factorial(n) {
  if (n === 1) return 1;
  return n * factorial(n-1);
}

function combination(n, r) {
  return factorial(n) / (factorial(n-r) * factorial(r))
}

let [N, R, G, B] = require('fs').readFileSync('/dev/stdin').toString().split(' ').map(Number);
R = Math.min(R, 55);
G = Math.min(G, 55);
B = Math.min(B, 55);
const dp = Array(N+1).fill().map(() => Array(R+1).fill().map(() => Array(G+1).fill().map(() => Array(B+1).fill(0))));

for (let k = 0; k <= N; ++k) {
  for (let r = 0; r <= R; ++r) {
    for (let g = 0; g <= G; ++g) {
      for (let b = 0; b <= B; ++b) {
        if (k === 0) {
          dp[k][r][g][b] = 1;
          continue;
        }
        if (r >= k) {
          dp[k][r][g][b] += dp[k-1][r-k][g][b];
        }
        if (g >= k) {
          dp[k][r][g][b] += dp[k-1][r][g-k][b];
        }
        if (b >= k) {
          dp[k][r][g][b] += dp[k-1][r][g][b-k];
        }
        if (k % 2 === 0) {
          const count = Math.floor(k / 2);
          if (g >= count && b >= count) {
            dp[k][r][g][b] += dp[k-1][r][g-count][b-count] * combination(k, count);
          }
          if (r >= count && b >= count) {
            dp[k][r][g][b] += dp[k-1][r-count][g][b-count] * combination(k, count);
          }
          if (r >= count && g >= count) {
            dp[k][r][g][b] += dp[k-1][r-count][g-count][b] * combination(k, count);
          }
        }
        if (k % 3 === 0) {
          const count = Math.floor(k / 3);
          if (r >= count && g >= count && b >= count) {
            dp[k][r][g][b] += dp[k-1][r-count][g-count][b-count] * combination(k, count) * combination(k-count, count);
          }
        }
      }
    }
  }
}

console.log(dp[N][R][G][B]);