package keys;

public class Z_Challenge1Key {

    public Z_Challenge1Key(){}

    public void exercise1(){
        // Write a function that returns the sum of the first N positive integers
        int result = sumFirstN(5);  // should return 15 (1+2+3+4+5)
        System.out.println(result);
    }

    public int sumFirstN(int n){
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += i;
        }
        return sum;
    }

    public void exercise2(){
        // Write a function that checks if a string is a palindrome (the same forward and backward)
        boolean isPalindrome = checkPalindrome("madam");
        System.out.println(isPalindrome);  // should print true
    }

    public boolean checkPalindrome(String input){
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equals(reversed);
    }

    public void exercise3(){
        // Write a function that takes an array of integers and returns the smallest value
        int[] arr = {5, 3, 9, 1, 7};
        int smallest = findSmallest(arr);
        System.out.println(smallest);  // should print 1
    }

    public int findSmallest(int[] arr){
        int min = arr[0];
        for(int num : arr){
            if(num < min){
                min = num;
            }
        }
        return min;
    }

    public void exercise4(){
        // Write a function that converts a temperature from Fahrenheit to Celsius
        double celsius = fahrenheitToCelsius(98.6);
        System.out.println(celsius);  // should print 37.0
    }

    public double fahrenheitToCelsius(double fahrenheit){
        return (fahrenheit - 32) * 5/9;
    }

    public void exercise5(){
        // Write a function that checks if a number is divisible by both 3 and 7
        boolean isDivisible = divisibleBy3And7(21);
        System.out.println(isDivisible);  // should print true
    }

    public boolean divisibleBy3And7(int number){
        return number % 3 == 0 && number % 7 == 0;
    }
}

