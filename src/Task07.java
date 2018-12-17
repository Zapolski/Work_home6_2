import java.util.Scanner;

public class Task07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите строку для проверки: ");
        String str = sc.nextLine();

        if (isPalindrom(str)) System.out.println("YES");
        else System.out.println("NO");
    }

    private static boolean isPalindrom(String str) {
        if (str.length()==1) return true;
        if (str.length()==2){
            if (str.substring(0,1).equals(str.substring(str.length()-1))) return true;
            else return false;
        }else return isPalindrom(str.substring(1,str.length()-1));
    }

    //просто перевернуть строку
    /*private static String getPalindrom(String str) {
        if (str.length()==1) return str;
        return str.substring(str.length()-1)+getPalindrom(str.substring(0,str.length()-1));
    }*/





}
