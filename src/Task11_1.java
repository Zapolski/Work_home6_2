import java.util.Scanner;

public class Task11_1 {

    public final static int DESK_SIZE = 20;

    public static int[][] deskState = new int[DESK_SIZE][DESK_SIZE];

    public final static int[][] POSSIBLE_MOVES = {
            { 2, -1},
            {-2,  1},
            { 1, -2},
            {-1, -2},
            { 2,  1},
            {-2, -1},
            { 1,  2},
            {-1,  2} };

    public static void main(String[] args) {
        System.out.printf("Введите начальные координаты коня (1-%d) от левого нижнего угла: \n",DESK_SIZE);
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите номер строки: ");
        int x = Integer.parseInt(sc.nextLine());
        System.out.print("Введите номер столбца: ");
        int y = Integer.parseInt(sc.nextLine());

        deskState[x-1][y-1]=1;
        rek(x-1,y-1,2);
        printResult();
    }

    public static void rek (int x, int y, int step){
        int numk=8;
        int A=0;
        int B=0;

        boolean haveMove=false;
        for (int i = 0; i < 8; i++) {

            int a = x+POSSIBLE_MOVES[i][0];
            int b = y+POSSIBLE_MOVES[i][1];

            if ((a>=0)&&(a<DESK_SIZE)&&(b>=0)&&(b<DESK_SIZE)&&(deskState[a][b]==0)){

                //для последнего хода
                if (!haveMove){
                    haveMove=true;
                    A=a;
                    B=b;
                }

                //Варнсдорф
                int nums = countCanMove(a,b);
                if (nums!=0){
                    if (nums<numk){
                        numk=nums;
                        A = a;
                        B = b;
                    }
                }
            }
        }
        if (numk<8){
            deskState[A][B]=step;
            rek(A,B,++step);
        }else
            if (haveMove) {
                deskState[A][B]=step;
            }
    }

    public static int countCanMove(int x,int y){
        int result = 0;
        for (int i = 0; i < 8; i++) {
            int u = x+POSSIBLE_MOVES[i][0];
            int v = y+POSSIBLE_MOVES[i][1];
            if ((u>=0)&&(u<DESK_SIZE)&&(v>=0)&&(v<DESK_SIZE)&&(deskState[u][v]==0))
                result++;
        }
        return result;
    }

    private static void printResult() {
        for (int i = DESK_SIZE; i > 0; i--) {
            for (int j = 0; j < DESK_SIZE; j++) {
                System.out.printf("%4d", deskState[i-1][j] );
            }
            System.out.println();
        }
        System.out.println();
    }
}