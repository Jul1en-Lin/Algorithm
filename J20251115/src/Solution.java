public class Solution {
    public static String convert1(String s, int numRows) {
        // 矩阵
        // 处理特殊情况
        if (numRows == 1) return s;

        // 找公差d
        int d = (2 * numRows) - 2;
        int len = s.length();
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            boolean flg = true;
            int j = i;
            // 处理顶行与最底行
            if (i == 0 || i == numRows - 1) {
                while (j < len) {
                    ret.append(s.charAt(j));
                    j += d;
                }
                flg = false;
            }
            // 处理中间行
            if (flg) {
                int k = 0;
                while ((j + k * d) < len) {
                    ret.append(s.charAt(j + k * d));
                    if ((d - j + k * d) < len) ret.append(s.charAt(d - j + k * d));
                    k++;
                }
            }
        }
        return ret.toString();
    }

    public static String convert2(String s, int numRows) {
        // 矩阵 找规律
        // 处理特殊情况 如果 i 为 1 时 d = 0,会死循环
        if (numRows == 1) return s;

        // 找公差d
        int d = (2 * numRows) - 2;
        int len = s.length();
        StringBuilder ret = new StringBuilder();

        // 处理第一行
        for (int i = 0; i < len; i += d)
            ret.append(s.charAt(i));

        // 处理中间行
        for (int i = 1; i < numRows - 1; i++) {
            for (int k = i,j = d - i; k < len || j < len; k += d,j += d) {
                // 进来的时候可能会越界
                if (k < len) ret.append(s.charAt(k));
                if (j < len) ret.append(s.charAt(j));
            }
        }
        // 处理最后一行
        for (int i = numRows - 1; i < len; i += d)
            ret.append(s.charAt(i));

        return ret.toString();
    }


    public static String convert(String s, int numRows) {
        // 矩阵
        int len = s.length();
        char[][] arr = new char[numRows][len];
        int x = 0, y = 0;

        // 赋值矩阵
        for (int i = 0; i < len; ) {
            while (x < numRows) {
                if (i < len) arr[x++][y] = s.charAt(i++);
                else break;
            }
            x--;
            while (x != 0) {
                if (i < len) arr[--x][++y] = s.charAt(i++);
                else break;
            }
            x++;
        }

        // 遍历矩阵 初始化x,y
        StringBuilder ret = new StringBuilder();
        for (x = 0; x < numRows; x++) {
            for (y = 0; y < len; y++) {
                char ch = arr[x][y];
                // 或者 ch != 0
                if (ch != '\u0000')
                    ret.append(arr[x][y]);
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }

}
