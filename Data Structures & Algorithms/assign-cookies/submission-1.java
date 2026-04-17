class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        Arrays.sort(g);

        int cookiePoint = s.length - 1;

        for(int childPoint = g.length - 1; childPoint > -1; childPoint--)
        {
            if(cookiePoint == -1)
                break;
            if(s[cookiePoint] >= g[childPoint])
                cookiePoint--;
        }

        return s.length - cookiePoint - 1;
    }
}