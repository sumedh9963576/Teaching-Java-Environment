package keys;

public class Z_Challenge1Key {

    public Z_Challenge1Key(){}

    public boolean checkPalindrome(String input){
        // Write a function that checks if a string is a palindrome (the same forward and backward)
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equals(reversed);
    }

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

    public void bubbleSort(int[] arr){
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
}

