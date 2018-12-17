import java.util.Scanner;

public class Task11 {

    public final static int DESK_SIZE = 8;
    public final static int MAX_MOVES = DESK_SIZE*DESK_SIZE;

    public static int[][] deskState = new int[DESK_SIZE][DESK_SIZE];

    public final static int[][] POSSIBLE_MOVES = {
        {-1, -2},
        {-2, -1},
        {-2,  1},
        { 1, -2},
        {-1,  2},
        { 2, -1},
        { 1,  2},
        { 2,  1} };

    public static void main(String[] args) {
        System.out.printf("Введите начальные координаты коня (1-%d) от левого нижнего угла: \n",DESK_SIZE);
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите номер строки: ");
        int x = Integer.parseInt(sc.nextLine());
        System.out.print("Введите номер столбца: ");
        int y = Integer.parseInt(sc.nextLine());

        deskState[x-1][y-1]=1;
        if (!rek(x-1,y-1,2))
            System.out.println("Для данной начальной позиции нет вариантов обхода всего поля.");
        printResult();
    }

    public static boolean rek (int x, int y, int step){
        for (int i = 0; i < 8; i++)
        {
            int x1 = x + POSSIBLE_MOVES[i][0];
            int y1 = y + POSSIBLE_MOVES[i][1];

            if ((x1 >= 0) && (y1 >= 0) && (x1 < DESK_SIZE) && (y1 < DESK_SIZE) && (deskState[x1][y1] == 0))
            {
                deskState[x1][y1] = step;
                if ((step==MAX_MOVES)||(rek(x1,y1,step+1))){
                    return true;
                }
                else{
                    deskState[x1][y1]=0;
                }
            }
        }
        return false;
    }

    private static void printResult() {
        for (int i = DESK_SIZE; i > 0; i--) {
            for (int j = 0; j < DESK_SIZE; j++) {
                System.out.printf("%3d", deskState[i-1][j] );
            }
            System.out.println();
        }
        System.out.println();
    }
}
