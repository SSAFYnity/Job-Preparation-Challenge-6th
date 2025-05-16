const input = require('fs')
  .readFileSync('example.txt')
  .toString()
  .trim()
  .split('\n')
  .map(Number);
input.shift();

const maxInput = Math.max(...input);
const isPrime = Array(maxInput + 1).fill(true);
for (let i = 2; i <= maxInput; ++i) {
  if (isPrime[i]) {
    for (let j = i * i; j <= maxInput; j += i) {
      isPrime[j] = false;
    }
  }
}

const answer = [];
input.forEach((n) => {
  for (let i = n >> 1; i >= 2; --i) {
    if (isPrime[i] && isPrime[n - i]) {
      answer.push(`${i} ${n - i}`);
      break;
    }
  }
})

console.log(answer.join('\n'));