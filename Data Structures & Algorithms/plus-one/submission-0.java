class Solution {
    public int[] plusOne(int[] digits) {
        long number = 0;

        for(int digit : digits) {
            number += digit;
            number *= 10;
        }  

        number = (number / 10) + 1;

        int size = (int) Math.log10(number) + 1;

        int[] sum = new int[size];

        for(int i = size - 1; i >= 0; i--)
        {
            sum[i] = (int) (number % 10);
            number /= 10;
        }

        return sum;
    }
}
