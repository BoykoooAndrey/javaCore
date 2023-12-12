import java.util.Arrays;
import java.util.Random;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        final int MINVAL = -500;
        final int MAXVAL = 1000;
        
        Random r = new Random();
        int[] arr = new int[1000];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(MINVAL, MAXVAL);
        }
        int[]minMaxVal = findMinMax(arr);
        System.err.println(Arrays.toString(arr));

        boolean needAppend = false;
        int minVal = 0;
        if (minMaxVal[0] < 0) {
            arr = removeNegative(arr, minMaxVal[0]);
            needAppend = true;
            minVal = minMaxVal[0];
            minMaxVal[0] -= minVal;
            minMaxVal[1] -= minVal;
        }
    
        int[] result = sorted(arr, minMaxVal);
        if (needAppend) {

            result = appendNegative(result, minVal);
        }
        System.err.println(Arrays.toString(result));    
    }
    
    private static int[] findMinMax(int[] arr)
    {
        int[] result = {arr[0], arr[0]};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < result[0]) {
                result[0] = arr[i];
            }
            else if(arr[i] > result[1]){
                result[1] = arr[i];
            }
        }
        System.err.println(Arrays.toString(result));
        return result;
    }

    private static int[] removeNegative(int[] arr, int minVal)
    {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] - minVal;
        }
        return arr;
    }

    public static int[] appendNegative(int[] arr, int minVal)
    {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + minVal;
        }
        return arr;
    }
    
    private static int[] sorted(int[] arr, int[] minMaxVal)
    {   
        int[]countArr = new int[minMaxVal[1] - minMaxVal[0] + 1];
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            
            countArr[arr[i] - minMaxVal[0]] = countArr[arr[i] - minMaxVal[0]] + 1;
        } 

        int counter = 0;
        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] != 0) {
                for (int j = 0; j < countArr[i]; j++) {
                    result[counter] = i;
                    counter ++;
                }
            }

        }

        return result;
    }
}