package WeekOne;

import java.util.ArrayDeque;

public class LargetTimeForGivenDigits {

    public ArrayDeque<Integer>  buildLargestTimeFromDigitsHelper(int[] A, int[] digits, ArrayDeque<Integer> arrayDeque, int n){
        for(int i=n;i>=0;i--){
            if(digits[i]>0){
                arrayDeque.push(i);
                digits[i]--;
                buildLargestTimeFromDigits(A, digits, arrayDeque);
                if(arrayDeque.size()==4){
                    return arrayDeque;
                }
                digits[arrayDeque.pop()]++;
            }
        }
        return arrayDeque;
    }
    public ArrayDeque buildLargestTimeFromDigits(int[] A, int[] digits, ArrayDeque<Integer> arrayDeque){

//        System.out.println(str.toString());
        if(arrayDeque.size()==0){
            buildLargestTimeFromDigitsHelper(A, digits, arrayDeque, 2);
        }else if(arrayDeque.size()==1){
            if(arrayDeque.getFirst()==2){
                buildLargestTimeFromDigitsHelper(A, digits, arrayDeque, 3);
            }else{
                buildLargestTimeFromDigitsHelper(A, digits, arrayDeque, 9);
            }
        }else if(arrayDeque.size()==2){
            buildLargestTimeFromDigitsHelper(A, digits, arrayDeque, 5);
        }else if(arrayDeque.size()==3){
            buildLargestTimeFromDigitsHelper(A, digits, arrayDeque, 9);
        }

        return  arrayDeque;
    }

    public String largestTimeFromDigits(int[] A) {

        int[] digits = new int[10];
        for(int i=0;i<digits.length;i++){
            digits[i]=0;
        }


        for(int i=0;i<A.length;i++){
            if(A[i]>=0 && A[i]<=9){
                digits[A[i]]++;
            }else{
                return "";
            }
        }


        ArrayDeque arrayDeque = new ArrayDeque<>();
        arrayDeque = buildLargestTimeFromDigits(A, digits, arrayDeque);

        StringBuilder str = new StringBuilder();
        while (arrayDeque.size()>0){
           if(str.length()==2) {
               str.append(":");
           }
           str.append(arrayDeque.removeLast());
        }

        return str.toString();
    }

    public static void main(String[] args){
        LargetTimeForGivenDigits largetTimeForGivenDigits = new LargetTimeForGivenDigits();
        System.out.println(largetTimeForGivenDigits.largestTimeFromDigits(new int[]{1,2,3,4}));
        System.out.println(largetTimeForGivenDigits.largestTimeFromDigits(new int[]{2,0,6,6}));
        System.out.println(largetTimeForGivenDigits.largestTimeFromDigits(new int[]{0,1,9,4}));
        System.out.println(largetTimeForGivenDigits.largestTimeFromDigits(new int[]{2,9,5,3}));
        System.out.println(largetTimeForGivenDigits.largestTimeFromDigits(new int[]{0,4,0,0}));
    }
}
