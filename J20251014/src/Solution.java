import java.util.Arrays;

public class Solution {
    public int missingNumber1(int[] nums) {
        // 数学（高斯求和公式）
        Arrays.sort(nums);
        int n = nums.length;
        int sum = n * (n+1) / 2;
        for(int i = 0; i < nums.length; i++) sum -= nums[i];
        return sum;
    }

    public int missingNumber2(int[] nums) {
        // 二分法
        Arrays.sort(nums);
        int left = 0,right = nums.length-1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == mid) left = mid + 1;
            else right = mid;
        }
        // 判断边界
        return nums[left] == left ? left + 1 : left;
    }

    public int missingNumber3(int[] nums) {
        // 直接遍历找结果
        Arrays.sort(nums);
        int index = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1] + 1) index = i;
        }
        return (nums[index] != index) ?  nums[index]-1 : nums.length;
    }

    // 哈希表
    public int missingNumber(int[] nums) {
        int[] hash = new int[nums.length+1];
        for(int i = 0; i < nums.length; i++) {
            hash[nums[i]]++;
        }
        for(int j = 0; j < hash.length; j++) {
            if(hash[j] == 0) return j;
        }
        return -1;
    }
}
