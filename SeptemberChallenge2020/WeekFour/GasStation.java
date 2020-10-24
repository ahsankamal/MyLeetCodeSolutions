package WeekFour;
//https://leetcode.com/discuss/explore/september-leetcoding-challenge/860985/Java-or-Easy-or-1-Pass-or-O(N)-or-Beats-100-submissions
//https://leetcode.com/discuss/explore/september-leetcoding-challenge/860480/Gas-Station-oror-python-oror-o(n)-simple-explanation
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalFuelLeft = 0;
        int start = 0;


        for(int i=0;i<gas.length;i++){
            if(gas[i]+totalFuelLeft<cost[i]){
                start=i+1;
                totalFuelLeft=0;
            }else{
                totalFuelLeft = totalFuelLeft+gas[i]-cost[i];
            }
        }

//        System.out.println(totalFuelLeft+ " "+start);
        if(start==gas.length){
            return -1;
        }

        int totalFuelAvailable = 0;
        for(int i=0;i<gas.length;i++){
            int curInd = (start+i)%gas.length;
            if(gas[curInd]+totalFuelAvailable<cost[curInd]){
                return -1;
            }else{
                totalFuelAvailable = totalFuelAvailable+gas[curInd]-cost[curInd];
            }
        }

        return start;
    }

    public static void main(String[] args){
        GasStation g = new GasStation();
        System.out.println(g.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
        System.out.println(g.canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,1}));
    }
}
