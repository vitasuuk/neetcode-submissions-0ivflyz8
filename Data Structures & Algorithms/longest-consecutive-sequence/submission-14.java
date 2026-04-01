class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) {return 0;}

        Set<Integer> n = new HashSet<>();
        for(int num : nums) {
            n.add(num);
        } 

        int totalLongest = 1;
        for(int i = 0; i < nums.length; i++) {
            if(n.contains(nums[i] - 1)) {
                continue;
            }
            int currentLength = 1;
            int curr = nums[i];
            for(int num : n) {
                if(n.contains(curr + 1)){
                    curr++;
                    currentLength++;
                }
                else{break;}
            }
            if(totalLongest < currentLength) {
                totalLongest = currentLength;
            }
        }

        return totalLongest;
    }
}
