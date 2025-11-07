import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int singleNumber(int[] nums) {
        // 位运算
        // 这一题所有的数的任意一个比特位可能会出现以下四种情况
        //（其中 ‘+’ 后表示的是只出现一次的数字的比特位的情况）
        // 1. 3n个0 + 0 -> 总和为 0 --%3--> 0
        // 2. 3n个0 + 1 -> 总和为 1 --%3--> 1
        // 3. 3n个1 + 0 -> 总和为 3n --%3--> 0
        // 4. 3n个1 + 1 -> 总和为 3n + 1 --%3--> 1
        // 发现 %3 之后得出的数跟只出现一次的数的比特位是对应的
        // 根据这个规律将 %3 之后的数给赋值到ret的对应的比特位上
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int x : nums) {
                if (((x >> i) & 1) == 1)
                    sum++;
            }
            sum %= 3;
            if (sum == 1) ret |= (1 << i);
        }
        return ret;
    }

    public int singleNumber2(int[] nums) {
        // 哈希表
        Map<Integer,Integer> hash = new HashMap<>();
        for (int x : nums) hash.put(x, hash.getOrDefault(x, 0) + 1);
        for (int x : nums)
            if (hash.get(x) == 1) return x;
        return -1;
    }


}
