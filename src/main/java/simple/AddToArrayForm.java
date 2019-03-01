package simple;

import java.util.ArrayList;
import java.util.List;

// got problem
public class AddToArrayForm {

    public static void main(String[] args){
        AddToArrayForm test = new AddToArrayForm();
        int[] A = {1,2,6,3,0,7,1,7,1,9,7,5,6,6,4,4,0,0,6,3};
        System.out.println(test.addToArrayForm(A,516));
    }

    public List<Integer> addToArrayForm(int[] A, int K) {

        List<Integer> result = new ArrayList<Integer>();

        int length = A.length;
        long AInt = 0;
        int times = length - 1;


        for (int i = 0; i < length; i++){
            AInt += A[i]*(Math.pow(10, times));
            --times;
        }

        long resultInt = AInt + K;
        String resultString = String.valueOf(resultInt);

        for (int i = 0; i < resultString.length(); i++){
            result.add(Integer.valueOf(String.valueOf(resultString.charAt(i))));
        }

        return result;
    }

}
