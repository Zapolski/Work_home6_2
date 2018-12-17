public class Task09 {
    public static void main(String[] args) {
        int m = Task02.getIntFormConsloe();
        int n = Task02.getIntFormConsloe();

        System.out.printf("Сумма числе в диапазоне от %d до %d: %d",m,n,getSum(m,n));
    }

    private static int getSum(int m, int n) {
        if (m==n) return m;
        return m+getSum(++m,n);
    }
}
