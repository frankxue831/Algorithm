import java.util.ArrayList;
import java.util.List;

public class LeetCode54 {
    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix).toString());

    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return order;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = columns * rows;
        int row = 0;
        int column = 0;
        int[][] directions = {{0,1}, {1,0},{0, -1}, {-1, 0}};
        int directionIndex = 0;
        for(int i = 0; i<total; i++){
            order.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];
            if(nextRow < 0|| nextRow >= rows || nextColumn < 0|| nextColumn >=columns || visited[nextRow][nextColumn]){
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }

}
