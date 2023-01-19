import java.util.Scanner;

public class DynamicProgramming {
    //        public static int fib(int n) {
    //            if(n == 1) return 0;
    //            if(n == 2) return 1;
    //            return fib(n-1) + fib(n-2);
    //        }

    public static int lis(int n, int[] arr) {
        int[] output = new int[n];
        for(int i=0; i < n; i++) {
            output[i] = 1;
        }

        for(int i=1; i < n; i++) {
            for(int j=i-1; j >= 0; j--) {
                if(arr[j] > arr[i]) {
                    continue;
                }
                int possibleAns = output[j] + 1;
                if(output[i] < possibleAns) {
                    output[i] = possibleAns;
                }
            }
        }

        int answer = 1;
        for(int i=0; i < n; i++) {
            if(answer < output[i]) {
                answer = output[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int lisOutput = lis(n, arr);
        System.out.println(lisOutput);
    }
}
