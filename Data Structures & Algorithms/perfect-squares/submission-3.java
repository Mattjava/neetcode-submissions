class Solution {
    public int numSquares(int n) {
        List<Integer> squares = new LinkedList<>();

        int[] sum = new int[n];
        sum[0] = 1;

        squares.add(1);

        int nextPower = 2;


        for(int i = 1; i < n; i++)
        {
            int val = i + 1;
            
            if(val == nextPower * nextPower) {
                sum[i] = 1;
                squares.add(nextPower * nextPower);
                nextPower++;
                continue;
            } 

            for(int j = squares.size() - 1; j > -1; j--)
            {
                int otherNum = (i+1) - squares.get(j);
                int additionalSquare = sum[otherNum-1];
                if(sum[i] == 0)
                    sum[i] = additionalSquare + 1;
                else
                    sum[i] = Math.min(sum[i], additionalSquare + 1);
            }
        }

        return sum[n-1];
    }
}