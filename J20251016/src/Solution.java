import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(),m = in.nextInt(),q = in.nextInt();
        int[][] arr = new int[n+1][m+1];
        long[][] dp = new long[n+1][m+1];
        // 读入数据
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= m; j++)
                arr[i][j] = in.nextInt();

        // 预处理前缀和矩阵
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= m; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + arr[i][j] - dp[i - 1][j - 1];
        // 使用
        while(q > 0) {
            int x1 = in.nextInt(),y1 = in.nextInt(),x2 = in.nextInt(),y2 = in.nextInt();
            System.out.println(dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1]);
            q--;
        }
    }

}
