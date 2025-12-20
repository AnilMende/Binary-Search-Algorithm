public class PeakIndex {
    public static void main(String[] args) {

        int arr[] = {1,2,3,5,6,4,3,2};
        System.out.println(peakElementIndex(arr));
    }

    static int peakElementIndex(int arr[]){
        int start = 0;
        int end = arr.length - 1;

        while(start < end){

            int mid = start + (end - start) / 2;

            if(arr[mid] > arr[mid + 1]){
                //we are in the decreasing part of the array
                //arr[mid] may be the answer but there may be other answer on the left
                //so we are moving left
                end = mid;
            }
            else{
                //arr[mid] < arr[mid+1] we are in the increasing part of array
                //so we have to move right to find the peak element
                start = mid + 1;
            }
        }

        // in the end, start == end and pointing to the largest number because of the above two checks
        //start and end always trying to find the max element in the above two checks
        //hence they are pointing to the one element then that is the max element
        //we can return start or end , because they are pointing to same element and there is only
        //one element remaining
        return start;
    }
}
