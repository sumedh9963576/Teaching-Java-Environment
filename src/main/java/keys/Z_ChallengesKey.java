package keys;

public class Z_ChallengesKey {

    public Z_ChallengesKey(){}
    
    public boolean checkPrime(int number){
        if(number <= 1){
            return false;
        }
        for(int i = 2; i <= Math.sqrt(number); i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }

    public int sumFirstN(int n){
        // Write a function that returns the sum of the first N positive integers
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += i;
        }
        return sum;
    }
    
    public boolean checkPalindrome(String input){
        // Write a function that checks if a string is a palindrome (the same forward and backward)
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equals(reversed);
    }

    public int[] findPrimes(int n){
        // Write a function that takes an integer N and returns a list of all prime numbers less than N
        boolean[] isPrime = new boolean[n];
        for(int i = 2; i < n; i++){
            isPrime[i] = true;
        }
        for(int i = 2; i * i < n; i++){
            if(isPrime[i]){
                for(int j = i * i; j < n; j += i){
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for(int i = 2; i < n; i++){
            if(isPrime[i]){
                count++;
            }
        }
        int[] primes = new int[count];
        int index = 0;
        for(int i = 2; i < n; i++){
            if(isPrime[i]){
                primes[index++] = i;
            }
        }
        return primes;
    }

    public char mostFrequentChar(String input){
        // Write a function that takes a string and returns the character that appears most frequently
        int[] freq = new int[256];  // assuming ASCII
        for(char ch : input.toCharArray()){
            freq[ch]++;
        }
        int maxCount = 0;
        char mostFrequent = ' ';
        for(char ch : input.toCharArray()){
            if(freq[ch] > maxCount){
                maxCount = freq[ch];
                mostFrequent = ch;
            }
        }
        return mostFrequent;
    }
    
    public int countDigits(int number){
        // Write a function that takes an integer and returns the number of digits in it
        int count = 0;
        while(number != 0){
            number /= 10;
            count++;
        }
        return count;
    }

    public int findSecondLargest(int[] arr){
        // Write a function that takes an array of integers and returns the second largest number
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for(int num : arr){
            if(num > largest){
                secondLargest = largest;
                largest = num;
            } else if(num > secondLargest && num != largest){
                secondLargest = num;
            }
        }
        return secondLargest;
    }

    public boolean checkAnagram(String s1, String s2){
        // Write a function that checks if two strings are anagrams (contain the same characters in a different order)
        if(s1.length() != s2.length()){
            return false;
        }
        int[] count = new int[256];  // assuming ASCII
        for(char ch : s1.toCharArray()){
            count[ch]++;
        }
        for(char ch : s2.toCharArray()){
            count[ch]--;
        }
        for(int c : count){
            if(c != 0){
                return false;
            }
        }
        return true;
    }

    public int fibonacci(int n){
        // Write a function that solves the Fibonacci sequence using recursion
        if(n <= 1){
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public int[] bubbleSort(int[] arr){
        // Write a function that sorts an array using bubble sort
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
        return arr;
    }

    public int findGCD(int a, int b){
        // Write a function that finds the GCD (greatest common divisor) of two numbers using the Euclidean algorithm
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int longestIncreasingSubsequence(int[] arr){
        // Write a function that finds the longest increasing subsequence in an array
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

    public int[] quicksort(int[] arr, int low, int high){
        // Write a function that implements the quicksort algorithm to sort an array
        if(low < high){
            int pivot = arr[high];
            int i = (low - 1);
            for(int j = low; j < high; j++){
                if(arr[j] < pivot){
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;
            int pi = i + 1;

            quicksort(arr, low, pi - 1);
            quicksort(arr, pi + 1, high);
        }
        return arr;
    }


    /*
     *  {5, 3, 0, 0, 7, 0, 0, 0, 0},
        {6, 0, 0, 1, 9, 5, 0, 0, 0},
        {0, 9, 8, 0, 0, 0, 0, 6, 0},
        {8, 0, 0, 0, 6, 0, 0, 0, 3},
        {4, 0, 0, 8, 0, 3, 0, 0, 1},
        {7, 0, 0, 0, 2, 0, 0, 0, 6},
        {0, 6, 0, 0, 0, 0, 2, 8, 0},
        {0, 0, 0, 4, 1, 9, 0, 0, 5},
        {0, 0, 0, 0, 8, 0, 0, 7, 9}
     */

    public boolean solveSudoku(int[][] board){
        // Write a function that solves a Sudoku puzzle using backtracking
        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                if(board[row][col] == 0){
                    for(int num = 1; num <= 9; num++){
                        boolean isValid = true;
                        for(int i = 0; i < 9; i++){
                            if(board[row][i] == num || board[i][col] == num || board[row - row % 3 + i / 3][col - col % 3 + i % 3] == num){
                                isValid = false;
                            }
                        }

                        if(isValid){
                            board[row][col] = num;
                            if(solveSudoku(board)){
                                return true;
                            } else {
                                board[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
}

