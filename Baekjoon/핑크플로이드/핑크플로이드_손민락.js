const input = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split('\n');
  
const N = Number(input[0]);
const edges = [];
const parents = Array(N+1).fill();
const ranks = Array(N+1).fill(0);
const tree = Array(N+1).fill().map(() => []);

for (let i = 1; i < N; ++i) {
  const distance = input[i].split(' ').map(Number);
  for (let j = 0; j < distance.length; ++j) {
    const end = i + j + 1;
    edges.push([i, end, distance[j]]);
  }
}

// 거리 기준 내림차순 정렬
edges.sort((a, b) => b[2] - a[2]);

// 부모 배열 초기화
for (let i = 1; i <= N; ++i) {
  parents[i] = i;
}

while (edges.length) {
  const [now, end, _] = edges.pop();

  if (union(now, end)) {
    continue;
  }

  tree[now].push(end);
  tree[end].push(now);
}

let answer = "";
tree.shift();
tree.forEach((node) => {
  answer += `${node.length} ${node.sort((a, b) => a - b).join(' ')}\n`;
})
console.log(answer);

function find(a) {
  if (parents[a] === a) {
    return a;
  }

  return parents[a] = find(parents[a]);
}

function union(a, b) {
  a = find(a);
  b = find(b);

  if (a === b) {
    return true;
  }

  if (ranks[a] > ranks[b]) {
    parents[a] = b;
  } else {
    parents[b] = a;

    if (ranks[a] === ranks[b]) {
      ++ranks[b];
    }
  }
  return false;
}