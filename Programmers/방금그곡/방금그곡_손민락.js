function solution(m, musicinfos) {
    var answer = '';
    
    m = getPitch(m);
    musicinfos = musicinfos.map((musicinfo) => musicinfo.split(','));
    for (let i = 0; i < musicinfos.length; ++i) {
        musicinfos[i][3] = getPitch(musicinfos[i][3]);
        musicinfos[i][3] = getFullSong(musicinfos[i]);
    }
    musicinfos.sort((a, b) => b[3].length - a[3].length || a - b);
    
    const partialMatches = getPartialMatches(m);
    let maxCount = 0;
    for (let i = musicinfos.length - 1; i >= 0; --i) {
        const count = getMatchesCount(partialMatches, m, musicinfos[i][3]);
        if (maxCount <= count) {
            answer = musicinfos[i][2];
            maxCount = count;
        }
    }
    
    return maxCount ? answer : '(None)';
}

function getPitch(str) {
    const pitchMapper = {'C': 'a', 'C#': 'b', 'D': 'c', 'D#': 'd', 'E' : 'e', 'F': 'f', 'F#': 'g', 'G': 'h', 'G#' : 'i', 'A': 'j', 'A#': 'k', 'B': 'l', 'E#': 'm', 'B#': 'n'};
    
    let newStr = '';
    for (let i = 0; i < str.length; ++i) {
        if (str[i+1] === '#') {
            newStr += pitchMapper[str[i++] + '#'];
        } else {
            newStr += pitchMapper[str[i]];
        }
    }
    return newStr;
}

function getFullSong(musicinfo) {
    const [startHour, startMinute] = musicinfo[0].split(':').map(Number);
    const [endHour, endMinute] = musicinfo[1].split(':').map(Number);
    
    const playTime = (endHour - startHour) * 60 + endMinute - startMinute;
    const playCount = Math.floor(playTime / musicinfo[3].length);
    let fullSong = "";
    fullSong += musicinfo[3].repeat(playCount);
    fullSong += musicinfo[3].slice(0, playTime % musicinfo[3].length);
    
    return fullSong;
}

function getPartialMatches(str) {
    const partialMatches = Array(str.length).fill(0);
    
    let start = 1;
    let len = 0;
    while (start + len < str.length) {
        if (str[start + len] === str[len]) {
            partialMatches[start + len] = ++len;
        } else {
            if (len === 0) {
                ++start;
            } else {
                start += len - partialMatches[len - 1];
                len = partialMatches[len - 1];
            }
        }
    }
    
    return partialMatches;
}

function getMatchesCount(partialMatches, m, str) {
    let start = 0;
    let len = 0;
    let count = 0;
    while (start + len < str.length) {
        if (m[len] === str[start + len]){
            ++len;
            if (len === m.length) {
                ++count;
                start += len;
                len = 0;
            }
        } else {
            if (len === 0) {
                ++start;
            } else {
                start += len - partialMatches[len - 1];
                len = partialMatches[len - 1];
            }
        }
    }
    
    return count;
}