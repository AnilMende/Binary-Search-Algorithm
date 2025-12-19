public class BinarySearch {
    public static void main(String[] args) {

        int arr[] = {1,2,14,26,36,44,57,61,78};
        int target = 61;
        System.out.println(binarySearch(arr,target));
    }

    //return index
    //return -1 if element not found
    static int binarySearch(int arr[], int target){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            //int mid = start + end / 2;
            int mid = start + (end - start) / 2;
            if(target > arr[mid]){
                start = mid + 1;
            }
            else if(target < arr[mid]){
                end = mid - 1;
            }
            else{
                //element found
                return mid;
            }
        }
        return -1;
    }
}
