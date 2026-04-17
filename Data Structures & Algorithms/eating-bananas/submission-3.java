class Solution {
    public long eatPiles(int[] piles, int k)
    {
        int hour = 0;

        for(int pile : piles)
            hour += Math.ceil((double) pile / k);
        
        return hour;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;

        for(int pile : piles)
            max = Math.max(max, pile);
        
        int left = 1;
        int right = max;
        int mid = (right - left) / 2;

        int result = 0;

        while(left <= right)
        {
            long value = eatPiles(piles, mid);

            if(value <= h) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = (right - left) / 2 + left;
        }

        return result;

    }
}
