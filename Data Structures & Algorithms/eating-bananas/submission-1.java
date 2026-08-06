class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int res = 0;

        while (low <= high) {
            int k = low + (high - low) / 2;
            long time = 0;
            for (int p : piles) {
                time += Math.ceil((double) p / k);
            }

            if (time <= h) {
                res = k;
                high = k - 1;
            } else {
                low = k + 1;
            }
        }
        return res;
    }
}
