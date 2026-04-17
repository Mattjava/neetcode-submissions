class Solution {
    public int integerBreak(int n) {
        if(n < 4)
            return n - 1;

        int[] breaks = new int[n-1];
        breaks[0] = 2;
        breaks[1] = 3;

        for(int i = 2; i < n-1; i++)
        {

            int value = i + 2;
            for(int j = 2; j <= value / 2; j++) {
                int firstValue = (int) Math.floor(value / j);
                int secondValue = value - firstValue;

                breaks[i] = Math.max(breaks[i], breaks[firstValue - 2] * breaks[secondValue - 2]);
            }
        }

        return breaks[n-2];
    }
}