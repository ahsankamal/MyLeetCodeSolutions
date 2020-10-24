package WeekThree;

public class RobotBoundedInCircle {

    enum Direction{
        EAST,
        WEST,
        NORTH,
        SOUTH
    }
    public boolean isRobotBounded(String instructions) {

        String steps = instructions+instructions+instructions+instructions;
        Direction dir = Direction.NORTH;
        int x =0;
        int y = 0;
        for(int i=0; i<steps.length();i++){
            if(steps.charAt(i)=='G'){
                switch (dir){
                    case EAST:
                        x++;
                        break;
                    case WEST:
                        x--;
                        break;
                    case NORTH:
                        y++;
                        break;
                    case SOUTH:
                        y--;
                        break;
                }
            }
            else if(steps.charAt(i)=='L'){
                if(dir==Direction.EAST){
                    dir = Direction.NORTH;
                }else if(dir==Direction.NORTH){
                    dir=Direction.WEST;
                }else if(dir==Direction.WEST){
                    dir=Direction.SOUTH;
                }else{
                    dir = Direction.EAST;
                }
            }
            else{
                if(dir==Direction.EAST){
                    dir = Direction.SOUTH;
                }else if(dir==Direction.SOUTH){
                    dir=Direction.WEST;
                }else if(dir==Direction.WEST){
                    dir=Direction.NORTH;
                }else{
                    dir = Direction.EAST;
                }
            }

            System.out.println(x + " "+y);
        }
        if(x==0 && y==0){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        RobotBoundedInCircle rr = new RobotBoundedInCircle();
        System.out.println(rr.isRobotBounded("GGLLGG"));
        System.out.println(rr.isRobotBounded("GL"));
        System.out.println(rr.isRobotBounded("GG"));
    }
}
