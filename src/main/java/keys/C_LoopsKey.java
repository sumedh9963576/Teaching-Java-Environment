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

    public void exercise4(){
        // Write a for loop that prints even numbers between 2 and 10
        for(int i = 2; i <= 10; i += 2){
            System.out.println(i);
        }
    }

    public void exercise5(){
        // Write a while loop that prints the sum of numbers from 1 to 5
        int i = 1;
        int sum = 0;
        while(i <= 5){
            sum += i;
            i++;
        }
        System.out.println(sum);
    }

    public void exercise6(){
        // Write a for loop that prints the elements of an array
        int[] arr = {1, 2, 3, 4, 5};
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public void exercise7(){
        // Write a loop to print each character of a string
        String word = "Java";
        for(int i = 0; i < word.length(); i++){
            System.out.println(word.charAt(i));
        }
    }

    public void exercise8(){
        // Write a for loop that calculates the factorial of 5
        int factorial = 1;
        for(int i = 1; i <= 5; i++){
            factorial *= i;
        }
        System.out.println(factorial); // should print 120
    }

    public void exercise9(){
        // Write a while loop that stops when a random number between 1 and 100 is greater than 90
        int randomNum;
        do {
            randomNum = (int) (Math.random() * 100) + 1;
            System.out.println(randomNum);
        } while(randomNum <= 90);
    }

    public void exercise10(){
        // Write a loop that counts how many times the letter 'a' appears in a string
        String text = "Java programming";
        int count = 0;
        for(int i = 0; i < text.length(); i++){
            if(text.charAt(i) == 'a'){
                count++;
            }
        }
        System.out.println(count);  // should print 3
    }

    public void exercise11(){
        // Write a for loop that prints the first 10 numbers of the Fibonacci sequence
        int a = 0, b = 1;
        for(int i = 0; i < 10; i++){
            System.out.println(a);
            int next = a + b;
            a = b;
            b = next;
        }
    }

    public void exercise12(){
        // Write a nested loop to print a 5x5 grid of stars
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public void exercise13(){
        // Write a loop to reverse a string
        String word = "Java";
        String reversed = "";
        for(int i = word.length() - 1; i >= 0; i--){
            reversed += word.charAt(i);
        }
        System.out.println(reversed);  // should print "avaJ"
    }

    public void exercise14(){
        // Write a for-each loop that prints all the elements in a String array
        String[] fruits = {"Apple", "Banana", "Cherry"};
        for(String fruit : fruits){
            System.out.println(fruit);
        }
    }

    public void exercise15(){
        // Write a loop that sums up all the numbers in an array
        int[] numbers = {1, 2, 3, 4, 5};
        int total = 0;
        for(int number : numbers){
            total += number;
        }
        System.out.println(total);  // should print 15
    }
}