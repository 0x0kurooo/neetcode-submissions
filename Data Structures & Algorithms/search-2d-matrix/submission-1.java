class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Find the correct row first
        int row = matrix.length - 1;
        for (int i = matrix.length - 1; i >= 0; i--) {
            if (target == matrix[i][0]) {
                return true;
            }
            if (target > matrix[i][0]) {
                row = i;
                break;
            }
        }

        // Search in the row
        int l = 0, r = matrix[row].length - 1;
        while (l <= r) {
            int mid = (l + r + 1) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return false;
    }
}
