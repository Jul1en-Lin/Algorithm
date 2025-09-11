import java.util.*;

public class Demo1 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        for(int i = nums.length-1;i >= 0;i--) {
            if(i < nums.length-1 && nums[i] == nums[i+1]) continue;
            int left = 0,right = i-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    ret.add(Arrays.asList(nums[left],nums[right],nums[i]));
                    while(left < right && nums[left] == nums[left-1]) left++;
                    while(left < right && nums[right] == nums[right+1]) right--;
                }else if(sum > 0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return ret;
    }
}
