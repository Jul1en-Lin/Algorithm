import java.util.HashSet;
import java.util.Set;

public class Demo1 {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0,right;
        int len = 0;

        for(right = 0;right < n;) {
            right = left+1;
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(left));

            while(right < n && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                len = Math.max(len,right-left+1);
                right++;
            }
            left++;
        }
        return len;
    }

    //滑动窗口
    public static int lengthOfLongestSubstring1(String s) {
        int left = 0,right = 0,n = s.length();
        int len = 0;
        char[] ss = s.toCharArray();
        int[] hash = new int[128];//用数组模拟哈希表

        while(right < n) {
            hash[ss[right]]++;//进窗口
            //判断
            while(hash[ss[right]] > 1) {
                hash[ss[left++]]--;//出窗口
            }
            //更新结果
            len = Math.max(len,right-left+1);
            right++;//让下一个字符进入窗口
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
