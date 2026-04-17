class Solution {
    public int numDecodings(String s)
    {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(s.length(), 1);
        return search(map, 0, s);
    }

    public int search(HashMap<Integer, Integer> map, int index, String s) {
        if(map.containsKey(index)) 
            return map.get(index);
        
        
        if(s.charAt(index) == '0') 
            return 0;
        

        int count = search(map, index + 1, s);

        if(s.length() - index > 1 && Integer.parseInt(s.substring(index, index+2)) < 27)
            count += search(map, index + 2, s);

        map.put(index, count);

        return count;
    }
}
