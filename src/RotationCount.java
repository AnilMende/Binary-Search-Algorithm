public class RotationCount {
    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2,3};
        int nums[] = {2,9,2,2,2};

        System.out.println("The rotation count is " + countRotations(arr));
        System.out.println("The rotation count is " + countRotations(nums));
    }

    static int countRotations(int arr[]){
        int pivot = findPivot(arr);
        int pivot1 = findingPivotWithDuplicates(arr);
        //return pivot+1;
        return pivot1 + 1;
    }

    //finding pivot for non duplicates
    static int findPivot(int arr[]){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] > arr[mid+1]){
                return mid;
            }
            if(arr[mid] < arr[mid-1]){
                return mid-1;
            }
            //case iii. start > mid then all the elements after mid are less than start so move
            //left for pivot
            if(arr[mid] <= arr[start]){
                end = mid - 1;
            }
            else{
                //case iv. start < mid, then the left is in ascending order the pivot will be on right
                //move the start to right
                start = mid + 1;
            }
        }
        return -1;
    }

    //finding pivot, if duplicate elements are present
    static int findingPivotWithDuplicates(int arr[]){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(arr[mid] > arr[mid+1]){
                return mid;
            }
            if(arr[mid] < arr[mid-1]){
                return mid-1;
            }
            //if start,mid,end all these are equal(means duplicates)
            if(arr[mid] == arr[start] && arr[mid] == arr[end]){
                //there may chance if start or end are pivot

                //checking if the start is pivot
                if(arr[start] > arr[start+1]){
                    return start;
                }
                //moving left by ignoring duplicate
                start++;

                //checking if the end is pivot
                if(arr[end] < arr[end-1]){
                    return end-1;
                }
                //moving right by ignoring duplicates
                end--;
            }
            //left is sorted we have to move right
            else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])){
                start = mid + 1;
            }
            else{
                //right is sorted we have to move left
                end = mid - 1;
            }
        }
        return -1;
    }
}
