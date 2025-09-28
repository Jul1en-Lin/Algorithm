import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Demo1 {
    public static int totalFruit1(int[] fruits) {
        // 暴力解法
        int len = 0;
        for (int left = 0; left < fruits.length; left++) {
            Set<Integer> set = new HashSet<>();
            for (int right = left; right < fruits.length; right++) {
                set.add(fruits[right]);
                if (set.size() > 2) break;
                len = Math.max(len,right - left + 1);
            }
        }
        return len;
    }

    public static int totalFruit2(int[] fruits) {
        int n = fruits.length;
        int len = 0;
        Map<Integer,Integer> map = new HashMap<>();// 用Map统计水果种类与采摘水果数量
        for(int left = 0,right = 0; right < n; right++) {
            // 进窗口
            map.put(fruits[right],map.getOrDefault(fruits[right],0) + 1);

            // 判断
            while (map.size() > 2) {
                // 使left减到水果数量为0的位置
                map.put(fruits[left],map.get(fruits[left])-1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            // 更新结果
            len = Math.max(len,right-left+1);
        }
        return len;
    }

    public static int totalFruit3(int[] f) {
        int len = 0;
        int n = f.length;
        // 用数组来模拟哈希Map，数组的值表示水果的数量
        int[] hash = new int[n+1];
        // 如何知道hash数组的有效元素个数？用kinds表示
        int kinds = 0;
        for(int left = 0,right = 0; right < n; right++) {
            if (hash[f[right]] == 0) kinds++; // 第一次进入hash
            hash[f[right]]++;// 进窗口

            // 判断
            while (kinds > 2) {
                hash[f[left]]--;
                if (hash[f[left]] == 0) {
                    // kinds--代表移除水果种类
                    kinds--;
                }
                left++;
            }
            // 更新结果
            len = Math.max(len,right-left+1);
        }
        return len;
    }
}
