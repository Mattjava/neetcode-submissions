class Solution {

    public static int mySqrt(int x) {
        if(x == 1 || x == 0)
            return x;

        int min = 1;
        int max = x;
        int result = 1;
        while(min <= max)
        {
            int middle = min + (max - min) / 2;

            long solution = (long) middle * (long) middle;

            if(solution <= x) {
                min = middle + 1;
                result = middle;
            } else {
                max = middle - 1;
            }

        }

        return result;
    }
}