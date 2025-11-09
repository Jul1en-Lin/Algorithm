public class Solution {
    public String modifyString(String s) {
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] == '?') {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    // (i == 0 || ch != ss[i - 1]) 判断左边边界情况
                    // 如果不在最左边则判断ch != ss[i - 1]
                    // -------------------------------------------------------------
                    // (i == ss.length - 1 || ch != ss[i + 1]) 判断右边边界情况
                    // 如果不在最右边则判断ch != ss[i + 1])
                    if ((i == 0 || ch != ss[i - 1]) && (i == ss.length - 1 || ch != ss[i + 1])){
                        ss[i] = ch;
                        break;
                    }
                }
            }
        }
        return String.valueOf(ss);// 转换为字符串
    }
}
