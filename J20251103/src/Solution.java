public class Solution {
    public boolean isUnique(String astr) {
        // 位图 + 鸽巢 / 抽屉原理 (优化)
        int bitMap = 0;
        // 鸽巢 / 抽屉原理(优化)
        // 如果字符串的长度大于26，则一定是有重复的（一共且只有26个英文字母，顶多刚好从a ~ z 全部都过一遍）
        if (astr.length() > 26) return false;

        for (int i = 0; i < astr.length(); i++) {
            int x = astr.charAt(i) - 'a';
            // 先判断字符是否在位图中
            if (((bitMap >> x) & 1) == 1) return false;
            bitMap |= 1;// 把当前字符加入到位图中
            bitMap <<= x;
        }
        return true;
    }
    public boolean isUnique2(String astr) {
        // 哈希表
        int[] hash = new int[26];
        char[] astrs = astr.toCharArray();
        for (char ch : astrs) {
            hash[ch - 97]++;
            if (hash[ch - 97] == 2) return false;
        }
        return true;
    }
}
