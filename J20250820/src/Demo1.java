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
}
