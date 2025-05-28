const input = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split('\n');

const N = Number(input.shift());

if (N === 1) {
  console.log(1);
} else {
  const nums = [null, ...input.map(Number).sort((a, b) => a - b)];
  let answer = 0;

  const dp = Array(N).fill().map(() => Array(N+1).fill(0));
  for (let i = 1; i < N; ++i) {
    for (let j = i + 1; j <= N; ++j) {
      dp[i][j] = 2;
      const prev = nums[i] - (nums[j] - nums[i]);

      let left = 1;
      let right = i - 1;
      while (left < right) {
        const mid = (left + right) >> 1;

        if (nums[mid] < prev) {
          left = mid + 1;
        } else if (nums[mid] === prev && nums[right] === prev) {
          left = mid + 1;
        } else {
          right = mid;
        }
      }

      if (nums[right] === prev) {
        dp[i][j] = Math.max(dp[right][i] + 1, dp[i][j]);
      }
      answer = Math.max(answer, dp[i][j]);
    }
  }

  console.log(answer);
}
