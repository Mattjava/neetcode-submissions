class Solution {
    public char findMostFrequent(int[] arr)
    {
        int index = 0;
        int maxFreq = 0;
        for(int i = 0; i < 26; i++)
        {
            maxFreq = Math.max(arr[i], maxFreq);

            if(arr[i] == maxFreq)
                index = i;
        }

        return (char) (index+65);
    }

    public int characterReplacement(String s, int k) {
        int[] freqMap = new int[26];
        int len = 0;

        char mostFrequent = ' ';

        int start = 0;

        for(int end = 0; end < s.length(); end++)
        {
            freqMap[s.charAt(end)-65]++;
            mostFrequent = findMostFrequent(freqMap);

            int numOfUnfreq = (end - start + 1) - freqMap[mostFrequent-65];

            while(numOfUnfreq > k)
            {
                freqMap[s.charAt(start)-65]--;
                start++;
                mostFrequent = findMostFrequent(freqMap);
                numOfUnfreq = (end - start + 1) - freqMap[mostFrequent-65];
            }

            len = Math.max(end-start+1, len);
            System.out.println(s.substring(start, end+1) + " " + mostFrequent);
        }


        return len;
    }
}
