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

    public int[][] matrixBlockSum2(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        // 准备二维前缀和
        int[][] dp = new int[m + 1][n + 1];
        // 注意dp二维数组的下标位置 <=
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        // 使用前缀和数组
        int[][] answer = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int ret = 0;
                // 确定下标 answer 与 dp 坐标的映射关系
                int x1 = Math.max(0, i - k) + 1, y1 = Math.max(0, j - k) + 1;
                int x2 = Math.min(m - 1, i + k) + 1, y2 = Math.min(n - 1, j + k) + 1;
                ret = dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1];
                answer[i][j] = ret;
            }
        }
        return answer;
    }
}
