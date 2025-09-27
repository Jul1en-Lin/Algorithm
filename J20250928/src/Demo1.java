public class Demo1 {
    public int minOperations(int[] nums, int x) {
        // 思想：正难则反
        // 取中间数组元素和 tmp 正好等于 sum - x 时最长的数组长度 ——> 滑动窗口
        int n = nums.length,len = -1;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        double target = sum - x,tmp = 0;
        // 组内全部元素刚好能减完
        if(target == 0) return n;
        // 进窗口
        for(int left = 0,right = 0; right < n; right++) {
            tmp += nums[right];
            // 判断
            while(left < n && tmp > target) {
                tmp -= nums[left++];
            }
            // 更新结果
            if(tmp == target) {
                len = Math.max(len,right - left + 1);
            }
        }
        // 不符合条件
        if(len == -1) return -1;
        return n-len;
    }
}
