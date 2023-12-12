/**
 * Main
 */
public class Main {

    
    public static void main(String[] args) {
        String alf = "abcdefwxyz";
        int step = 3;
        char[] sourceArr =  alf.toCharArray();

        for (int i = 0; i < sourceArr.length; i++) {
            if( sourceArr[i] > ((char) 'z'  - step) || (sourceArr[i] > ((char) 'Z'  - step) && sourceArr[i] < ((char) 'a'  - step)) )
            {

                sourceArr[i] = (char) (sourceArr[i] +  step - 26);
            }
            else
            {
                sourceArr[i] = (char) (sourceArr[i] + step);
            }
            
        }
        for (int i = 0; i < sourceArr.length; i++) {
            System.err.print(sourceArr[i] + " ");
        }
        
    }
}
