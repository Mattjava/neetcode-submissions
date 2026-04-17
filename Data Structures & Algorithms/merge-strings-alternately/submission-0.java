class Solution {
    public String mergeAlternately(String word1, String word2) {
        String result = "";

        int first = 0;

        int last = 0;

        while(first < word1.length() && last < word2.length())
        {
            result = result + word1.charAt(first) + word2.charAt(last);

            first++;
            last++;
        }

        result += word1.substring(first);
        result += word2.substring(last);

        return result;
    }
}