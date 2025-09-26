public class Demo2 {

    public int minSubArrayLen(int target, int[] nums) {
        // 暴力枚举
        int n = nums.length,len = Integer.MAX_VALUE;
        for(int left = 0; left < n; left++) {
            int sum = 0;
            for(int right = left; right < n; right++) {
                sum += nums[right];
                if(sum >= target) {
                    len = Math.min(len,right - left + 1);
                    break;
                }
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
    public static int minSubArrayLen1(int target, int[] nums){
        int len = Integer.MAX_VALUE;
        for (int left = 0,right = 0,sum = 0,n = nums.length;
            right < n;right++) {
            sum += nums[right];// 进窗口
            // 判断
            while(sum >= target) {
                len = Math.min(len, right - left + 1);//更新结果
                sum -= nums[left++];// 出窗口
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
