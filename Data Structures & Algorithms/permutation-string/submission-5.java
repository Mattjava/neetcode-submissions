class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if(m > n)
            return false;

        HashMap<Character, Integer> permMap = new HashMap<>();

        for(int i = 0; i < m; i++)
        {
            char letter = s1.charAt(i);
            int count = permMap.getOrDefault(letter, 0);
            permMap.put(letter, count + 1);
        }

        HashMap<Character, Integer> currentMap = new HashMap<>();

        for(int i = 0; i < m; i++)
        {
            char letter = s2.charAt(i);
            int count = currentMap.getOrDefault(letter, 0);
            currentMap.put(letter, count + 1);
        }

        System.out.println(permMap);
        System.out.println(currentMap);

        for(int i = m; i < n; i++)
        {
            if(currentMap.equals(permMap))
                return true;
            
            char lastLetter = s2.charAt(i - m);

            int lastCount = currentMap.get(lastLetter);

            if(lastCount == 1)
                currentMap.remove(lastLetter);
            else
                currentMap.put(lastLetter, lastCount - 1);

            char newLetter = s2.charAt(i);
            int newCount = currentMap.getOrDefault(newLetter, 0);
            currentMap.put(newLetter, newCount + 1);
        }

        return currentMap.equals(permMap);
    }
}
