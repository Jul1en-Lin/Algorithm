public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n], f = new int[n], g = new int[n];
        // 预处理前缀积和后缀积数组
        // 细节边界问题
        f[0] = g[n - 1] = 1;
        for (int i = 1; i < n; i++)
            f[i] = f[i - 1] * nums[i - 1];
        for (int i = n - 2; i >= 0; i--)
            g[i] = g[i + 1] * nums[i + 1];
        // 使用
        for (int i = 0; i < n; i++)
            answer[i] = f[i] * g[i];
        return answer;
    }
}
