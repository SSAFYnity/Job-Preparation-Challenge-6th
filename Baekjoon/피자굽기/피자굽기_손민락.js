const input = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split('\n');

const [D, N] = input[0].split(' ').map(Number);
let min = Number.MAX_SAFE_INTEGER;
let minIndex = 0;
const oven = input[1].split(' ').map((rad, index) => {
  rad = Number(rad);
  if (rad < min) {
    min = rad;
    minIndex = index;
  }
  return [min, minIndex];
})

const pizza = input[2].split(' ').map(Number);

let curIndex = D - 1;
let pizzaIndex = 0;
let answer = 0;

while (curIndex >= 0 && pizzaIndex < N) {
  if (pizza[pizzaIndex] <= oven[curIndex][0]) {
    answer = curIndex + 1;
    --curIndex;
    ++pizzaIndex;
  } else {
    curIndex = oven[curIndex][1] - 1;
  }
}

console.log(pizzaIndex < N ? 0 : answer);