class Solution {
    public int solution(int storey) {
        int stones = 0;
        int d = 10;
        while (true) {
            if (storey == 0) {
                break;
            }
            int r1 = storey % d;
            int r2 = d - r1;

            if (r2 > r1) {
                storey -= r1;
                stones += (r1 * 10 / d);
            } else if (r2 < r1) {
                storey += r2;
                stones += (r2 * 10 / d);
            } else {
                int left = (storey / d) % 10;
                if (left >= 5) {
                    storey += r2;
                    stones += (r2 * 10 / d);
                } else {
                    storey -= r1;
                    stones += (r1 * 10 / d);
                }
            }
            d *= 10;
        }

        return stones;
    }
}
