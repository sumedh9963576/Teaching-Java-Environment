package keys;

public class E_FunctionsKey {

    public E_FunctionsKey(){}

    public int sum(int a, int b){
        return a + b;
    }

    public void exercise2(){
        // Create a function that takes a string and returns the length of the string
        int length = getStringLength("Hello");
        System.out.println(length);  // should print 5
    }

    public int getStringLength(String input){
        return input.length();
    }

    public void exercise3(){
        // Create a function that takes an array of integers and returns the sum of all elements
        int[] numbers = {1, 2, 3, 4, 5};
        int total = sumArray(numbers);
        System.out.println(total);  // should print 15
    }

    public int sumArray(int[] arr){
        int sum = 0;
        for(int i : arr){
            sum += i;
        }
        return sum;
    }

    public void exercise4(){
        // Create a function that returns true if the number is even, otherwise false
        boolean isEven = checkEven(4);
        System.out.println(isEven);  // should print true
    }

    public boolean checkEven(int number){
        return number % 2 == 0;
    }

    public void exercise5(){
        // Create a function that returns the largest of two numbers
        int larger = max(10, 20);
        System.out.println(larger);  // should print 20
    }

    public int max(int a, int b){
        return (a > b) ? a : b;
    }

    public void exercise6(){
        // Create a function that returns the square of a number
        int square = squareNumber(6);
        System.out.println(square);  // should print 36
    }

    public int squareNumber(int number){
        return number * number;
    }

    public void exercise7(){
        // Create a function that takes a string and returns the first character
        char firstChar = firstCharacter("Java");
        System.out.println(firstChar);  // should print 'J'
    }

    public char firstCharacter(String input){
        return input.charAt(0);
    }

    public void exercise8(){
        // Create a function that takes a string and returns it in uppercase
        String uppercase = toUpperCase("java");
        System.out.println(uppercase);  // should print "JAVA"
    }

    public String toUpperCase(String input){
        return input.toUpperCase();
    }

    public void exercise9(){
        // Create a function that checks if a string contains a specific character
        boolean contains = containsChar("apple", 'p');
        System.out.println(contains);  // should print true
    }

    public boolean containsChar(String input, char ch){
        return input.indexOf(ch) >= 0;
    }

    public void exercise10(){
        // Create a function that takes a number and returns the factorial of that number
        int factorial = calculateFactorial(5);
        System.out.println(factorial);  // should print 120
    }

    public int calculateFactorial(int number){
        int result = 1;
        for(int i = 1; i <= number; i++){
            result *= i;
        }
        return result;
    }

    public void exercise11(){
        // Create a function that takes an array of integers and returns the average value
        int[] values = {10, 20, 30, 40, 50};
        double average = getAverage(values);
        System.out.println(average);  // should print 30.0
    }

    public double getAverage(int[] arr){
        int sum = 0;
        for(int num : arr){
            sum += num;
        }
        return (double) sum / arr.length;
    }

    public void exercise12(){
        // Create a function that returns the absolute value of a number
        int abs = absoluteValue(-5);
        System.out.println(abs);  // should print 5
    }

    public int absoluteValue(int number){
        return (number < 0) ? -number : number;
    }

    public void exercise13(){
        // Create a function that takes two strings and returns true if they are equal, ignoring case
        boolean isEqual = compareIgnoreCase("hello", "HELLO");
        System.out.println(isEqual);  // should print true
    }

    public boolean compareIgnoreCase(String s1, String s2){
        return s1.equalsIgnoreCase(s2);
    }

    public void exercise14(){
        // Create a function that returns the reverse of a string
        String reversed = reverseString("Java");
        System.out.println(reversed);  // should print "avaJ"
    }

    public String reverseString(String input){
        StringBuilder reversed = new StringBuilder(input);
        return reversed.reverse().toString();
    }

    public void exercise15(){
        // Create a function that takes a number and returns true if it is prime
        boolean isPrime = checkPrime(7);
        System.out.println(isPrime);  // should print true
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
}

