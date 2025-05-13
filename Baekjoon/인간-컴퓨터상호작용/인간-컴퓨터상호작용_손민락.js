const input = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split('\n');

const S = input[0];
const q = +input[1];

const prefixSum = Array(26).fill().map(() => Array(S.length + 1).fill(0));

for (let i = 0; i < S.length; ++i) {
  const idx = S.charCodeAt(i) - 97;
  for (let j = 0; j < 26; ++j) {
    prefixSum[j][i + 1] = prefixSum[j][i] + (idx === j ? 1 : 0);
  }
}

const answer = [];

for (let question = 2; question < 2 + q; ++question) {
  let [a, l, r] = input[question].split(' ');
  [l, r] = [+l, +r];
  const idx = a.charCodeAt(0) - 97;

  answer.push(prefixSum[idx][r+1] - prefixSum[idx][l]);
}

console.log(answer.join('\n'));