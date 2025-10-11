public class Solution {
    public int peakIndexInMountainArray1(int[] arr) {
        // 暴力枚举
        for(int i = 1; i < arr.length-1; i++) {
            if(arr[i] > arr[i+1]) return i;
        }
        return -1;
    }

    public int peakIndexInMountainArray2(int[] arr) {
        // 二分法
        int left = 0,right = arr.length-1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] <= arr[mid+1]) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public int peakIndexInMountainArray3(int[] arr) {
        // 二分法
        int left = 0,right = arr.length-1;
        while(left < right) {
            int mid = left + (right - left + 1) / 2;
            if(arr[mid] > arr[mid - 1]) left = mid;
            else right = mid - 1;
        }
        return left;
    }
}
