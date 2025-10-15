import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // 读入数组
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(),q = scanner.nextInt();
        int[] arr = new int[n+1];
        for(int arrs : arr) arrs = scanner.nextInt();

        // 预处理前缀和数组
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i-1] + arr[i];
        }
        // 使用前缀和数组
        while (q > 0) {
            int l = scanner.nextInt(),r = scanner.nextInt();
            System.out.println(dp[r]-dp[l-1]);
            q--;
        }
    }
}
