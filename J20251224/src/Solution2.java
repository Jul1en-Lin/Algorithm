public class Solution2 {
    int tmpNum[];
    public int reversePairs(int[] nums) {
        int n = nums.length;
        tmpNum = new int[n];
        return mergeSort(nums, 0, n - 1);
    }

    public int mergeSort(int[] nums, int left, int right) {
        // 判断条件
        if (left >= right) return 0;
        int ret = 0;
        // 寻找中间数 [left, mid][mid + 1, right]
        int mid = (left + right) / 2;

        ret += mergeSort(nums, left, mid);
        ret += mergeSort(nums, mid + 1, right);

        // 升序版本
        int cur1 = left, cur2 = mid + 1;
        while (cur2 <= right) {
            while (cur1 <= mid && nums[cur2] >= nums[cur1] / 2.0) cur1++;
            if (cur1 > mid) break; // 优化：如果cur2 越界了证明没有符合的数，直接break
            ret += mid - cur1 + 1;
            cur2++;
        }

        // 合并数组(升序)
        cur1 = left; cur2 = mid + 1; int i = 0;
        while (cur1 <= mid && cur2 <= right)
            tmpNum[i++] = nums[cur1] < nums[cur2] ? nums[cur1++] : nums[cur2++];
        while (cur1 <= mid)
            tmpNum[i++] = nums[cur1++];
        while (cur2 <= right)
            tmpNum[i++] = nums[cur2++];

        for (int j = left; j <= right; j++)
            nums[j] = tmpNum[j - left];

        return ret;
    }
}
