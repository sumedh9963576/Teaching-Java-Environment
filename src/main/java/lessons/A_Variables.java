package lessons;

public class A_Variables {

    public A_Variables(){}
    
    public void exercise1(){
        // Declare a double variable 'myFirstVariable' to a value of 3
        double myFirstVariable = 3; 
    }

    public void exercise2(){
        // Declare a double variable 'anotherVariable' to a value of 25.0
        double anotherVariable = 3;
    }

    public void exercise3(){
        // Declare a String variable 'greeting' and assign it the value "Hello, World!"
        String greeting = "Hello, World!"; 
    }

    public void exercise4(){
        // Declare an integer variable 'age' and assign it a value of 15
        int age = 15; 
    }

    public void exercise5(){
        // Declare a boolean variable 'isStudent' and assign it a value of true
        boolean isStudent = true; 
    }

    public void exercise6(){
        // Declare a char variable 'grade' and assign it a value of 'A'
        char grade = 'A'; 
    }

    public void exercise7(){
        // Declare a float variable 'temperature' and assign it a value of 98.6d
        float temperature = 98.6d;
    }

    public void exercise8(){
        // Declare an integer variable 'hoursWorked' and assign it a value of 40
        int hoursWorks  = 40; 
    }

    public void exercise9(){
        // Declare a String variable 'name' and assign it your first name
        String name = sumedh; 
    }

    public void exercise10(){
        // Declare a long variable 'distance' and assign it a value of 100000000L
        long distance = 100000000L; 
    }

    public void exercise11(){
        // Declare a short variable 'smallNumber' and assign it a value of 1234
        short smallNumber = 1234; 
    }

    public void exercise12(){
        // Declare a constant (final) double variable 'PI' and assign it a value of 3.14159
        final double PI = 3.1419 
    }

    public void exercise13(){
        // Declare two integer variables 'x' and 'y' and assign values to them, then swap their values
        int x = 9
        int y = 4
        int temp = x; 
        x = y; 
        y = temp; 
        
    }

    public void exercise14(){
        // Declare an integer variable 'sum' and add two integers 7 and 3 to it
        int sum = sum + 7 + 3;
    }

    public void exercise15(){
        // Declare two integer variabels 'num1' and 'num2', assign them the values 2 and 5 respectively,
        // and then initialize a new variable 'myDouble' to the sum of those two integer variables
        int num1 = 2; 
        int num2 = 5;
        int myDouble = num1 + num2; 
        
        fahrenheitToCelsius(70);

    }
    
    public double fahrenheitToCelsius(double fahrenheit){
        // Write a function that converts a temperature from Fahrenheit to Celsius
        return (fahrenheit-32)*(5/9);
    }
}

