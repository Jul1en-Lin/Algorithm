import java.util.*;

public class Demo1 {
    public List<Integer> findSubstring(String ss, String[] words) {
        List<Integer> ret = new ArrayList<>();
        int lenword = words[0].length();
        int windows = words.length * lenword;
        Map<String, Integer> hash1 = new HashMap<>();
        for(String str : words) hash1.put(str,hash1.getOrDefault(str,0)+1);

        // 滑动窗口执行次数
        for(int i = 0; i < lenword; i++) {
            Map<String, Integer> hash2 = new HashMap<>();
            for(int left = i,right = i,count = 0;right <= ss.length() - lenword;right += lenword) {
                // 进窗口 + 维护count
                String in = ss.substring(right,right + lenword);
                hash2.put(in,hash2.getOrDefault(in,0)+1);
                if(hash2.get(in) <= hash1.getOrDefault(in,0)) count++;
                // 判断
                if(right - left + 1 > windows) {
                    // 出窗口 + 维护count
                    String out = ss.substring(left,left + lenword);
                    if(hash2.get(out) <= hash1.getOrDefault(out,0)) count--;
                    hash2.put(out,hash2.get(out)-1);
                    left += lenword;
                }
                // 更新结果
                if(count == words.length) ret.add(left);
            }
        }
        return ret;
    }
}
