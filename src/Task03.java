public class Task03 {
    public static void main(String[] args) {

        int n = Task02.getIntFormConsloe();
        System.out.print("Сумма цифр числа: "+getSumNumbers(n));
    }

    public static int getSumNumbers(int n){
        if (n<10) return n;
        return n%10+getSumNumbers(n/10);
    }
}
