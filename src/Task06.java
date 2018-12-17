public class Task06 {
    public static void main(String[] args) {
        int n = Task02.getIntFormConsloe();
        System.out.println(getReversOrderNumbers(n,0));
    }

    private static int getReversOrderNumbers(int n, int n1) {
        if (n==0) return n1;
        return getReversOrderNumbers(n/10,n1*10+n%10);
    }
}
