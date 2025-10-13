public class Solution {
    public int findMin1(int[] nums) {
        // 二分法: 分为了两段，且左段的最低值一定大于右边一段的最大值
        // 故左段的有 nums[i] > nums[i-1] 
        // 右段 nums[i] <= nums[i+1] 由于右边可能只有一个点 因此可能有 '=' 
        int left = 0,right = nums.length-1;
        // 以右段的最后一个点作为参照物
        int x = nums[right];
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > x) left = mid + 1;
            else if (nums[mid] <= x) right = mid;
        }
        return nums[left];
    }

    public int findMin2(int[] nums) {
        // 暴力枚举
        int ret = 5001;
        for(int i = 0; i < nums.length; i++) {
            ret = Math.min(nums[i],ret);
        }
        return ret;
    }
}
