public class Latihan3 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        System.out.println(average(arr)); // 3.5
    }

    public static double average(int[] arr) {
        return averageRecc(arr, 0, 0);
    }

    public static double averageRecc(int[] arr, int index, int acc) {
        if (index == arr.length) {
            return (double) acc/arr.length;
    
        } else {
            acc += arr[index++];                  
    
        }
        return averageRecc(arr, index, acc);
    }
}
