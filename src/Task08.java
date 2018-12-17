public class Task08 {
    public static void main(String[] args) {
        int m = Task02.getIntFormConsloe();
        int n = Task02.getIntFormConsloe();

        System.out.printf("Число %d в степение %d: %d",m,n,getExponent(m,n));
    }

    private static int getExponent(int m, int n) {
        if (n==1) return m;
        return m*getExponent(m,--n);
    }
}
