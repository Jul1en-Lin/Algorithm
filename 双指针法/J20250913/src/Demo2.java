import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo2 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length <= 3) return null;
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;
        for (int i = 0; i < n;) {
            for (int j = i + 1; j < n;) {
                int left = j + 1,right = n - 1;
                long tmp = (long)target - (nums[i] + nums[j]);
                int sum = nums[left] + nums[right];

                if(sum < tmp) left++;
                else if(sum > tmp) right--;
                else {
                    list.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                    left++;right--;
                    while (left < right && nums[left] == nums[left-1]) left++;
                    while (left < right && nums[right] == nums[right+1]) right--;
                }
                j++;
                while(j < n && nums[j] == nums[j-1]) j++;
            }
            i++;
            while(i < n && nums[i] == nums[i-1]) i++;
        }

        return list;
    }
    public static void main(String[] args) {

    }
}
