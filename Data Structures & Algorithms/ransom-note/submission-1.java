class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magazineCount = new HashMap<>();

        for(int i = 0; i < magazine.length(); i++)
        {
            char letter = magazine.charAt(i);

            magazineCount.put(letter, magazineCount.getOrDefault(letter, 0) + 1);
        }

        for(int i = 0; i < ransomNote.length(); i++)
        {
            char letter = ransomNote.charAt(i);

            int letterCount = magazineCount.getOrDefault(letter, 0);

            if(letterCount == 0)
                return false;
            
            magazineCount.put(letter, --letterCount);
        }

        return true;
    }
}