function solution(storey) {
  var answer = 0;
  
  while (storey > 0) {
    const num = storey % 10;
    // num이 5면 윗자리가 5 이상인지 봐야함
    if (num === 5) {
      if (Math.floor(storey / 10) % 10 >= 5) {
          storey += 10;
      }
        answer += 5;
    } else if (num > 5) {
        answer += 10 - num;
        storey += 10;
    } else {
        answer += num;
    }
    storey = Math.floor(storey / 10);
  }
  
  return answer;
}