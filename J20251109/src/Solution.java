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

    public int findPoisonedDuration(int[] ts, int duration) {
        int time = 0;
        for (int i = 0; i < ts.length - 1; i++) {
            int x = ts[i + 1] - ts[i];
            if (x >= duration) {
                time += duration;
            }else {
                // x < duration 时候只会中毒他们之间的间隔秒，中毒时间重置
                time += x;
            }
        }
        time += duration;// 处理最后一位的情况
        return time;
    }
}
