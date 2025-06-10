function toMinute(str) {
    const hour = Number(str.slice(0, 2));
    const minute = Number(str.slice(3));

    return hour * 60 + minute;
}

function minuteToTime(minute) {
    const hour = Math.floor(minute / 60);
    minute -= hour * 60;
    
    return `${String(hour).padStart(2, '0')}:${String(minute).padStart(2, '0')}`;
}

function solution(n, t, m, timetable) {
    var answer = '';
    timetable = timetable.map((time) => toMinute(time)).sort((a, b) => a - b);
    
    let idx = 0;
    for (let i = 0; i < n; ++i) {
        let count = 0;
        const time = 540 + i * t;
        while (idx < timetable.length && count < m) {
            if (timetable[idx] > time) {
                break;
            }
            ++idx;
            ++count;
        }
        if (count === m) {
            answer = timetable[idx - 1] - 1;    
        } else {
            answer = time;
        }
    }
    
    return minuteToTime(answer);
}