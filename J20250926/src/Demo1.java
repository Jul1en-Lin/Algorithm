public class Demo1 {
    public int longestOnes1(int[] nums, int k) {
        // 暴力枚举 + zero计数器
        int n = nums.length;
        int count = 0;
        for(int i = 0;i < n;i++) {
            int zero = 0;
            for(int j = i;j < n;j++) {
                if(nums[j] == 0) {
                    zero++;
                }
                if(zero > k) break;
                count = Math.max(count,j - i + 1);
            }
        }
        return count;
    }

    // 滑动窗口
    public int longestOnes2(int[] nums, int k) {
        int left = 0,right = 0,zero = 0;
        int n = nums.length;
        int count = 0;
        for (right = 0; right < n; right++) {
            if (nums[right] == 0) zero++;
            while(zero > k) {
                if (nums[left] == 0) zero--;
                left++;
            }
            count = Math.max(count, right - left + 1);
        }
        return count;
    }
}
