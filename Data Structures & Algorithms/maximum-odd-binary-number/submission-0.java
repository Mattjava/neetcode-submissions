class Solution {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length();
        int oneCount = 0;


        for(int i = 0; i < n; i++)
        {
            if(s.charAt(i) == '1')
                oneCount++;
        }
        String result = "";

        for(int i = 0; i < oneCount - 1; i++)
            result += "1";

        for(int i = 0; i < n - oneCount; i++)
            result += "0";

        if(oneCount > 0)
            result += "1";

        return result;
    }
}