class Solution {
    public int[] productExceptSelf(int[] nums) {
        int total = 1;
        int numZeroes = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                total *= nums[i];
            } else {
                numZeroes++;
            }
        }
        
        if(numZeroes > 1) {
            return new int[nums.length];
        }

        for(int j = 0; j < nums.length; j++) {
            if(numZeroes == 1) {
                if(nums[j] != 0) {
                    nums[j] = 0;
                }
                else{
                    nums[j] = total;
                }
            }
            else {
                nums[j] = total / nums[j];
            }
        }

        return nums;
    }
}  
