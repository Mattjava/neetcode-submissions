class Solution {
    public int[] productExceptSelf(int[] nums) {
        int productTotal = 1;
        int zeroCount = 0;
        boolean hasZero = false;
        boolean tooManyZeroes = false;
        for(int num : nums)
            if(num != 0)
                productTotal *= num;
            else {
                zeroCount++;
                if(zeroCount == 1)
                    hasZero = true;
                else if(zeroCount == 2)
                    tooManyZeroes = true;

            }
        
        int[] products = new int[nums.length];

        if(tooManyZeroes)
            return products;

        for(int i = 0; i < nums.length; i++) {
            if(hasZero) {
                if(nums[i] == 0) {
                    products[i] = productTotal;
                    return products;
                }
                continue;
            }
            products[i] = productTotal / nums[i];
        }
            

        return products;
    }
}  
