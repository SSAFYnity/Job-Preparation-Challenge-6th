const input = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split('\n');

const N = +input[0];

const flowers = [];
for (let i = 1; i <= N; ++i) {
  flowers.push(input[i].split(' ').map(Number));
}
flowers.sort((a, b) => a[0] - b[0] || a[1] - b[1]);

let now = [3, 1];
let temp = [3, 1];
let can = false;
let count = 0;

for (let i = 0; i < N; ++i) {
  if (isLater(now, flowers[i])) {
    choose(flowers[i], temp);
  } else {
    ++count;
    now[0] = temp[0];
    now[1] = temp[1];
    if (isLater(now, flowers[i])) {
      choose(flowers[i], temp);
    }
  }

  if (temp[0] > 11) {
    can = true;
    ++count;
    break;
  }
}

console.log(can ? count : 0);

function isLater(a, b) {
  return (a[0] > b[0]) || (a[0] === b[0] && a[1] >= b[1]);
}

function choose(a, b) {
  if ((a[2] > b[0]) || (a[2] === b[0] && a[3] > b[1])) {
    b[0] = a[2];
    b[1] = a[3];
  }
}