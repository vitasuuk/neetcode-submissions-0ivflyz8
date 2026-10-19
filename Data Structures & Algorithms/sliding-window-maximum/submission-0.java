class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        int[] result = new int[nums.length - k + 1];
        
        int res_index = 0;

        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(new int[]{nums[i], i});

            int left = i - k + 1;

            // lazy deletion
            if (i >= k - 1) {
                while (maxHeap.peek()[1] < left) {
                    maxHeap.poll();
                }

                result[res_index++] = maxHeap.peek()[0];
            }

            
        }

        return result;
    }
}
