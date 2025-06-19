let input = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split('\n');

const [N, K] = input.shift().split(' ').map(Number);
input = input.map(Number);
const sub = Array(N+1);
for (let i = 1; i < N; ++i) {
  sub[i] = input[i] - input[i-1] - 1;
}

sub.sort((a, b) => b - a);
let answer = input[input.length - 1] - input[0] + 1;
for (let i = 0; i < K - 1; ++i) {
  answer -= sub[i];
}

console.log(answer);