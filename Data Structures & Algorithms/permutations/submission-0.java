class Solution {
    public void permute(List<List<Integer>> permutations, List<Integer> permutation, List<Integer> base)
    {
        if(base.isEmpty())
        {
            permutations.add(new LinkedList<Integer>(permutation));
            return;
        }

        for(int i = 0; i < base.size(); i++)
        {
            int value = base.remove(i);
            permutation.add(value);

            int index = permutation.indexOf(value);
            permute(permutations, permutation, base);
    
            base.add(i, permutation.get(index));
            permutation.remove(index);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> listOfNumbers = new LinkedList<Integer>();

        for(int num : nums)
            listOfNumbers.add(num);
        
        List<List<Integer>> permutations = new LinkedList<List<Integer>>();

        permute(permutations, new LinkedList<Integer>(), listOfNumbers);
        return permutations;
    }
}
