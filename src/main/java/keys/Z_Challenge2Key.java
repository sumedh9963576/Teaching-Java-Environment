package keys;

public class Z_Challenge2Key {

    public Z_Challenge2Key(){}

    public void exercise1(){
        // Write a function that takes an integer N and returns a list of all prime numbers less than N
        int[] primes = findPrimes(20);
        for(int prime : primes){
            System.out.println(prime);  // should print 2, 3, 5, 7, 11, 13, 17, 19
        }
    }

    public int[] findPrimes(int n){
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

    public void exercise2(){
        // Write a function that takes a string and returns the character that appears most frequently
        char mostFrequent = mostFrequentChar("programming");
        System.out.println(mostFrequent);  // should print 'g'
    }

    public char mostFrequentChar(String input){
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

    public void exercise3(){
        // Write a function that takes an integer and returns the number of digits in it
        int digits = countDigits(12345);
        System.out.println(digits);  // should print 5
    }

    public int countDigits(int number){
        int count = 0;
        while(number != 0){
            number /= 10;
            count++;
        }
        return count;
    }

    public void exercise4(){
        // Write a function that checks if two strings are anagrams (contain the same characters in a different order)
        boolean isAnagram = checkAnagram("listen", "silent");
        System.out.println(isAnagram);  // should print true
    }

    public boolean checkAnagram(String s1, String s2){
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

    public void exercise5(){
        // Write a function that takes an array of integers and returns the second largest number
        int[] arr = {12, 35, 1, 10, 34, 1};
        int secondLargest = findSecondLargest(arr);
        System.out.println(secondLargest);  // should print 34
    }

    public int findSecondLargest(int[] arr){
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
}

