class Solution {
    public int numDecodings(String s)
    {
        return search(new HashMap<Integer, Integer>(), 0, s);
    }

    public int search(HashMap<Integer, Integer> map, int index, String s) {
        if(map.containsKey(index))
            return map.get(index);
        
        if(s.equals("")) {
            return 1;
        } else if(s.charAt(0) == '0') {
            return 0;
        }

        int count = 0;

        count += numDecodings(s.substring(index+1));

        if(s.length() > 1 && Integer.parseInt(s.substring(index, index+2)) < 27)
            count += numDecodings(s.substring(index+2));

        map.put(index, count);

        return count;
    }
}
