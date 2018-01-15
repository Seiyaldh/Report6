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
    /*掘りたい方向が掘れるか掘れないかの判断をする。
  行きたい方向の2マス先が一番端以上、もしくはす
  でに掘っているならfalse,そうでないならtrueを返す。
 */
    static boolean canCreate(int[][]maze, int direction, int row, int col) {
        switch (direction) {
            case 0:
                if (col - 2 <= 0) {
                    return false;
                } else {
                    if (maze[row][col - 2] == 0) {
                        return true;
                    } else {
                        return false;
                    }
                }
            case 1:
                if (col + 2 >= maze[0].length - 1) {
                    return false;
                } else {
                    if (maze[row][col + 2] == 0) {
                        return true;
                    } else {
                        return false;
                    }
                }
            case 2:
                if (row - 2 <= 0) {
                    return false;
                } else {
                    if (maze[row - 2][col] == 0) {
                        return true;
                    } else {
                        return false;
                    }
                }
            case 3:
                if (row + 2 >= maze.length - 1) {
                    return false;
                } else {
                    if (maze[row + 2][col] == 0) {
                        return true;
                    } else {
                        return false;
                    }
                }
            default:
        }
        return false;
    }
    //全ての数値を見て、1なら空白、0なら壁を出力する。
    public static void outputMaze(int [][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 0) {
                    System.out.print("■");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
