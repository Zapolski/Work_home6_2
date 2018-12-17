public class Task11 {


    public final static int DESK_SIZE = 4;
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
        System.out.println("Введите начальные координаты коня: ");
        int x = Task02.getIntFormConsloe();
        int y = Task02.getIntFormConsloe();

        findPath(x,y,1);
        System.out.println("ok");

        printResult();
    }

    private static void printResult() {
        for (int i = DESK_SIZE; i > 0; i--) {
            for (int j = 0; j < DESK_SIZE; j++) {
                System.out.printf("%3d", deskState[i-1][j] );
            }
            System.out.println();
        }
    }


    public static int findPath( int curX, int curY, int curMoveNum )
    {
        deskState[curX][curY] = curMoveNum;
        int moveNum = curMoveNum;
        if (curMoveNum > MAX_MOVES) return 1; // проверяем не достигли ли резульатат, т.е. сделать 64 хода
        // перебираем все возможные ходя для данной клетки
        for (int i = 0; i < 8; i++) {
            int next_x = curX + POSSIBLE_MOVES[i][0];
            int next_y = curY + POSSIBLE_MOVES[i][1];

            if (isMovePossible(next_x, next_y) && (findPath(next_x, next_y, moveNum + 1) == 1)) {
                return 1;
            }
        }
        deskState[curX][curY]=0;
        moveNum--;
        return 0;
    }

    public static boolean isMovePossible(int x, int y)
    {
        return (x >= 0 && y >= 0 && x < DESK_SIZE && y < DESK_SIZE && deskState[x][y] == 0);
    }
}
