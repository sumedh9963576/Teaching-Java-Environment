package keys;

public class Z_Challenge3Key {

    public Z_Challenge3Key(){}

    public void exercise1(){
        // Write a function that solves the Fibonacci sequence using recursion
        int result = fibonacci(10);
        System.out.println(result);  // should print 55
    }

    public int fibonacci(int n){
        if(n <= 1){
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public void exercise2(){
        // Write a function that sorts an array using bubble sort
        int[] arr = {5, 1, 4, 2, 8};
        bubbleSort(arr);
        for(int num : arr){
            System.out.println(num);  // should print 1, 2, 4, 5, 8
        }
    }

    public void bubbleSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public void exercise3(){
        // Write a function that finds the GCD (greatest common divisor) of two numbers using the Euclidean algorithm
        int gcd = findGCD(54, 24);
        System.out.println(gcd);  // should print 6
    }

    public int findGCD(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public void exercise4(){
        // Write a function that solves the Tower of Hanoi problem
        solveHanoi(3, 'A', 'C', 'B');
        // should print the sequence of moves
    }

    public void solveHanoi(int n, char fromRod, char toRod, char auxRod){
        if(n == 1){
            System.out.println("Move disk 1 from rod " + fromRod + " to rod " + toRod);
            return;
        }
        solveHanoi(n - 1, fromRod, auxRod, toRod);
        System.out.println("Move disk " + n + " from rod " + fromRod + " to rod " + toRod);
        solveHanoi(n - 1, auxRod, toRod, fromRod);
    }

    public void exercise5(){
        // Write a function that finds the longest increasing subsequence in an array
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int length = longestIncreasingSubsequence(arr);
        System.out.println(length);  // should print 6
    }

    public int longestIncreasingSubsequence(int[] arr){
        int n = arr.length;
        int[] lis = new int[n];
        for(int i = 0; i < n; i++){
            lis[i] = 1;
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j] && lis[i] < lis[j] + 1){
                    lis[i] = lis[j] + 1;
                }
            }
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            if(lis[i] > max){
                max = lis[i];
            }
        }
        return max;
    }
}

