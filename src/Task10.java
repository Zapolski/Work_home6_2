public class Task10 {
    public static void main(String[] args) {
        int m = Task02.getIntFormConsloe();
        int n = Task02.getIntFormConsloe();

        System.out.printf("Наибольший общий делитель чисел %d и %d: %d",m,n,getNod(m,n));
    }

    private static int getNod(int m, int n) {
        if (m<n){
            if (m==1) return 1;
            if (n%m==0) return m;
            else return getNod(m,n%m);
        }else{
            if (n==1) return 1;
            if (m%n==0) return n;
            else return getNod(n,m%n);
        }
    }
}
