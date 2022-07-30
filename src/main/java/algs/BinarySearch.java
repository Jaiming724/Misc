package algs;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target, int min, int max) {
        for (int i = min; i <max; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("The middle is "+((max - min) / 2)+" "+arr[(max - min) / 2]);
        if (max - min <= 1) {
            if (arr[max] == target) {
                return max;
            } else if (arr[min] == target) {
                return min;
            } else {
                return -1;
            }
        } else {
            int mid = (max - min) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                return binarySearch(arr, target, min, mid - 1);
            } else {
                return binarySearch(arr, target, mid + 1, max);
            }
        }


    }
}
