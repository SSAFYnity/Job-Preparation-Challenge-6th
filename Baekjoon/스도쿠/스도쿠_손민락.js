const sudoku = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .split('\n')
  .map((str) => str.split("").map(Number));

// 빈 칸 찾기
const empty = [];
for (let r = 0; r < 9; ++r) {
  for (let c = 0; c < 9; ++c) {
    if (sudoku[r][c] === 0) {
      empty.push([r, c]);
    }
  }
}

dfs(0);
console.log(sudoku.map((row) => row.join('')).join('\n'));

function dfs(depth) {
  if (depth === empty.length) {
    return true;
  }

  const r = empty[depth][0];
  const c = empty[depth][1];

  for (let i = 1; i <= 9; ++i) {
    if (!check(r, c, i)) {
      continue;
    }

    sudoku[r][c] = i;

    if (dfs(depth + 1)) {
      return true;
    }

    // 실패한 경우 백트래킹
    sudoku[r][c] = 0;
  }
}

function check(r, c, num) {
  // 행 검사
  for (let i = 0; i < 9; ++i) {
    if (sudoku[r][i] === num) {
      return false;
    }
  }

  // 열 검사
  for (let i = 0; i < 9; ++i) {
    if (sudoku[i][c] === num) {
      return false;
    }
  }

  // 3x3 검사
  const sr = Math.floor(r / 3) * 3;
  const sc = Math.floor(c / 3) * 3;

  for (let i = 0; i < 3; i++) {
    for (let j = 0; j < 3; j++) {
      if (sudoku[sr + i][sc + j] === num) {
        return false;
      }
    }
  }

  return true;
}