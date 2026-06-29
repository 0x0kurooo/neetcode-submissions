class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = piles[0];
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }
        
        int l = 1, r = maxPile;
        int minEatingSpeed = maxPile;
        while (l <= r) {
            int mid = (l + r) / 2;
            int reqHourToEat = 0;

            for (int i = 0; i < piles.length; i ++) {
                reqHourToEat += (int) Math.ceil((double) piles[i] / mid);
            }

            if (reqHourToEat > h) {
                l = mid + 1;
            } else {
                minEatingSpeed = Math.min(minEatingSpeed, mid);
                r = mid - 1;
            }
        }

        return minEatingSpeed;
    }
}
