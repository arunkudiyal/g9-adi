import java.util.Scanner;

public class DynamicProgramming {
    //    public static int fib(int n) {
    //        if(n == 1) return 0;
    //        if(n == 2) return 1;
    //        return fib(n-1) + fib(n-2);
    //    }

    public static int lis(int n, int[] arr) {
        int ans = 0;
        // Memo
        int memo[] = new int[n];
        memo[0] = 1;

        for(int i=1; i < n; i++) {
            for(int j= i-1; j >= 0; j--) {
                if(arr[i] < arr[j]) {
                    memo[i] = memo[j];
                    continue;
                } else {
                    memo[i] = memo[j] + 1;
                }
            }
        }
        for(int i=1; i < n; i++) {
            if(memo[i] > ans) {
                ans = memo[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for(int i=0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int solution = lis(n, arr);
        System.out.println(solution);
    }
}
