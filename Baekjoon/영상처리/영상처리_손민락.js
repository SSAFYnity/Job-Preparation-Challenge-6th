const input = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split('\n');

const [N, M] = input.shift().split(' ').map(Number);
const screen = Array.from({ length: N }, () => Array(M));
const visited = Array.from({ length: N }, () => Array(M).fill(false));
const T = Number(input.splice(-1));

for (let i = 0; i < N; ++i) {
  const line = input[i].split(' ').map(Number);
  for (let j = 0; j < M; ++j) {
    const idx = j * 3;
    const avg = (line[idx] + line[idx+1] + line[idx+2]) / 3;
    if (avg >= T) {
      screen[i][j] = 255;
    } else {
      screen[i][j] = 0;
    }
  }
}

const delta = [[-1, 0], [0, 1], [1, 0], [0, -1]];
let answer = 0;
for (let i = 0; i < N; ++i) {
  for (let j = 0; j < M; ++j) {
    if (visited[i][j]) {
      continue;
    }
    visited[i][j] = true;
    if (screen[i][j] === 255) {
      ++answer;
      const queue = [[i, j]];
      let head = 0;
      while (head < queue.length) {
        const [r, c] = queue[head++];
        for (let d = 0; d < 4; ++d) {
          const nextR = r + delta[d][0];
          const nextC = c + delta[d][1];
          if (nextR >= 0 && nextC >= 0 && nextR < N && nextC < M) {
            if (!visited[nextR][nextC]) {
              visited[nextR][nextC] = true;
              if (screen[nextR][nextC] === 255) {
                queue.push([nextR, nextC]);
              }
            }
          }
        }
      }
    }
  }
}

console.log(answer);