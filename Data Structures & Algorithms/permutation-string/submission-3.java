class Solution {


    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;

        HashMap<Character, Integer> count = new HashMap<>();

        // Generate s1 map
        for(int i = 0; i < s1.length(); i++)
        {
            char currentChar = s1.charAt(i);

            if(!count.containsKey(currentChar))
                count.put(currentChar, 1);
            else {
                int charCount = count.get(currentChar);
                count.put(currentChar, charCount + 1);
            }
        }

        HashMap<Character, Integer> currentCount = new HashMap<>();

        // Generate initial s2 map
        for(int i = 0; i < s1.length(); i++)
        {
            char currentChar = s2.charAt(i);

            if(!currentCount.containsKey(currentChar))
                currentCount.put(currentChar, 1);
            else {
                int charCount = currentCount.get(currentChar);
                currentCount.put(currentChar, charCount + 1);
            }
        }


        for(int i = s1.length(); i < s2.length(); i++)
        {
            if(currentCount.equals(count))
                return true;

            char previousChar = s2.charAt(i - s1.length());

            if(currentCount.get(previousChar) == 1)
                currentCount.remove(previousChar);
            else {
                int prevCount = currentCount.get(previousChar);
                currentCount.put(previousChar, prevCount - 1);
            }

            char newChar = s2.charAt(i);

            if(!currentCount.containsKey(newChar))
                currentCount.put(newChar, 1);
            else {
                int charCount = currentCount.get(newChar);
                currentCount.put(newChar, charCount + 1);
            }

        }

        return currentCount.equals(count);
    }
}
