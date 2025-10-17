public class Solution {
    public int pivotIndex1(int[] nums) {
        int n = nums.length;
        int[] f = new int[n],g = new int[n];
        // 初始化
        for(int i = 1; i < n; i++)
            f[i] = f[i - 1] + nums[i - 1];
        for(int i = n - 2; i >= 0; i--)
            g[i] = g[i + 1] + nums[i + 1];
        // 使用
        for(int i = 0; i < n; i++)
            if(f[i] == g[i])
                return i;
        return -1;
    }

    public int pivotIndex2(int[] nums) {
        // 初始化
        int[] dp = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i++)
            dp[i] = dp[i - 1] + nums[i - 1];
        // 使用
        for(int i = 0; i < nums.length; i++) {
            int leftsum = dp[i];
            int rightsum = dp[nums.length] - dp[i+1];
            if(leftsum == rightsum) return i;
        }
        return -1;
    }
}
