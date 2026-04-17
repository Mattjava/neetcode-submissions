class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left < right)
        {
            if(s.charAt(left) != s.charAt(right))
                return false;
            
            left++;
            right--;
        }

        return true;
    }

    public int countSubstrings(String s) {
        HashSet<String> seenPalindromes = new HashSet<>();
        int count = 0;

        for(int end = s.length() - 1; end > -1; end--)
        {
            int start = 0;

            for(int i = end+1; i < s.length() + 1; i++)
            {
                String substring = s.substring(start, i);

                if(seenPalindromes.contains(substring) || isPalindrome(substring)) {
                    if(!seenPalindromes.contains(substring))
                        seenPalindromes.add(substring);
                    count++;
                }

                start++;
            }
        }

        return count;
    }
}
