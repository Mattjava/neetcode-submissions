class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> substringCount = new HashSet<Character>();
        int l = 0;
        int res = 0;

        for(int r = 0; r < s.length(); r++) {
            while(substringCount.contains(s.charAt(r))) {
                substringCount.remove(s.charAt(l));
                l++;
            }

            substringCount.add(s.charAt(r));
            res = Math.max(substringCount.size(), res);
        }

        return res;
    }
}
