const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
const T = Number(input[0]);

function cubeRootFloor(nStr) {
  const scale = 10n ** 30n;
  const n = BigInt(nStr) * scale;

  let left = 0n;
  let right = n;
  while (left < right) {
    const mid = (left + right + 1n) / 2n;
    if (mid ** 3n <= n) {
      left = mid;
    } else {
      right = mid - 1n;
    }
  }

  const intPart = left / (10n ** 10n);
  const fracPart = left % (10n ** 10n);

  const fracStr = fracPart.toString().padStart(10, '0');
  return `${intPart}.${fracStr}`;
}

for (let i = 1; i <= T; i++) {
  const result = cubeRootFloor(input[i]);
  console.log(result);
}