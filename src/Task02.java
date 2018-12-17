import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {

        int n = getIntFormConsloe();

        if (isExponentOfTwo(n)) System.out.println("YES");
        else System.out.println("NO");
    }

    private static boolean isExponentOfTwo(int n) {
        if (n==2){
            return true;
        }
        if (n<2) {
            return false;
        }else{
            if (n%2==0){
                return isExponentOfTwo(n/2);
            }else return false;
        }
    }

    public static int getIntFormConsloe(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите целое число: ");
        return Integer.parseInt(sc.nextLine());
    }

}
