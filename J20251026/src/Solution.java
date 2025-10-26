public class Solution {
    public int[][] matrixBlockSum1(int[][] mat, int k) {
        // 暴力枚举
        // 确定矩阵mat的长
        int m = mat.length;
        // 宽
        int n = mat[0].length;
        // 注意边界问题
        int[][] answer = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;

                // 遍历每个周边格子 用sum统计和 注意不是九宫格！！
                // Mathmax 限制行中最左边的格子数不越界，Mathmin限制最右边
                for (int x = Math.max(0, i - k); x <= Math.min(m - 1, i + k); x++) {
                    // Mathmax限制列中最上边的格子数不越界，Mathmin限制最下边
                    for (int y = Math.max(0, j - k); y <= Math.min(n - 1, j + k); y++)
                        sum += mat[x][y];
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }
}
