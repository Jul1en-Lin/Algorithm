public class Solution {
    // 此代码有bug，不应该维护count有效字符的个数，count >= tt的个数也是合法窗口
    // 此处count应是维护有效字符的种类
    public String minWindow1(String ss, String tt) {
        int[] hash1 = new int[128], hash2 = new int[128];
        char[] t = tt.toCharArray(), s = ss.toCharArray();
        int len = Integer.MAX_VALUE;
        String ret = "";
        for (char ch : t) hash1[ch - '0']++;
        // 进窗口
        for (int left = 0, right = 0, count = 0; right < s.length; right++) {
            char in = s[right];
            hash2[in - '0']++;
            if (hash2[in - '0'] <= hash1[in - '0']) count++;

            // 判断
            while (count == t.length) {
                // 更新结果
                if (len >= right - left + 1) {
                    len = Math.min(len, right - left + 1);
                    ret = ss.substring(left, right + 1);
                }
                // 出窗口
                char out = s[left++];
                if (hash2[out - '0'] <= hash1[out - '0']) count--;
                hash2[out - '0']--;
            }
        }
        return ret;
    }

    // count 维护有效字符的种类
    public String minWindow(String ss, String tt) {
        int[] hash1 = new int[128];// 统计字符串 t 中字符的个数
        int[] hash2 = new int[128];
        char[] s = ss.toCharArray();
        char[] t = tt.toCharArray();
        int kinds = 0;

        for(char ch : t)  {
            if(hash1[ch] == 0) kinds++;// 如果是第一次进就证明是新的种类
            hash1[ch]++;
        }
        int minlen = Integer.MAX_VALUE,begin = -1;
        // 进窗口
        for(int left = 0,right = 0,count = 0; right < s.length; right++) {
            char in = s[right];
            hash2[in]++;
            if(hash1[in] == hash2[in]) count++;// 进窗口后维护

            // 判断
            while(count == kinds) {
                // 更新结果
                if(minlen > right - left + 1) {
                    minlen = Math.min(minlen,right - left + 1);
                    begin = left;
                }
                // 出窗口
                char out = s[left++];
                if(hash2[out] == hash1[out]) count--;// 出窗口前维护
                hash2[out]--;
            }
        }
        if(begin == -1) return new String();
        else return ss.substring(begin,begin + minlen);
    }
}
