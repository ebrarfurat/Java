public class BinarySearch{
    public static int binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid -1;
            }
        }

        return - 1;
    }

    public static void main(String[] args){
        int[] sortedArray = {1, 2, 3, 4, 5 ,6 ,7 ,8, 9, 10};
        int targetValue = 7;

        int result = binarySearch(sortedArray, targetValue);


        if(result != -1){
            System.out.println("Target found at index: " + result);
        }
        else{
            System.out.println("Target not found in the array.");
        }
    }
}