class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        for(int i = 0; i < 31; i++)
        {
            int bit = (n >> i) & 1;

            if(bit == 1) count++;
        }

        return count;
    }
}
