import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minNumberOfFrogs1(String c) {
        String t = "croak";
        int[] hash = new int[5];
        char[] croakOfFrogs = c.toCharArray();
        int len = c.length();

        // 不用Map来记录下标
        for (char ch : croakOfFrogs) {
            int index = t.indexOf(ch);
            // 'c'
            if (index == 0) {
                if (hash[4] != 0) hash[4] --;
                hash[0]++;
            } else {
                // 非'c'
                if (hash[index - 1] == 0) return -1;
                hash[index - 1]--;
                hash[index]++;
            }
        }
        for (int i = 0; i <= 3; i++) {
            if (hash[i] != 0) return -1;
        }
        return hash[4];
    }

    public int minNumberOfFrogs2(String c) {
        if (c.length() % 5 != 0) return -1;
        String t = "croak";
        int n = t.length();
        char[] croakOfFrogs = c.toCharArray();
        int[] hash = new int[5]; // int数组模拟哈希表

        // 通过字符映射下标的方式记录在Map
        Map<Character, Integer> index = new HashMap<>();

        for (int i = 0; i < n; i++)
            index.put(t.charAt(i), i); // [x, x所在的下标]

        for (char ch : croakOfFrogs) {
            // 'c'
            if (ch == t.charAt(0)) {
                // 判断 'k' 是否有青蛙读完，读完可以k - 1
                if (hash[n - 1] != 0) hash[n - 1]--;
                hash[0]++;
            }
            // 非 'c'
            else {
                if (hash[index.get(ch) - 1] == 0) return -1;
                hash[index.get(ch) - 1]--;
                hash[index.get(ch)]++;
            }
        }
        // 判断剩余是否有未读完的
        for (int i = 0; i < n - 1; i++)
            if (hash[i] != 0) return -1;
        return hash[n - 1];
    }

    public int minNumberOfFrogs3(String croakOfFrogs) {
        if (croakOfFrogs.length() % 5 != 0) return -1;

        // 哈希表
        char[] hash = new char[97];
        char[] cs = croakOfFrogs.toCharArray();
        for (char ch : cs) {
            switch(ch) {
                case 'c':
                    if (hash['k' - 97] != 0) {
                        hash['k' - 97]--;
                        hash['c' - 97]++;
                    }else{
                        hash['c' - 97]++;
                    }
                    break;
                case 'r':
                    if (hash['c' - 97] == 0) return -1;
                    else {
                        hash['c' - 97]--;
                        hash['r' - 97]++;
                    }
                    break;
                case 'o':
                    if (hash['r' - 97] == 0) return -1;
                    else {
                        hash['r' - 97]--;
                        hash['o' - 97]++;
                    }
                    break;
                case 'a':
                    if (hash['o' - 97] == 0) return -1;
                    else {
                        hash['o' - 97]--;
                        hash['a' - 97]++;
                    }
                    break;
                case 'k':
                    if (hash['a' - 97] == 0) return -1;
                    else {
                        hash['a' - 97]--;
                        hash['k' - 97]++;
                    }
                    break;
            }
        }
        for (int i = 0; i < hash.length; i++) {
            if (i != 'k' - 97)
                if (hash[i] != 0)
                    return -1;
        }

        return hash['k' - 97];
    }
}
