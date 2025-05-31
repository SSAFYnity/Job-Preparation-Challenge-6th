const input = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split('\n');


while (input.length > 1) {
  let answer = 0;
  let [N, A, B] = input.shift().split(' ').map(Number);

  // Da와 Db의 차가 큰 순서대로 정렬
  // Da와 Db의 차가 같다면 Da, Db 중에 작은 순서대로 정렬
  const teams = input.splice(0, N).map((team) => {
    const [K, Da, Db] = team.split(' ').map(Number);

    return [K, Da, Db, Math.abs(Da - Db)];
  }).sort((a, b) => b[3] - a[3] || Math.min(a[1], a[2]) - Math.min(b[1], b[2]));

  for (let i = 0; i < teams.length; ++i) {
    // i번 팀에 풍선을 모두 나눠줄 때까지 반복
    while (teams[i][0]) {
      if (A) {
        // 풍선 A만 존재한다면 A를 나눠줌
        if (!B || teams[i][1] < teams[i][2]) {
          if (A > teams[i][0]) {
            A -= teams[i][0];
            answer += teams[i][1] * teams[i][0];
            teams[i][0] = 0;
          } else {
            teams[i][0] -= A;
            answer += teams[i][1] * A;
            A = 0;
          }
        } else {
          if (B > teams[i][0]) {
            B -= teams[i][0];
            answer += teams[i][2] * teams[i][0];
            teams[i][0] = 0;
          } else {
            teams[i][0] -= B;
            answer += teams[i][2] * B;
            B = 0;
          }
        }
      } else {
        // 풍선 B만 존재하기 때문에 B를 나눠줌
        // 풍선의 개수는 충분하기 때문에 조건 없이 B를 나눠줌
        B -= teams[i][0];
        answer += teams[i][2] * teams[i][0];
        teams[i][0] = 0;
      }
    }
  }
  console.log(answer);
}