public class Task05 {
    public static void main(String[] args) {
        int n = Task02.getIntFormConsloe();
        System.out.println(getReversOrderNumbers(n));
    }

    private static String getReversOrderNumbers(int n) {
        if (n<10) return String.valueOf(n);
        return String.valueOf(getReversOrderNumbers(n/10)+" "+n%10);
    }
}
