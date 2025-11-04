public class Solution {
    public int missingNumber(int[] nums) {
        // 数组模拟哈希表
        int n = nums.length;
        int[] hash = new int[n + 1];
        for (int x : nums) {
            hash[x]++;
        }
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] == 0) return i;
        }
        return -1;
    }
    public int missingNumber2(int[] nums) {
        // 位运算 (异或运算律)
        int missNum = 0;
        for (int x : nums) missNum ^= x;
        for (int i = 0; i < nums.length + 1; i++) missNum ^= i;
        return missNum;
    }
}
