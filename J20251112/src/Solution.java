public class Solution {
    public String countAndSay(int n) {
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        sb1.append('1');
        // 趟数
        for (int say = 1; say < n; say++) {
            // 双指针遍历字符串
            int left = 0;
            for (int right = 0;right < sb1.length(); right++) {
                // 相同的继续往下走 直到找到不合法的位置
                if (sb1.charAt(right) != sb1.charAt(left)) {
                    char ch = sb1.charAt(left);
                    int count = right - left;
                    sb2.append(count).append(ch);
                    left = right;
                }
            }
            // 处理最后一段字符串
            int count = sb1.length() - left;
            sb2.append(count).append(sb1.charAt(left));

            // 最终赋值
            sb1.setLength(0);
            sb1.append(sb2);// Stringbuffer的赋值形式
            sb2.setLength(0);
        }
        return sb1.toString();
    }

    public String countAndSay2(int n) {
        String ret = "1";
        // 解析ret 走n - 1次
        for (int i = 1; i < n; i++) {
            StringBuilder tmp = new StringBuilder();
            // 双指针
            int len = ret.length();
            for (int left = 0,right = 0; right < len; ) {
                // 防止越界
                while (right < len && ret.charAt(left) == ret.charAt(right)) right++;
                // 添加元素
                tmp.append(Integer.toString(right - left)).append(ret.charAt(left));
                left = right;
            }
            ret = tmp.toString();
        }
        return ret;
    }
}
