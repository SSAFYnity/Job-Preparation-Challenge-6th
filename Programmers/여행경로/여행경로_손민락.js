function solution(tickets) {

  // 도착지 알파뱃 순 정렬
  array.sort((a, b) => {
    if (a[1] < b[1]) return -1;
    if (a[1] > b[1]) return 1;
    return 0;
  });

  const routes = new Map();
  tickets.forEach((t) => {
      if (routes.has(t[0])) {
          routes.get(t[0]).push({e: t[1], visited: false});
      } else {
          routes.set(t[0], [{e: t[1], visited: false}]);
      }
  });
  
  // 항상 ICN에서 출발
  const result = { done: false, path: ["ICN"]};
  dfs(0, tickets.length, routes, "ICN", result);
  
  return result.path;
}

function dfs(depth, FIN, routes, start, result) {
  if (depth === FIN) {
      result.done = true;
  } else {
      if (routes.has(start)) {
          const now = routes.get(start);
          for (let i = 0; i < now.length; ++i) {
              if (now[i].visited) {
                  continue;
              }

              now[i].visited = true;
              result.path.push(now[i].e);
              dfs(depth + 1, FIN, routes, now[i].e, result);
              
              if (result.done) {
                  return;
              }
              
              now[i].visited = false;
              result.path.pop();
          }
      }
  }
}