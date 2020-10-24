package WeekFour;

public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {

        int poison_end_time=0;
        int poisonedDuration = 0;
        for(int i=0;i<timeSeries.length;i++){
            if(timeSeries[i]>poison_end_time){
                poisonedDuration+=duration;
                poison_end_time=timeSeries[i]+duration;
            }else{
                poisonedDuration+=timeSeries[i]+duration-poison_end_time;
                poison_end_time=timeSeries[i]+duration;
            }
        }
        return poisonedDuration;
    }
    public static void main(String[] args){
        TeemoAttacking t = new TeemoAttacking();
        System.out.println(t.findPoisonedDuration(new int[]{1,4}, 2));
        System.out.println(t.findPoisonedDuration(new int[]{1,2,3}, 2));
    }
}
