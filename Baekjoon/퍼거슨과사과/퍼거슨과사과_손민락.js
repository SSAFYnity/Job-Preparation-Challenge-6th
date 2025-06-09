const [R, G] = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split(' ')
  .map(Number);

function getGCD(a, b) {
  const mod = a % b;
  return mod === 0 ? b : getGCD(b, mod);
}

const gcd = R > G ? getGCD(R, G) : getGCD(G, R);
const range = Math.floor(gcd ** 0.5);
const answer = [];

for (let i = 1; i <= range; ++i) {
  if (gcd % i === 0) {
    const j = Math.floor(gcd / i);
    answer.push(`${i} ${Math.floor(R / i)} ${Math.floor(G / i)}`);
    if (i !== j) {
      answer.push(`${j} ${Math.floor(R / j)} ${Math.floor(G / j)}`);
    }
  }
}

console.log(answer.join('\n'));