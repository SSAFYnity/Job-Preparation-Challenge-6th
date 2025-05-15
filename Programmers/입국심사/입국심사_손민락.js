function solution(n, times) {
    let left = 0;
    let right = Math.max(...times) * n;
    
    if (right < Number.MAX_SAFE_INTEGER) {
        while (left < right) {
            const mid = Math.floor((left + right) / 2);
            
            let count = 0;
            for (let i = 0; i < times.length; ++i) {
                count += Math.floor(mid / times[i]);
            }
            
            if (count < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    } else {
        const bigN = BigInt(n);
        const bigTimes = times.map((t) => BigInt(t));
        left = 0n;
        right = BigInt(Math.max(...times)) * bigN;
        
        while (left < right) {
            const mid = (left + right) / 2n;
            
            let count = 0n;
            for (let i = 0; i < bigTimes.length; ++i) {
                count += mid / bigTimes[i];
            }
            
            if (count < bigN) {
                left = mid + 1n;
            } else {
                right = mid;
            }
        }
        return left;
    }
}