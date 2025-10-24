import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // 暴力枚举
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum % k == 0) count++;
            }
        }
        return count;
    }

    public int subarraysDivByK2(int[] nums, int k) {
        // 前缀和 + 哈希表 (同余定理)
        Map<Integer,Integer> hash = new HashMap<>();
        // 避免整个数组和都为0 在[0 , -1] 里寻找 提前放入一个
        hash.put(0, 1);

        // 创建前缀和 sum 模拟代替 dp[i]
        int sum = 0, count = 0;
        for (int x : nums) {
            sum += x;// 表示当前的前缀和
            // C++ Java 的负 % 正 = 负数
            // 为了确保得到的数是正数，用到同余定理
            int tmp = (sum % k + k) % k;
            count += hash.getOrDefault(tmp, 0);
            hash.put(tmp,hash.getOrDefault(tmp, 0) + 1);// 把当前tmp放进hash表里
        }

        return count;
    }
}
