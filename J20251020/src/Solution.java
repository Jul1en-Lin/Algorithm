import java.util.HashMap;

public class Solution {
    public int subarraySum1(int[] nums, int k) {
        // 暴力枚举
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if(sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
    public int subarraySum2(int[] nums, int k) {
        // 前缀和 (这里效率还不如暴力枚举，还多了个 o (N) )
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }

        // 使用
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == k) count++;
            for (int j = i + 1; j < n; j++) {
                if(dp[j] - dp[i] == k) count++;
            }
        }
        return count;
    }
    public int subarraySum3(int[] nums, int k) {
        // 前缀和 + 哈希表 ( 最优 )
        HashMap<Integer,Integer> hash = new HashMap<>();
        hash.put(0, 1);
        // sum 表示当前位置之前的前一个前缀和数组
        int sum = 0,count = 0;
        for(int x : nums) {
            // 当前位置的前缀和数组为 sum += x;
            sum += x;
            count += hash.getOrDefault(sum - k, 0);// 统计次数
            // 把当前位置的前缀和数组放入哈希表中
            hash.put(sum, hash.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
