public class Solution {
    // 平方有递归性，考虑用二分查找法
    public int mySqrt(int x) {
        if(x == 0) return 0;
        long left = 1,right = x;
        while(left < right) {
            // 下面有-1 故 mid 要 +1
            long mid = left + (right - left + 1) / 2;
            if(mid * mid <= x) left = mid;
            else if(mid * mid > x) right = mid - 1;
        }
        return (int)left;
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0,right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left + 1) / 2;
            if(nums[mid] <= target) left = mid;
            else right = mid - 1;
        }
        // 判断
        if(nums[right] >= target) return right;
        else return right + 1;
    }

    public int searchInsert2(int[] nums, int target) {
        int left = 0,right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        // 判断一下末尾的位置
        if(nums[right] < target) return right + 1;
        return right;
    }
}
