public class Demo1 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int i = minSubArrayLen(7,nums);
        System.out.println(i);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        //滑动窗口
        int sum = 0;
        int n = nums.length;
        int left = 0,right = 0;
        int len = n;

        for (right = 0; right < n; right++) {
            sum += nums[right];
            while (sum >= target) {
                len = Math.min(len,right-left+1);
                sum -= nums[left++];
            }
        }
        if (len == n){
            return 0;
        }else return len;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int sum = 0;
        int n = nums.length,len = Integer.MAX_VALUE;//len需要不影响最小值的判断 所以不要设置0
        for(int left = 0,right = 0;right < n;right++) {
            sum += nums[right];//进窗口
            while(sum >= target) {//判断
                len = Math.min(len,right-left+1);//更新结果
                sum -= nums[left++];//出窗口
            }
        }
        return len == Integer.MAX_VALUE ? 0:len;
    }
}
