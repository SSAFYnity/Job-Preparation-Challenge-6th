class MinHeap {
    constructor() {
        this.heap = [];
    }
    
    peek() {
        return this.heap[0];
    }
    
    heapifyUp() {
        let curIndex = this.heap.length - 1;
        while (curIndex > 0) {
            const parentIndex = (curIndex - 1) >> 1;
            if (this.heap[parentIndex] > this.heap[curIndex]) {
                [this.heap[parentIndex], this.heap[curIndex]] = [this.heap[curIndex], this.heap[parentIndex]];
                curIndex = parentIndex;
            } else {
                break;
            }
        }
    }
    
    enqueue(item) {
        this.heap.push(item);
        this.heapifyUp();
    }
    
    heapifyDown() {
        let curIndex = 0;
        while (curIndex < this.heap.length) {
            let temp = curIndex;
            const left = curIndex * 2 + 1;
            const right = left + 1;
            if (this.heap[left] && this.heap[left] < this.heap[temp]) {
                temp = left;
            }
            if (this.heap[right] && this.heap[right] < this.heap[temp]) {
                temp = right;
            }
            if (curIndex === temp) {
                break;
            }
            [this.heap[curIndex], this.heap[temp]] = [this.heap[temp], this.heap[curIndex]];
            curIndex = temp;
        }
    }
    
    dequeue() {
        const min = this.heap[0];
        if (this.heap.length > 1) {
            this.heap[0] = this.heap.pop();
            this.heapifyDown();
        } else {
            this.heap.pop();
        }
        
        return min;
    }
    
    isEmpty() {
        return this.heap.length === 0;
    }
}

function getSecond(time) {
    time = time.split(':').map(Number);
    return time[0] * 3600 + time[1] * 60 + time[2];
}

function getTime(second) {
    const hour = Math.floor(second / 3600);
    second -= hour * 3600;
    const minute = Math.floor(second / 60);
    second -= minute * 60;
    
    return `${hour.toString().padStart(2, 0)}:${minute.toString().padStart(2, 0)}:${second.toString().padStart(2, 0)}`
}

function solution(play_time, adv_time, logs) {
    logs = logs.map((log) => log.split('-').map((time) => getSecond(time)));
    logs.sort((a, b) => a[0] - b[0]);
    
    adv_time = getSecond(adv_time);
    play_time = getSecond(play_time);
    const viewers = Array(play_time + 1).fill(0);
    const pq = new MinHeap();
    let i = logs[0][0];
    let index = 0;
    
    // 시간마다 시청자 수 구하기
    while (i <= play_time) {
        if (i === 0) {
            viewers[i] = 0;
        } else {
            viewers[i] = viewers[i - 1];
        }
        
        while (index < logs.length && logs[index][0] === i) {
            ++viewers[i];
            pq.enqueue(logs[index][1]);
            ++index;
        }
        
        while (true) {
            if (pq.isEmpty()) {
                break;
            }
            
            const end = pq.peek();
            if (end === i) {
                --viewers[i];
                pq.dequeue();
            } else {
                break;
            }
        }
        ++i;
    }
    
    let left = play_time;
    let right = left;
    let time = 0;
    
    for (let i = 0; i < adv_time; ++i) {
        time += viewers[left--];
    }
    
    let answer = left + 1;
    let maxTime = time;
    while (left > -1) {
        time += viewers[left--];
        time -= viewers[right--];
        
        if (maxTime <= time) {
            maxTime = time;
            answer = left + 1;
        }
    }
    
    return getTime(answer);
}