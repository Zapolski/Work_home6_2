import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите два числа: ");
        int n1 = Integer.parseInt(sc.nextLine());
        int n2 = Integer.parseInt(sc.nextLine());

        if (n1<n2) printNumbers(n1,n2,(byte)1);
        else printNumbers(n1,n2,(byte)-1);
    }

    private static void printNumbers(int i, int i1,byte direction) {
        if (i==i1) {
            System.out.print(i+" ");
            return;
        }
        System.out.print(i+" ");
        printNumbers(i += direction,i1,direction);
    }
}
