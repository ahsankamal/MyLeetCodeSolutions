package WeekThree;

//https://leetcode.com/discuss/explore/september-leetcoding-challenge/856077/Unique-Paths-or-C%2B%2B-or-100-time-or-Simple-DFS-traversal-with-backtracking
public class UniquePathsIII {

    public int dfs(int i, int j, int[][] grid, int count, int zeros){

        if(i>=grid.length || i<0 || j>=grid[0].length || j<0){
            return count;
        }
        if(grid[i][j]==-1 || grid[i][j]==-2){
            return count;
        }
        if(grid[i][j]==2){
            if(zeros==0){
                count++;
            }
            return count;
        }

//        if(grid[i][j]==0){
            grid[i][j]=-1;
//        }

        zeros--;
        count = dfs(i, j-1, grid, count,  zeros);
        count = dfs(i-1, j, grid, count,  zeros);
        count = dfs(i+1, j, grid, count,  zeros);
        count = dfs(i, j+1, grid, count,  zeros);

//        if(grid[i][j]==-2){
            grid[i][j]=0;
//        }
        return count;
    }
    public int uniquePathsIII(int[][] grid) {
        int start_x = -1;
        int start_y = -1;
        int sq = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    start_x=i;
                    start_y=j;
                }else if(grid[i][j]!=-1){
                    sq++;
                }
            }
        }

        return dfs(start_x, start_y, grid, 0,  sq);

    }

    public static void main(String[] args){
        UniquePathsIII uu = new UniquePathsIII();
        System.out.println(uu.uniquePathsIII(new int[][]{{1,0,0,0}, {0,0,0,0}, {0,0,2,-1}}));
        System.out.println(uu.uniquePathsIII(new int[][]{{1,0,0,0}, {0,0,0,0}, {0,0,0,2}}));
    }
}
