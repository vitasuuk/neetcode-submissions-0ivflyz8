class Solution {
    public boolean hasDuplicate(int[] nums) 
    {
        Set<Integer> occurance = new HashSet<>();
        for(int i : nums)
        {
            if(!occurance.add(i))
                return true;
        }

        return false;

    }
}