public class Solution {
    int ret = 0;
    int[] tmpNum;
    public int reversePairs(int[] nums) {
        int n = nums.length;
        tmpNum = new int[n];
        mergeSort(nums, 0, n - 1);
        return ret;
    }

    public void mergeSort(int[] nums, int left, int right) {
        // 判断结束条件
        if (left >= right) return;

        // 1. 取中间数
        int mid = (left + right) / 2;

        // 2. 递归继续往下找
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        // 先判断再合并有序数组（降序）
        // 由于寻找逆序对题目可以将寻找逆序对与合并有序数组一起结合
        // 但翻转对的条件是nums[i] > 2*nums[j] 无法与合并有序数组操作一同进行
        // 故先找翻转对，再合并数组

        // 3. 寻找翻转对(利用单调性，使用同向双指针)
        // 这里使用的是降序有序数组
        int cur1 = left, cur2 = mid + 1;
        while (cur1 <= mid && cur2 <= right) {
            if ((long)nums[cur1] > 2 *(long)nums[cur2]) {
                ret += right - cur2 + 1;
                cur1++; // 重要
                // 结束后cur2不需要重新回到mid + 1位置，因为cur2前面的数都大于cur1之前的数
                // 当cur1++后，nums[cur1]变小了，cur2前面的数肯定都大于cur1前面的数，cur2肯定还走会回来
            } else {
                cur2++;
            }
        }

        // 寻找翻转对完毕
        cur1 = left;
        cur2 = mid + 1;
        int i = 0;
        // 4. 合并有序数组（逆序）
        // 辅助数组部分
        while (cur1 <= mid && cur2 <= right) {
            if (nums[cur1] <= nums[cur2]) tmpNum[i++] = nums[cur2++];
            else tmpNum[i++] = nums[cur1++];
        }
        while (cur1 <= mid) tmpNum[i++] = nums[cur1++];
        while (cur2 <= right) tmpNum[i++] = nums[cur2++];

        // 更新数组
        for (int j = left; j <= right; j++)
            nums[j] = tmpNum[j - left];
    }
}
