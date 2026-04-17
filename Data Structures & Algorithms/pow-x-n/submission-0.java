class Solution {
    public double myPow(double x, int n) {
        if(x == 0)
            return 0;
        else if(n == 0)
            return 1;
        else if(n == 1)
            return x;

        int absN = Math.abs(n);

        System.out.println(Math.abs(n));

        double before = myPow(x, absN / 2);

        System.out.println(before);

        double result = before * before;

        if(absN % 2 == 1)
            result *= x;

        if(n < 0)
            result = 1 / result;
        
        return result;
    }
}
