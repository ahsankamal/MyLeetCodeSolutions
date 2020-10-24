package WeekThree;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {

    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> list = new ArrayList<>();

        int start = String.valueOf(low).length();
        int end = String.valueOf(high).length();

        for(int len=start; len<=end; len++){
            for(int i=1;i<=9-len+1;i++){
                StringBuilder number = new StringBuilder();
                for(int j=0;j<len;j++){
                    number.append(i+j);
                }
                int no  = Integer.parseInt(number.toString());
                if(low<=no && no<=high){
//                    System.out.println(no);
                    list.add(no);
                }
            }
        }
        return list;
    }

    public static void main(String[] args){
        SequentialDigits ss = new SequentialDigits();
        System.out.println(ss.sequentialDigits(10, 1000000000));
    }

}
