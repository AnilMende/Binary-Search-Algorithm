public class MinInRotatedSorted {
    public static void main(String[] args) {
        int nums[] = {4,5,6,7,1,2,3};
        //System.out.println(findMin(nums));
        int res = findPivot(nums);
        System.out.println("The Min Element is " + nums[res+1]);
    }

    //find Pivot and return pivotIndex + 1;
    static int findPivot(int nums[]){
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(mid < end && nums[mid] > nums[mid+1]){
                return mid;
            }
            if(mid > start && nums[mid] < nums[mid-1]){
                return mid-1;
            }
            if(nums[mid] <= nums[start]){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return -1;
    }

    static int findMin(int nums[]){
        int start = 0;
        int end = nums.length - 1;

        while(start < end){
            int mid = start + (end - start) / 2;

            if(nums[mid] > nums[end]){
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }
        return nums[start];
    }
}
