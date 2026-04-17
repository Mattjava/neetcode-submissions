class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];

        for(int i = 0; i < n+1; i++)
        {
            int num = i;

            while(num > 0)
            {
                int bit = num & 1;
                if(bit == 1) result[i]++;
                num >>= 1;
            }
        }

        return result;
    }
}
