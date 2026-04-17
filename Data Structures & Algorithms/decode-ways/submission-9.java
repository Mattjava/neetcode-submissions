class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        int[] arr = new int[n + 1];
        arr[n] = 1;

        if(s.charAt(n-1) != '0')
            arr[n - 1] = 1;

        for(int i = n - 2; i > -1; i--)
        {
            if(s.charAt(i) == '0')
                continue;

            int ways = arr[i+1];

            if(Integer.parseInt(s.substring(i, i+2)) < 27)
                ways += arr[i+2];

            arr[i] = ways;
        }


        return arr[0];
    }
}
