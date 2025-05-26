const input = require('fs')
  .readFileSync('example.txt')
  .toString()
  .trim()
  .split('\n');

const N = +input[0];
const edges = [];
for (let i = 1; i <= N; ++i) {
  edges.push([0, i, +input[i]]);
}
for (let i = 1; i <= N; ++i) {
  const line = input[i + N].split(' ').map(Number);
  for (let j = i; j < N; ++j) {
    edges.push([i, j + 1, line[j]]);
  }
}

edges.sort((a, b) => a[2] - b[2]);
const parents = Array(N+1).fill().map((_, index) => index);
const ranks = Array(N+1).fill(0);
let count = 0;
let answer = 0;

for (let i = 0; i < edges.length; ++i) {
  if (union(edges[i][0], edges[i][1])) {
    answer += edges[i][2];
    ++count;

    if (count === N) {
      break;
    }
  }
}

console.log(answer);

function find(x) {
  if (parents[x] === x) return x;
  return parents[x] = find(parents[x]);
}

function union(a, b) {
  a = find(a);
  b = find(b);

  if (a === b) return false;

  if (ranks[a] < ranks[b]) {
    parents[a] = b;
  } else if (ranks[b] < ranks[a]) {
    parents[b] = a;
  } else {
    parents[b] = a;
    ++ranks[a]
  }

  return true;
}