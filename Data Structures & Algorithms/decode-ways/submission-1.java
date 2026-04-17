class Solution {
    public int numDecodings(String s) {
        if(s.equals(""))
            return 1;
        if(s.charAt(0) == '0')
            return 0;
        
        int count = 0;

        count += numDecodings(s.substring(1));

        if(s.length() > 1 && Integer.parseInt(s.substring(0, 2)) < 27)
            count += numDecodings(s.substring(2));
        

        return count;
    }
}
