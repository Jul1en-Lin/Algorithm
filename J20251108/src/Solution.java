public class Solution {
    public int[] missingTwo(int[] nums) {
        // 分两部分
        // 如何区分第1部分和第2部分？？
        // 丢失的数字 + 只出现一次的数字III
        int a = 0,b = 0;// 丢失数字a，b
        int tmp = 0;
        // 将所有的数字全部异或在一起
        for (int i = 0; i <= nums.length + 2; i++) tmp ^= i;
        for (int x : nums) tmp ^= x;
        // 此时 tmp 存的是 a，b 异或在一起的结果

        // 找出 a，b 两个数比特位不同的那一位
        int lowbit = tmp & (-tmp);

        // 注意是要把全部的数都异或一遍，不要漏了
        for (int x : nums) {
            if ((x & lowbit) == 0)
                a ^= x;
            else
                b ^= x;
        }
        for (int i = 1; i <= nums.length + 2; i++) {
            if ((i & lowbit) == 0)
                a ^= i;
            else
                b ^= i;
        }
        return new int[] {a, b};
    }
}
