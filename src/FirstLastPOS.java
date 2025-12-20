import java.util.Arrays;

public class FirstLastPOS {
    public static void main(String[] args) {
        int arr[] = {5,7,7,7,7,8,8,10};
        int target = 7;
        int res[] = FindPos(arr,target);
        System.out.println(Arrays.toString(res));
        //for(int i=0;i < res.length;i++){
        //    System.out.print(Arrays.toString(res));
        //}
    }

    static int[] FindPos(int arr[],int target){

        int ans [] = {-1,-1};
        ans[0] = search(arr,target,true);
        //only find the end value if there is a starting occurence
        if(ans[0] != -1){
            ans[1] = search(arr,target,false);
        }
        return ans;
    }

    static int search(int arr[], int target, boolean findStartIndex){
        int ans = -1;

        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(target > arr[mid]){
                start = mid + 1;
            }
            else if(target < arr[mid]){
                end = mid - 1;
            }
            else{
                //upto here we will get the position of the target
                // we dont know whether is first or last or any other
                //to find first occurence move left from the pos we found
                // to find last occurence move right from the pos we found
                ans = mid;
                if(findStartIndex){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}
