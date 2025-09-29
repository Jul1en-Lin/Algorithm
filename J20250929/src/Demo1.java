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


}
