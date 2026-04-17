class Solution {
    public boolean isPalindrome(String s) {
        String extract = "";
        for(int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);

            if(Character.isLetterOrDigit(letter))
                extract += letter;
        }

        extract = extract.toLowerCase();
        int start = 0;
        int end = extract.length() - 1;

        while(start <= end) {
            if(extract.charAt(start) != extract.charAt(end))
                return false;
            
            start++;
            end--;
        }

        return true;
    }
}
