public class Solution {
    public static int[] searchRange1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int start = 0, end = 0;
        boolean flg = true;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                // 开始位置
                for (start = mid; start > 0;) {
                    if (nums[start] == nums[start - 1]) start--;
                    else break;
                }
                // 结束位置
                for (end = mid; end < nums.length - 1;) {
                    if (nums[end] == nums[end + 1]) end++;
                    else break;
                }
                return new int[] { start, end };
            }
        }
        return new int[] { -1, -1 };
    }

    // 拆成两个独立的二分搜索，注意循环条件与中点的选取
    public int[] searchRange2(int[] nums, int target) {
        // 处理空数组
        int[] ret = {-1,-1};
        if(nums.length == 0) return ret;

        // 确定左边界 + 循环条件
        int left = 0,right = nums.length-1;
        int start = -1,end = -1;
        while(left < right) {
            // 左边界中点的选取
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target)
                right = mid;
            else left = mid + 1;
        }
        // left == right 处
        if(nums[left] != target) return ret;
        else start = left;

        // 确定右边界 + 循环条件
        left = 0;
        right = nums.length-1;
        while(left < right) {
            // 右边界中点的选取
            int mid = left + (right - left + 1) / 2;
            if(nums[mid] <= target)
                left = mid;
            else right = mid - 1;
        }
        // left == right 处
        if(nums[right] != target) return ret;
        else end = right;
        return new int[]{start,end};
    }
}


