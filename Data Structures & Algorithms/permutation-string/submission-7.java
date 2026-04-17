class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int baseLength = s1.length();

        if(baseLength > s2.length())
            return false;

        HashMap<Character, Integer> baseMap = new HashMap<>();

        for(int i = 0; i < baseLength; i++)
            baseMap.put(s1.charAt(i), (baseMap.getOrDefault(s1.charAt(i), 0) + 1));
        
        int start = 0;
        int end = baseLength;

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < end; i++)
            map.put(s2.charAt(i), (map.getOrDefault(s2.charAt(i), 0) + 1));

        for(int i = end; i < s2.length(); i++)
        {
            if(map.equals(baseMap))
                return true;

            char newLetter = s2.charAt(i);
            char previousLetter = s2.charAt(start++);

            map.put(newLetter, map.getOrDefault(newLetter, 0) + 1);

            map.put(previousLetter, map.get(previousLetter) - 1);

            if(map.get(previousLetter) == 0)
                map.remove(previousLetter);
        }
        

        return map.equals(baseMap);
    }
}
