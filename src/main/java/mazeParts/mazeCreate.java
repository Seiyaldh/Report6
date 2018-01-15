package mazeParts;

import java.util.ArrayList;
import java.util.Collections;

public class mazeCreate {
    int [][]maze;
    int row, col;
    ArrayList<Integer> direction = new ArrayList<>();
    public mazeCreate(int [][]maze, int row, int col, ArrayList<Integer>direction) {
        this.direction = direction;
        this.row = row;
        this.col = col;
        this.maze = maze;
    }
    public static void createRoute(int[][]maze,int row, int col,ArrayList<Integer>direction) {
        //ランダムに方向を見て、進める方向に2マス壁を掘る。
        Collections.shuffle(direction);
        for (int i = 0; i < direction.size(); i++) {
            if (canCreate(maze,direction.get(i), row, col)) {
                switch (direction.get(i)) {
                    case 0:
                        maze[row][col-1] = 1;
                        maze[row][col-2] = 1;
                        col = col - 2;
                        break;
                    case 1:
                        maze[row][col+1] = 1;
                        maze[row][col+2] = 1;
                        col = col + 2;
                        break;
                    case 2:
                        maze[row-1][col] = 1;
                        maze[row-2][col] = 1;
                        row = row-2;
                        break;
                    case 3:
                        maze[row+1][col] = 1;
                        maze[row+2][col] = 1;
                        row = row+2;
                        break;
                    default:
                        break;
                }
                direction.add(0);
                direction.add(1);
                direction.add(2);
                direction.add(3);

                createRoute(maze, row, col, direction);
            }
        }
    }
    
}
