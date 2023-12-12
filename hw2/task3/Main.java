package task3;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
  
        int shiftNum = 5;
        for (int i = 0; i < shiftNum; i++) {
            arr = shfirArr(arr);
        }
        System.out.println(Arrays.toString(arr));
    }

    private static int[] shfirArr(int[] arr) {
        int tmp1 = arr[arr.length-1];
        int tmp2 = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) 
            {
                arr[i] = tmp1;
            } 
            else 
            {
                tmp2 = arr[i];
                arr[i] = tmp1;
                tmp1 = tmp2;
                tmp2 = arr[i + 1];
            }
        }
        return arr;
    }
}