import java.util.Arrays;

public class Test {
    /**
     * 移动零（双指针快排）
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int dest = -1;
        int cur = dest+1;
        for ( ; cur < nums.length;cur++) {
            if(nums[cur] != 0){
                swap(nums,dest+1,cur);
                dest++;
            }
        }
    }
    private void swap(int[] nums,int i,int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void duplicateZeros(int[] arr) {
        //1.确定 cur 位置
        int cur = 0;
        int dest = -1;
        while (dest < arr.length-1) {
            if (arr[cur] != 0) {
                dest++;
            }else {
                dest += 2;
                //处理dest超出边界情况
                if (dest == arr.length) {
                    //arr = Arrays.copyOf(arr, (int) (arr.length * 1.5));
                    arr[dest-1] = 0;
                    dest -= 2;
                    cur--;
                    break;
                }
            }
            if (dest != arr.length-1) {
                cur++;
            }

        }
        //2.”从后往前进行复写“
        while (dest != -1) {
            if (arr[cur] != 0) {
                arr[dest] = arr[cur];
                dest--;
            }else {
                arr[dest] = 0;
                arr[dest-1] = 0;
                dest -= 2;
            }
            cur--;
        }
    }

    public static void main(String[] args) {
        int[] tmp = {1,0,2,3,0,4};
        duplicateZeros(tmp);
        for (int i = 0; i < tmp.length; i++) {
            System.out.print(tmp[i]);
        }
    }
}
