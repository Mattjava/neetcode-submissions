class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        int[] decode = new int[n + 1];
        decode[n] = 1;

        if(Integer.parseInt(s.substring(n-1)) != 0)
            decode[n-1] = 1;
        
        for(int i = n - 2; i > -1; i--)
        {
            if(s.charAt(i) == '0')
                continue;

            int decodeWays = decode[i+1];

            if(Integer.parseInt(s.substring(i, i+2)) < 27)
                decodeWays += decode[i+2];

            decode[i] = decodeWays;
        }



        return decode[0];
    }
}
