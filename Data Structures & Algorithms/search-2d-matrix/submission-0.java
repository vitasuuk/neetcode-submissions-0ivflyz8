class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (BinarySearch(matrix[i], target) > -1) {
                return true;
            }
        }

        return false;
    }


    private int BinarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
