package keys;

import java.lang.reflect.Array;

public class C_LoopsKey {

    public C_LoopsKey(){}

    public void exercise1(){
        // Create a loop that increases a variable 'counter' 10 times
        int counter = 0;
        for (int i = 0; i < 10; i++){
            counter++;
        }
    }

    public int[] exercise2(){
        // Create a loop to return a list containing the numbers 1 to 10
        int[] numbers = new int[10];
        for(int i = 1; i <= 10; i++){
            numbers[i] = i;
        }
        return numbers;
    }

    public void exercise3(){
        // Write a do-while loop that prints "Hello!" 3 times
        int count = 0;
        do {
            System.out.println("Hello!");
            count++;
        } while (count < 3);
    }
    
    public int exercise5(){
        // Write a while loop that returns the sum of numbers from 1 to 5
        int i = 1;
        int sum = 0;
        while(i <= 5){
            sum += i;
            i++;
        }
        return sum;
    }

    public int exercise4(){
        // Write a for loop returns a sum of even numbers between 2 and 10
        int sum = 0;
        for(int i = 2; i <= 10; i += 2){
            sum +=i;
        }
        return sum;
    }

    public int[] exercise6(int[] arr){
        // Write a for loop that adds one to every element of an array, and then returns it
        for(int i = 0; i < arr.length; i++){
            arr[i]++;
        }
        return arr;
    }

    public int exercise8(){
        // Write a for loop that calculates the factorial of 5
        int factorial = 1;
        for(int i = 1; i <= 5; i++){
            factorial *= i;
        }
        return factorial;
    }

    public int exercise10(){
        // Write a loop that counts how many times the letter 'a' appears in a string
        String text = "Java programming";
        int count = 0;
        for(int i = 0; i < text.length(); i++){
            if(text.charAt(i) == 'a'){
                count++;
            }
        }
        return count;  // should print 3
    }

    public void exercise11(){
        // Write a for loop that finds the first 10 numbers of the Fibonacci sequence
        // Write a for loop that finds the first 10 numbers of the Fibonacci sequence
        int a = 0, b = 1;
        for(int i = 0; i < 10; i++){
            int next = a + b;
            a = b;
            b = next;
        }
    }

    public String exercise13(String str){
        // Write a loop to reverse a string
        String reversed = "";
        for(int i = str.length() - 1; i >= 0; i--){
            reversed += str.charAt(i);
        for(int i = str.length() - 1; i >= 0; i--){
            reversed += str.charAt(i);
        }
        return reversed;  // should print "avaJ"
    }
}