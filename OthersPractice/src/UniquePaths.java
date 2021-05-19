/**
 * Leetcode 63 & 64
 */
public class UniquePaths {
    public static void main(String[] args){
        int[][] obs = {{0,0,0}, {0,1,0}, {0,0,0},{0,1,0},{0,0,0}};
        int res = uniquePathsWithObstacles(obs);
        System.out.println(res);

    }

    public static int uniquePaths(int m, int n){
        int[][] f = new int[m][n];
        for(int i = 0; i<m; i++){
            f[i][0] = 1;
        }
        for(int j =0; j<n; j++){
            f[0][j] = 1;
        }

        for(int i = 1; i<m; i++){
            for(int j = 1; j<n; j++){
                f[i][j] = f[i-1][j] + f[i][j-1];
            }
        }
        return f[m-1][n-1];
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid){
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0?1:0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j < m; j++){
                if(obstacleGrid[i][j] == 1){
                    f[j] = 0;
                    continue;
                }
                if(j -1 >=0 && obstacleGrid[i][j - 1] == 0){
                    f[j] = f[j] + f[j -1];
                }
            }
        }
        return f[m -1];
    }
}
