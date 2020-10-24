package WeekThree;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] arr = new int[1001];
        for(int i=0; i<trips.length;i++){
            arr[trips[i][1]]+=trips[i][0];
            arr[trips[i][2]]+=-trips[i][0];
        }
        for(int i=1;i<arr.length;i++){
            arr[i]+=arr[i-1];
            if(capacity<arr[i]){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args){
        CarPooling carPooling = new CarPooling();
        System.out.println(carPooling.carPooling(new int[][]{{3,2,7}, {3,7,9}, {8,3,9}}, 11));
        System.out.println(carPooling.carPooling(new int[][]{{2,1,5}, {3,3,7}}, 5));
        System.out.println(carPooling.carPooling(new int[][]{{2,1,5}, {3,5,7}}, 3));
        System.out.println(carPooling.carPooling(new int[][]{{2,1,5}, {3,3,7}}, 4));
    }

}
