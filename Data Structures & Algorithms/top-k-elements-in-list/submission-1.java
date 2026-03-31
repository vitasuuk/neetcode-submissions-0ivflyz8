class Solution 
{
    public int[] topKFrequent(int[] nums, int k) 
    {
        //create a freq map for all numbers in the array 
        Map<Integer, Integer> freq = new HashMap<>();
        for(int n : nums)
        {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        List<int[]> store = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : freq.entrySet())
        {
            store.add(new int[] {entry.getValue(), entry.getKey()});
        }

        store.sort((a, b) -> b[0] - a[0]);
        
        int[] top = new int[k];

        for(int i = 0; i < k; i++)
        {
            top[i] = store.get(i)[1];
        }

        return top;

    }

}
