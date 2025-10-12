public class Solution {
    public int findPeakElement1(int[] nums) {
        int left = 0,right = nums.length-1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid+1]) right = mid; // 左段一定有峰值 右边不一定
            else left = mid + 1;// 右段一定有峰值 左边不一定
        }
        return left;
    }

    public int findPeakElement2(int[] nums) {
        int left = 0,right = nums.length-1;
        while(left < right) {
            int mid = left + (right - left + 1) / 2;
            if(nums[mid] > nums[mid-1]) left = mid;
            else right = mid - 1;
        }
        return left;
    }
}
