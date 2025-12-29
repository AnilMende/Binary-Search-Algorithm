public class SearchInRotatedSorted {
    public static void main(String[] args) {
        int nums[] = {4,5,6,7,1};
        int target = 1;

        System.out.println("target found at index "+ search(nums,target));

        //Finding Min in Rotated Sorted Array
        //pivot will be largest then after the pivot will be smallest element
        //int pivot = findPivot(nums);
        //System.out.println("The Minimum element is " + nums[pivot+1]);
        int minElement = findMin(nums);
        System.out.println("Minimun Element is "+ minElement);

        //Finding Peak
        //if there are multiple peak elements it returns the last occurring peak element
        int peakElement = findPeak(nums);
        System.out.println("Peak Element is " + nums[peakElement]);
    }

    static int search(int nums[], int target){
        int pivotIndex = findPivot(nums);

        //array is not sorted do normal bs
        if(pivotIndex == -1){
            return binarySearch(nums, target, 0, nums.length-1);
        }

        //pivotIndex is the target then return pivotIndex
        if(nums[pivotIndex] == target){
            return pivotIndex;
        }
        //target is > nums[0] search on the left side in the search space of 0 to pivot-1
        if(target >= nums[0]){
            return binarySearch(nums,target,0,pivotIndex-1);
        }
        //target < nums[0] search on the right side pivot+1 to nums.length - 1;
        return binarySearch(nums,target,pivotIndex+1,nums.length-1);
    }

    static int binarySearch(int nums[], int target, int start, int end){


        while(start <= end){
            int mid = start + (end - start) / 2;

            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return -1;
    }

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
            //Min element definitely be after the pivot
            // so we have to move the start to left
            //compare the mid and end then move left
            if(nums[mid] > nums[end]){
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }
        return nums[start];
    }

    static int findPeak(int nums[]){
        int start = 0;
        int end = nums.length - 1;

        while(start < end){
            int mid = start + (end - start) / 2;
            //if a element is greater than its adjacent element then it is the peak
            if(nums[mid] > nums[mid+1]){
                end = mid;
            }
            //nums[mid] < nums[mid+1]
            //most of the times array is increasing array so move right to find
            //the peak where nums[mid] > nums[mid+1]
            else{
                start = mid + 1;
            }
        }
        return start;
    }
}
