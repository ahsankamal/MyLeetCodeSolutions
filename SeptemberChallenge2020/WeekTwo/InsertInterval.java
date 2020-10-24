package WeekTwo;

import java.util.ArrayList;
//https://leetcode.com/discuss/explore/september-leetcoding-challenge/844633/Java-Insert-Intervals-Solution
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i=0;
        int start = -1;
        int end = -1;
        ArrayList<int[]> list = new ArrayList<>();

        while(i<intervals.length && newInterval[0]>intervals[i][1]){
            list.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
            start = i;
        }

        while (i<intervals.length && newInterval[1]>=intervals[i][0]){
                end = i;
                i++;
        }

        if(start<=end){
            if(start==-1 && end!=-1){
                start=0;
                list.add(new int[]{Math.min(newInterval[0], intervals[start][0]), Math.max(newInterval[1], intervals[end][1])});
            }else if(start==-1 && end==-1){
                list.add(new int[]{newInterval[0], newInterval[1]});
            }else {
                list.add(new int[]{Math.min(newInterval[0], intervals[start][0]), Math.max(newInterval[1], intervals[end][1])});
            }
        }else if(end==-1 && start<=intervals.length){
            list.add(new int[]{newInterval[0], newInterval[1]});
        }


        while (i<intervals.length){
            list.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }

        int[][] ans = new int[list.size()][2];
        for(int j=0;j<list.size();j++){
            ans[j][0] = list.get(j)[0];
            ans[j][1] = list.get(j)[1];
            System.out.print(ans[j][0]+" "+ans[j][1]+", ");
        }

        return ans;
    }

    public static void main(String[] args){
        InsertInterval ii = new InsertInterval();
//        System.out.println(ii.insert(new int[][]{{1,2}, {3,5}, {6,7}, {8,10}, {12,16}}, new int[]{4,8}));
//        System.out.println(ii.insert(new int[][]{{1,2}, {3,5}, {6,7}, {8,10}, {12,16}}, new int[]{17,18}));
        System.out.println(ii.insert(new int[][]{ {3,5},  {12,15}}, new int[]{6,6}));
    }
}


// if(intervals.length>0 && newInterval[0]<intervals[0][0]){
//            while (i<intervals.length){
//                if((newInterval[1]>=intervals[i][0] && newInterval[1]<=intervals[i][1])){
//                    break;
//                }else if(newInterval[1]<intervals[i][0] ){
//                    i--;
//                    break;
//                }
//                i++;
//            }
//            if(i==intervals.length){
//                list.add(new int[]{newInterval[0], newInterval[1]});
//            }else{
//                list.add(new int[]{newInterval[0], intervals[i][1]});
//                i++;
//                while (i<intervals.length){
//                    list.add(new int[]{intervals[i][0], intervals[i][1]});
//                    i++;
//                }
//            }
//        }
//
//
//        while (i<intervals.length){
//            if(newInterval[0]>=intervals[i][0] && newInterval[0]<=intervals[i][1]){
//                start=i;
//                break;
//            }
//            list.add(new int[]{intervals[i][0], intervals[i][1]});
//            i++;
//        }
//
//        while (i<intervals.length){
//            if(newInterval[1]>=intervals[i][0] && newInterval[1]<=intervals[i][1]){
//                end=i;
//                break;
//            }
//            i++;
//        }
//
//
//        if(start!=-1){
//            if(end !=-1){
//                list.add(new int[]{intervals[start][0], Math.max(intervals[end][1], newInterval[1])});
//                i++;
//                while(i<intervals.length){
//                    list.add(new int[]{intervals[i][0], intervals[i][1]});
//                    i++;
//                }
//            }else{
//                list.add(new int[]{intervals[start][0], newInterval[1]});
//            }
//        }else{
//            if(end==-1){
//                list.add(new int[]{newInterval[0], newInterval[1]});
//            }
//        }