class Solution {
    public int findTime(int[] piles, double rate) {
        int count = 0;

        for(int pile : piles)
            count += Math.ceil(pile / rate);

        return count;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for(int pile : piles)
            right = Math.max(right, pile);

        while(left <= right) {
            int mid = left + (right - left) / 2;

            int count = findTime(piles, mid);

            if(count > h)
                left = mid + 1;
            else
                right = mid - 1;
            
        }


        return left;
    }
}
