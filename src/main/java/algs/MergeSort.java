package algs;

public class MergeSort {

    public static int[] mergeSort(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return arr;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = arr[i];
        }
        int[] arrOne = mergeSort(l);
        int[] arrTwo = mergeSort(r);
        return merge(arrOne, arrTwo);
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] newArr = new int[arr1.length + arr2.length];
        int index = 0;
        int pointer1 = 0;
        int pointer2 = 0;
        while (pointer1 < arr1.length && pointer2 < arr2.length) {
            if (arr1[pointer1] < arr2[pointer2]) {
                newArr[index] = arr1[pointer1];
                index++;
                pointer1++;
            } else if (arr1[pointer1] > arr2[pointer2]) {
                newArr[index] = arr2[pointer2];
                index++;
                pointer2++;
            } else {
                newArr[index] = arr1[pointer1];
                index++;
                newArr[index] = arr2[pointer2];
                index++;
                pointer1++;
                pointer2++;
            }
            System.out.println("Pointer1: " + pointer1);
            System.out.println("Pointer2: " + pointer2);
        }
        for (int i = pointer1; i < arr1.length; i++) {
            newArr[index] = arr1[i];
            index++;
        }
        for (int i = pointer2; i < arr2.length; i++) {
            newArr[index] = arr2[i];
            index++;
        }

        return newArr;
    }


}


