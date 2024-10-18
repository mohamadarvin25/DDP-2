public class MaxxArr {
    
    public static void main(String[] args){
    int[] arr = {101, 1,2,3,4,5,6,7,8,9,100};
    System.out.print(maxxArr(arr));
    }

    public static int max(int a, int b) {
        return (a > b)? a : b; 
    }

    public static int maxxArr(int[] arr) {
        return maxxArr(arr, 0);
    }

    public static int maxxArr(int[] arr, int curr) {
        if (curr == arr.length){
            return 0;
        }
        return max(arr[curr], maxxArr(arr, curr += 1));
    
    }
}
