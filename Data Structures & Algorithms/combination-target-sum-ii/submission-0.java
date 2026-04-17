class Solution {
    public int summation(List<Integer> list)
    {
        int sum = 0;

        for(int num: list)
            sum += num;

        return sum;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> chosenCandidates, List<Integer> potentialCandidates, int target)
    {
        int sum = summation(chosenCandidates);

        if(sum >= target)
        {
            if(sum == target)
            {
                Integer[] candidateArr = new Integer[chosenCandidates.size()];
                candidateArr = chosenCandidates.toArray(candidateArr);
                Arrays.sort(candidateArr);

                List<Integer> officialList = Arrays.asList(candidateArr);

                if(!list.contains(officialList))
                    list.add(officialList);
            }

            return;
        }

        for(int i = 0; i < potentialCandidates.size(); i++)
        {
            int value = potentialCandidates.remove(i);
            int index = chosenCandidates.size();

            chosenCandidates.add(value);

            backtrack(list, chosenCandidates, potentialCandidates, target);

            chosenCandidates.remove(index);
            potentialCandidates.add(i, value);

        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> candidateList = new LinkedList<Integer>();

        for(int candidate : candidates)
            candidateList.add(candidate);

        List<List<Integer>> combinations = new LinkedList<List<Integer>>();

        backtrack(combinations, new LinkedList<Integer>(), candidateList, target);

        return combinations;
    }
}
