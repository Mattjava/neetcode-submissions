class Solution {
    public int calculateTime(int[] piles, int k)
    {
        int time = 0;
        for(int pile : piles) {
            time += Math.ceil((double) pile / k);
        }

        System.out.println("Time spent: " + time + " Rate: " + k);

        return time;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int upper = 0;
        int lower = 1;

        for(int pile : piles)
            upper = Math.max(upper, pile);

        int result = upper;

        
        while(lower <= upper)
        {
            int middle = lower + (upper - lower) / 2;

            int time = calculateTime(piles, middle);

            if(time <= h) {
                result = middle;
                upper = middle - 1;
            } else
                lower = middle + 1;

        }

        
        return result;
    }
}

