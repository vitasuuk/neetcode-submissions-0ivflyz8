class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> store = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
        {
            store.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++)
        {
            int diff = target - nums[i];
            if(store.containsKey(diff) && store.get(diff) != i)
                return new int[]{i, store.get(diff)};
        }

        return new int[0];
    }
}
