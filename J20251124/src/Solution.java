public class Solution {
    public void sortColors(int[] nums) {
        // 双（三）指针 走两遍
        // 先排列红与白
        int len = nums.length;
        int red,white,blue;
        for (red = -1,white = 0; white < len; white++) {
            if (nums[white] == 0) {
                int tmp = nums[red + 1];
                nums[red + 1] = nums[white];
                nums[white] = tmp;
                red++;
            }
        }

        // 再排列白与蓝
        for (white = red,blue = white + 1; blue < len; blue++) {
            if (nums[blue] == 1) {
                int tmp = nums[white + 1];
                nums[white + 1] = nums[blue];
                nums[blue] = tmp;
                white++;
            }
        }
    }

    public void sortColors2(int[] nums) {
        // 三指针 left、cur、right
        // left：标记0的最右侧区域、right：标记2的最左边区域、cur：遍历元素
        // 此时分为四个部分
        // [0, left]：全是0
        // [left + 1, cur -1]：全是1
        // [cur, right -1]：未扫描区域
        // [right, n-1]：全是2

        int n = nums.length;
        int tmp;
        for (int left = -1,cur = 0,right = n; cur < right; ) {
            if (nums[cur] == 0) {
                tmp = nums[left + 1];
                nums[left + 1] = nums[cur];
                nums[cur] = tmp;
                left++;
                cur++;
            } else if (nums[cur] == 2) {
                // 此处的2交换后不能随意的cur++ 因为跟nums[cur]交换的也是未扫描的区域 cur++则会直接跳过这个区域
                tmp = nums[right - 1];
                nums[right - 1] = nums[cur];
                nums[cur] = tmp;
                right--;
            } else if (nums[cur] == 1){
                cur++;
            }
        }
    }
}
