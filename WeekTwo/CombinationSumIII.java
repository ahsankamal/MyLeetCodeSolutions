package WeekTwo;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    public static List<List<Integer>> dfsBacktrack(List<List<Integer>> ans, ArrayList<Integer> list, int k, int n, int next,  int sumSoFar){

        if(list.size()==k){
            if(sumSoFar==n){
                ans.add(new ArrayList<>(list));
            }
            return ans;
        }

        for(int i=next; i<=9;i++){

            if(sumSoFar+i<=n){
                list.add(i);
                //next no should be greater than previous no included
                dfsBacktrack(ans, list, k, n, i+1, sumSoFar+i);
                list.remove(list.size()-1);
            }
        }
        return ans;

    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        return CombinationSumIII.dfsBacktrack(new ArrayList<>(), new ArrayList<>(), k ,n, 1, 0);
    }

    public static void main(String[] args){
        CombinationSumIII combinationSumIII = new CombinationSumIII();
        System.out.println(combinationSumIII.combinationSum3(4, 15));
    }
}
