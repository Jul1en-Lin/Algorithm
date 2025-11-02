public class Solution {
    // 位 1 的个数
    public int hammingWeight(int n) {
        // 这个 n 就是二进制数字
        int count = 0;
        while (n != 0) {
            int ret = n & 1; // & 上 1 如果是 则为 1，如果是 0 则为 0
            count += ret;
            n = n >>> 1; // 右移上 1 位
        }
        return count;
    }
    // 比特位计数
    public int[] countBits(int n) {
        int[] ret = new int[n + 1];
        ret[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            int x = i;
            int count = 0;
            while (x != 0) {
                count += x & 1;
                x >>>= 1;
            }
            ret[i] = count;
        }
        return ret;
    }
    // 汉明距离
    public int hammingDistance(int x, int y) {
        int tmp = x ^ y;
        int count = 0;
        while (tmp != 0) {
            count += tmp & 1;
            tmp >>>= 1;
        }
        return count;
    }
    // 只出现一次的数字
    public int singleNumber(int[] nums) {
        // 利用位运算
        // 异或
        // a ^ 0 = a,a ^ a = 0,a ^ b ^ c = a ^ (b ^ c)
        // 偶次数的x ^ 后为 0，奇数次的x ^ 后为x
        int singleNumber = 0;
        for (int x : nums) {
            singleNumber ^= x;
        }
        return singleNumber;
    }
    // 只出现一次的数字III
    public int[] singleNumber2(int[] nums) {
        int[] ret = new int[2];
        // 假设只出现一次的元素是 a 和 b
        int a = 0,b = 0;
        int num = 0;
        for (int x : nums) num ^= x;
        // 提取一个数（二进制）中最右侧的1（最低位）
        // 因为最后得到的num肯定是两个不相等的数字互相异或后得到的结果，且在这个二进制位上，a 和 b 的值不同
        // 所以提取出的（二进制）最右侧的数肯定一个为1，一个为0（异或性质）
        // 这样才能有数字1，不然就没数字了（除了两个0）
        int lowbit = num & (-num);
        // 根据最右侧的 1 来对 nums[] 进行分组排序，这样就能把两个只出现一次的数字给分开到两个组且不在一个组里
        // 然后根据最右侧是1 / 0 分为两个小组，小组内互相异或，得到的结果就只剩下a / b
        for (int x : nums) {
            // 分为 A 组，如果等于 0：说明 x 在那个 bit 位上是 0
            if ((x & lowbit) == 0) {
                a ^= x;
            }else{
                // 分为 B 组，但不能说 (x & lowbit) == 1，因为在二进制中不同位置的 1，有可能是2、4、8、16....
                // 如果想表达 x 在那个 bit 位上是 1：则是 (x & lowbit) == lowbit
                b ^= x;
            }
        }
        ret[0] = a;
        ret[1] = b;
        return ret;
    }
}
