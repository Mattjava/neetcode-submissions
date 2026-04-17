class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0)
            return amount;

        int[] minCoins = new int[amount];

        for(int i = 0; i < amount; i++)
        {
            int value = i + 1;

            int min = Integer.MAX_VALUE;

            for(int j = 0; j < coins.length; j++)
            {
                if(value == coins[j]) {
                    min = 0;
                    break;
                }

                if(value - coins[j] >= 1) {
                    int previousAmount = minCoins[value - coins[j] - 1];
                    if(previousAmount != -1) 
                        min = Math.min(min, previousAmount);
                } else if(value - coins[j] < 0)
                    break;
            }

            if(min == Integer.MAX_VALUE) {
                minCoins[i] = -1;
                continue;
            }

            minCoins[i] = min + 1;
        }

        return minCoins[amount - 1];
    }
}
