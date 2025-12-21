public class RBS {
    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        //int arr[] = {1,3,4,5,6,2};
        int target = 0;

        //System.out.println(findPivot(arr));
        System.out.println(search(arr,target));
    }

    //for searching the element in the array
    static int search(int arr[], int target){
        int pivot = findPivot(arr);

        //if you did not found the pivot means the array is not rotated
        //so we can appy normal binary search
        if(pivot == -1){
            return binarySearch(arr,target,0,arr.length-1);
        }

        //if pivot is found, you have 2 asc sorted arrays
        if(arr[pivot] == target){
            return pivot;
        }

        if(target >= arr[0]){
            return binarySearch(arr,target,0,pivot-1);
        }
        //if(target < arr[0])
        return binarySearch(arr,target,pivot+1,arr.length-1);
    }

    //we get the start and end using pivot
    static int binarySearch(int arr[], int target, int start, int end){

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(target < arr[mid]){
                end = mid - 1;
            }
            else if(target > arr[mid]){
                start = mid + 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }

    //finding pivot
    static int findPivot(int arr[]){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            //case i
            //mid < end to prevent the index outofbound error
            //to prevent mid+1 to become arr.length+1
            if(mid < end && arr[mid] > arr[mid+1]){
                return mid;
            }
            //case ii
            //mid > start because to prevent mid - 1 to become -1 if mid is 0
            if(mid > start && arr[mid] < arr[mid-1]){
                return mid-1;
            }

            //case iii
            //arr[start] >= arr[mid], the elements after mid to end are less than start
            //so no need to check all of them
            //the pivot lies in the range of start to mid, make end = mid - 1;
            if(arr[mid] <= arr[start]){
                end = mid - 1;
            }else{
                //case iv : arr[start] < arr[mid], elements are increasing
                //mid is not the pivot, if it is pivot it may be caught in case i and ii
                //we need to minimize the search space, so ignore the element from start to mid
                //start = mid + 1 because all other elements before mid are less than mid, the array is sorted
                //from start to mid
                start = mid + 1;
            }
        }

        return -1;
    }
}
