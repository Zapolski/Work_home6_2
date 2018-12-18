import java.util.Arrays;
import java.util.Scanner;

public class Task12 {
    public final static int DESK_SIZE = 5;
    public final static int MAX_MOVES = DESK_SIZE*2-2;

    public static int[][] deskState = new int[DESK_SIZE][DESK_SIZE];
    public static int[][] moves = new int[DESK_SIZE][DESK_SIZE];

    public static int maxSum;
    public static int currentSum;
    public static int[][] maxMoves = new int[DESK_SIZE][DESK_SIZE];

    public final static int[][] POSSIBLE_MOVES = {
            {1, 0},
            {0, 1},};

    public static void main(String[] args) {

        //заполняем поле случайными значениями
        for (int i = 0; i < deskState.length; i++) {
            for (int j = 0; j < deskState[i].length; j++) {
                deskState[i][j]=rnd(0,10);
            }
        }

        moves[0][0]=1;
        currentSum=deskState[0][0];
        maxSum = Integer.MIN_VALUE;

        rek(0,0,0);
        printResult(deskState);
        printResult(maxMoves);
        System.out.println(maxSum);
    }

    private static void rek(int x, int y, int step){
        moves[x][y] = 1;

        for (int i = 0; i < 2; i++)
        {
            int x1 = x + POSSIBLE_MOVES[i][0];
            int y1 = y + POSSIBLE_MOVES[i][1];
            if ((x1 >= 0) && (y1 >= 0) && (x1 < DESK_SIZE) && (y1 < DESK_SIZE)) {
                currentSum += deskState[x1][y1];
                rek(x1, y1, step + 1);
            }
        }

        if (step==MAX_MOVES) {
            if (currentSum>maxSum){
                maxSum=currentSum;
                for (int i = 0; i < moves.length; i++) {
                    maxMoves[i] = Arrays.copyOf(moves[i],moves[i].length);
                }
            }
        }
        moves[x][y] = 0;
        currentSum -= deskState[x][y];
    }

    private static void printResult(int[][] mas) {
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                System.out.printf("%3d", mas[i][j] );
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int rnd(int min, int max){
        return (int)(Math.random()*((max-min)+1))+min;
    }

}
