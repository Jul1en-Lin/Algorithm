import java.util.Arrays;

public class Demo1 {
    public static int maxArea(int[] height) {
        //双指针 单调性
        int left = 0,right = height.length -1 ,ret = 0;
        while(left < right) {
            int v = Math.min(height[left],height[right]) * (right - left);
            ret = Math.max(v,ret);
            if(height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public int triangleNumber(int[] nums) {
        //单调性双指针
        if(nums.length <= 2)
            return 0;
        //优化：排序
        Arrays.sort(nums);
        int count = 0;
        //固定最大的数c
        for(int i = nums.length-1;i >= 0;i--) {
            int c = nums[i];
            //双指针
            int left = 0,right = i-1;
            //利用单调性
            while(left < right) {
                if(nums[left] + nums[right] > c) {
                    count += (right - left);
                    right--;
                }else{
                    left++;
                }
            }
        }
        return count;
    }
    public int triangleNumber2(int[] nums) {
        //暴力枚举
        Arrays.sort(nums);
        if(nums.length <= 2) return 0;
        int count = 0;
        for (int i = 0;i < nums.length;i++) {
            for(int j = i + 1;j < nums.length;j++) {
                for(int k = j + 1;k < nums.length;k++) {
                    if(check(nums[i], nums[j], nums[k]))
                        count++;
                }
            }
        }
        return count;
    }
    public boolean check(int i,int j,int k) {
        return i + j > k;
    }
}
