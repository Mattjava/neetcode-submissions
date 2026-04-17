class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int size = gas.length;

        int gasSum = 0;
        int costSum = 0;

        for(int i = 0; i < size; i++)
        {
            gasSum += gas[i];
            costSum += cost[i];
        }

        if(costSum > gasSum)
            return -1;
        
        int track = 0;
        int result = 0;

        for(int i = 0; i < size; i++)
        {
            track += gas[i] - cost[i];

            if(track < 0) {
                track = 0;
                result = i + 1;
            }
        }

        return result;
    }
}

