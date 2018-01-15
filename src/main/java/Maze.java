import mazeParts.mazeCreate;
import java.util.ArrayList;

/*
 このクラスでは迷路の自動生成を行う。
 メソッドは４つに分かれていて、迷路を掘るcreateRouteメソッド、
 掘ることが可能か調べるcanCreateメソッド、迷路を出力するoutputMazeメソッド、
 そしてメインメソッドである。今回は二次元配列を使って数値によって判断するように作った。
 */


public class Maze {
    static  int height = 35, width = 39;
    public static void main(String[] args) {
        //マップを格納する二次元配列
        int [] [] maze = new int[height] [width];

        /*迷路で最初に穴を掘る場所。偶数でなければならない。
        なぜなら、2マス進みながら穴を掘ることを考えて一番外
        を壁にしなければならないからだ。
         */
        int row = maze.length/2, col = maze[0].length/2;

        //初期位置の壁を掘る。
        maze[row][col] = 1;

        //進む方向を格納するリスト
        ArrayList<Integer> direction= new ArrayList<Integer>();

        //0~3がそれぞれ東西南北に該当
        direction.add(0);
        direction.add(1);
        direction.add(2);
        direction.add(3);

        mazeCreate cre = new mazeCreate(maze,row,col,direction);
        cre.createRoute(maze, row, col, direction);

        //迷路を出力
        cre.outputMaze(maze);
    }
}
