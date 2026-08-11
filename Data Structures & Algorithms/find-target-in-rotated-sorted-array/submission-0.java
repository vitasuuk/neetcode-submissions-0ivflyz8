class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;

        while (lo < hi) {
            mid = lo + (hi - lo) / 2;

            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else if (nums[mid] < nums[hi]) {
                hi = mid;
            }
        }

        int pivot = lo;

        int left = binarySearch(nums, target, 0, lo - 1);
        if (left != -1) {
            return left;
        }

        return binarySearch(nums, target, lo, nums.length - 1);

    }

    public int binarySearch(int nums[], int target, int lo, int hi) {
        int mid = 0;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return -1;
    }
}
