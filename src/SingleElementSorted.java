import java.util.HashMap;
public class SingleElementSorted {
    public static void main(String[] args) {
        int nums[] = {1,1,2,2,3,4,4,5,5,6,6,7,7};
        //int target = findTarget(nums);
        //System.out.println(binarySearch(nums,target));
        System.out.println(searchSingle(nums));
        //System.out.println(xorRes(nums));
    }

    //Optimal Approach
    static int searchSingle(int nums[]){
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        if(nums[0] != nums[1]){
            return nums[0];
        }
        if(nums[n-1] != nums[n-2]){
            return nums[n-2];
        }

        int start = 0;
        int end = n-2;

        //if we looke at the array
        //before the single element, the pair starts at even index and after the
        //single element the pair starts at odd index
        //before the single element the conditions
        //for even index => mid % 2 == 0 && nums[mid] == nums[mid+1] is true
        //for odd index => mid % 2 == 1 && nums[mid] == nums[mid-1] is true
        // these conditions tells us that the single element is not occurred yet
        //so we have to move the start to the left => start = mid + 1;
        //else the conditions are false means single element is occurred and is on the right
        //so move end to right => end = mid - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                return nums[mid];
            }
            else if((mid % 2 == 0 && nums[mid] == nums[mid+1]) || (mid % 2 == 1 && nums[mid] == nums[mid-1])){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }

    static int binarySearch(int nums[], int target){
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] > target){
                end = mid - 1;
            }
            else if(nums[mid] < target){
                start = mid + 1;
            }
            else{
                return nums[mid];
            }
        }
        return -1;
    }

    static int findTarget(int nums[]){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i < nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        for(int num : nums){
            if(map.get(num) == 1){
                return num;
            }
        }

        return -1;
    }

    //third approach
    static int xorRes(int nums[]){
        int xor = 0;
        for(int num : nums){
            xor ^= num;
        }

        return xor;
    }
}
