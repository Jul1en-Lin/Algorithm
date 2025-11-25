public class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        partition(nums, 0, n - 1);
        return nums;
    }

    public void partition(int[] nums, int l, int r) {
        // 判断中止条件
        if (l >= r) return;

        // 设定随机基准值 key不能放循环里面 否则随机值会随着元素交换而变化
        int rand = new Random().nextInt(r - l + 1) + l;// (r - l + 1) -> [0, n-1] 加上基准值l rand的下标取值范围就为[l, r]
        int key = nums[rand];// 基准值
        
        // 数组分三块 （< key 、== key 和 > key）
        int left = l - 1, right = r + 1;// 定义三个指针，i负责扫描数组元素(颜色排序)
        for (int i = l; i < right; ) {
            if (nums[i] > key) {
                // 存到右半区 且不要i++ 因为把没扫描过的值给交换了出来
                swap(nums, --right, i);
            } else if (nums[i] < key) {
                // 存到左半区 交换后直接移动i扫描下一个
                swap(nums, ++left,i++);
            } else i++; // key == nums[i] 重复元素区
        }

        // 此时有三部分 [l, left] < key  [left + 1, right - 1] == key  [right, r] > key
        // 所以只需要将 [l, left] [right, r] 这两部分进行排序即可
        partition(nums, l, left);
        partition(nums, right, r);
    }

    public void swap(int[] nums, int x, int y) {
        int swapInt = nums[x];
        nums[x] = nums[y];
        nums[y] = swapInt;
    }
    // test
}
