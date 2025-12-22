import java.util.ArrayList;
import java.util.List;

public class Solution {
    int[] ret; // 记录的是对应元素的逆序对的个数
    int[] index; // 建立nums数组映射下标关系 记录的是nums的原始下标

    // 以下是辅助数组 用来更新nums与它对应的原始下标的位置 让index始终跟着元素走
    // index能正确映射nums对应元素的原始下标后，即可记录ret数组找到正确的下标，更新逆序对的个数
    // nums -> index -> ret[index]
    int[] tmpNums;
    int[] tmpIndex;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        ret = new int[n];
        index = new int[n];
        tmpNums = new int[n];
        tmpIndex = new int[n];
        for (int i = 0; i < n; i++)
            index[i] = i;
        mergeSort(nums, 0, n - 1);
        List<Integer> list = new ArrayList<>();
        for (int x : ret)
            list.add(x);
        return list;
    }

    public void mergeSort(int[] nums, int left, int right) {
        // 判断中止条件
        if (left >= right) return;

        // 取中间数
        int mid = (left + right) / 2;

        // 遍历两边数组
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        // 分类讨论(这里是降序数组)
        int cur1 = left, cur2 = mid + 1,i = 0;
        while (cur1 <= mid && cur2 <= right) {
            if (nums[cur1] <= nums[cur2]) {
                tmpNums[i] = nums[cur2];
                tmpIndex[i++] = index[cur2++];
            } else {
                ret[index[cur1]] += right - cur2 + 1;// 最重要 ——（index[cur1] 定位ret的原始下标）
                tmpNums[i] = nums[cur1];
                tmpIndex[i++] = index[cur1++];
            }
        }

        // 处理未遍历完的数组
        while (cur1 <= mid) {
            tmpNums[i] = nums[cur1];
            tmpIndex[i++] = index[cur1++];
        }
        while (cur2 <= right) {
            tmpNums[i] = nums[cur2];
            tmpIndex[i++] = index[cur2++];
        }

        // 遍历
        for (int j = left; j <= right; j++) {
            nums[j] = tmpNums[j - left];
            index[j] = tmpIndex[j - left]; // 让原始下标跟着元素走 这样就能一一对应上
        }
    }
}
