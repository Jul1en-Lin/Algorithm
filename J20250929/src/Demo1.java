import java.util.*;

public class Demo1 {
    // 暴力枚举
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> hash1 = new HashMap<>();
        for(char chars : p.toCharArray()) {
            hash1.put(chars,hash1.getOrDefault(chars,0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for(int left = 0;left < s.length(); left++) {
            Map<Character,Integer> hash2 = new HashMap<>();
            for(int right = left;right < s.length();) {
                int count = p.length();
                while(count != 0) {
                    char ch = s.charAt(right++);
                    hash2.put(ch,hash2.getOrDefault(ch,0)+1);
                    count--;
                }
            }
            if(hash1.equals(hash2)) list.add(left);
        }
        return list;
    }

    // 滑动窗口
    public List<Integer> findAnagrams2(String s, String p) {
        int lenp = p.length(),lens = s.length();
        Map<Character,Integer> hashp = new HashMap<>();
        Map<Character,Integer> hashs = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(char ch : p.toCharArray()) {
            hashp.put(ch,hashp.getOrDefault(ch,0)+1);
        }
        for(int left = 0,right = 0; right < lens; right++) {
            // 进窗口
            char ch = s.charAt(right);
            hashs.put(ch,hashs.getOrDefault(ch,0)+1);
            // 判断
            while((right - left + 1) > lenp) {
                char chs = s.charAt(left++);
                hashs.put(chs,hashs.get(chs)-1); // 出窗口
                if(hashs.get(chs) == 0) {
                    hashs.remove(chs);
                }
            }
            // 更新结果
            if((right - left + 1) == lenp && hashs.equals(hashp)) list.add(left);
        }
        return list;
    }

    // 优化：数组当哈希表
    public List<Integer> findAnagrams3(String s, String p) {
        int[] hash1 = new int[26],hash2 = new int[26];
        for(char chars : p.toCharArray()) {
            hash1[chars-97]++;
        }
        int lens = s.length(),lenp = p.length();
        List<Integer> list = new ArrayList<>();

        for(int left = 0,right = 0; right < lens; right++) {
            boolean flg = true;
            // 进窗口
            char in = s.charAt(right);
            hash2[in-97]++;
            // 判断
            if(right - left + 1 > lenp) {
                char out = s.charAt(left++);// 出窗口
                hash2[out-97]--;
            }
            // 更新结果
            for(int i = 0;i < hash1.length;i++) {
                if(hash1[i] != hash2[i]) {
                    flg = false;
                    break;
                }
            }
            if(flg) list.add(left);
        }
        return list;
    }
    // 用count统计“有效字符的个数”，更新结果时就不用遍历比较两哈希表
    public List<Integer> findAnagrams4(String s, String p) {
        int[] hash1 = new int[26],hash2 = new int[26];
        for(char chars : p.toCharArray()) {
            hash1[chars-'a']++;
        }
        int lens = s.length(),lenp = p.length();
        List<Integer> list = new ArrayList<>();
        int count = 0;// 统计有效字符个数
        for(int left = 0,right = 0; right < lens; right++) {
            char in = s.charAt(right);
            hash2[in-'a']++;
            if(hash2[in-'a'] <= hash1[in-'a']) count++; // 进窗口 + 维护count
            // 判断
            if(right - left + 1 > lenp) {
                char out = s.charAt(left++);
                if(hash2[out-'a'] <= hash1[out-'a']) count--;
                hash2[out-'a']--;// 出窗口 + 维护count
            }
            // 更新结果
            if(count == lenp) list.add(left);
        }
        return list;
    }
}
