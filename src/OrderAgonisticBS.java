public class OrderAgonisticBS {
    public static void main(String[] args) {

        int arr[] = {-19,-9,0,2,12,31,37,43,49,51,69};
        int target = 12;
        System.out.println(orderAgonistic(arr,target));
    }

    static int orderAgonistic(int arr[], int target){
        int start = 0;
        int end = arr.length - 1;

        //find whether the array is sorted in ascendin or descending
        boolean isAsc;
        if(arr[start] < arr[end]){
            //array is in ascending order
            isAsc = true;
        }
        else{
            //array is in descending order
            isAsc = false;
        }

        while(start <= end){

            int mid = start + (end - start) / 2;

            if(target == arr[mid]){
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
