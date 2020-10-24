package WeekOne;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        LinkedHashMap<Character, ArrayList<Integer>> lhm = new LinkedHashMap<>();

        for(int i=0; i<S.length(); i++){
            if(lhm.get(S.charAt(i))!=null){
                lhm.get(S.charAt(i)).set(1, i);
            }else{
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(i);
                arr.add(i);
                lhm.put(S.charAt(i), arr);
            }
        }

        lhm.forEach((k, v)->System.out.println(k+" "+v));
        ArrayList<Integer> partition = new ArrayList<>();
        int start = -1;
        int end = -1;
        for(ArrayList<Integer> v: lhm.values()){
            if(start==-1){
                start = v.get(0);
                end = v.get(1);
            }else if(v.get(0)>start && v.get(1)>end){
                end = v.get(1);
            }else if(v.get(0)>end){
                partition.add(end-start+1);
                start = v.get(0);
                end = v.get(1);
            }
        }

        return partition;
    }


}
