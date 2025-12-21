public class SearchInMountain {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,3,1};
        int target = 4;

        System.out.println(search(arr,target));
    }

    //searching the target element in the array
    //with the peak index in both ascending and descending array
    static int search(int arr[], int target){
        int peak = peakIndex(arr);

        //search in first half
        int firstTry = orderAgonistic(arr,target,0,peak);
        if(firstTry != -1){
            return firstTry;
        }
        //search in second half
        return orderAgonistic(arr,target,peak+1,arr.length -1);
    }

    // to find the peak element
    static int peakIndex(int arr[]){
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            int mid = start + (end-start) / 2;

            if(arr[mid] > arr[mid+1]){
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }
        return start;
    }

    //binary search to find the target
    static int orderAgonistic(int arr[], int target, int start, int end){

        //find whether array is in ascending or descending
        boolean isAsc = arr[start] < arr[end];

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(arr[mid] == target){
                return mid;
            }

            if(isAsc){
                if(target > arr[mid]){
                    start = mid + 1;
                }
                else if(target < arr[mid]){
                    end = mid - 1;
                }
            }
            else{
                if(target > arr[mid]){
                    end = mid - 1;
                }
                else if(target < arr[mid]){
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
