import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 暴力枚举
    // 如果 1 的数目加起来 * 2 等于整体子数组的长度
    // 则 1 和 0 的数量相同
    public int findMaxLength1(int[] nums) {
        int len = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                int check = j - i + 1;
                if (sum * 2 == check) len = Math.max(len, check);
            }
        }
        return len;
    }


    // 将0变成-1，这样就转换为和为k （k == 0）的子数组的那道题目
    // 注意细节问题
    // 1. 哈希表里存什么？存的是前缀和 + 下标（不存子数组长度是因为存下标更好计算）
    // 2. 什么时候放进哈希表？用完之后
    // 3. 如果有重复的改如何存？只保留一开始保存的那一对，因为那个距离i最远，要保持是最长的子数组
    // 4. 默认的前缀为0 的情况如何存？  hash[0] = -1; 因为哈希表里存的是前缀和 + 下标
    // 5. 长度如何计算？ 用 j - i + 1 但因为前面的前缀和是 [0,j] 后面的连续子数组的下标是从[j + 1,i-1] 故 长度是 j - i + 1 - 1 == j - i
    public int findMaxLength2(int[] nums) {
        // 把 0 转换成 -1
        // -> 和为k == 0的子数组题目
        // 哈希表里存前缀和 + 下标
        Map<Integer,Integer> hash = new HashMap<Integer,Integer>();
        hash.put(0, -1);
        // sum 为前一个前缀和数组
        int sum = 0,len = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 0 ? -1 : 1); // 把 0 改成 -1
            if (!hash.containsKey(sum)) hash.put(sum, i);
            else len = Math.max(len, i - hash.get(sum));
        }
        return len;
    }
}
