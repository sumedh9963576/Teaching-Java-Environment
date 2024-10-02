package keys;

public class D_ArraysKey {

    public D_ArraysKey(){}

    public void exercise1(){
        // Declare an array of integers with values 1, 2, 3, 4, 5 and print each value
        int[] numbers = {1, 2, 3, 4, 5};
        for(int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }
    }

    public void exercise2(){
        // Declare a String array with the names of the days of the week and print each day
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        for(String day : days){
            System.out.println(day);
        }
    }

    public void exercise3(){
        // Create a 2D array of integers and print its elements
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void exercise4(){
        // Declare an array of 5 integers and initialize all elements to 0
        int[] arr = new int[5];
        for(int i = 0; i < arr.length; i++){
            arr[i] = 0;
        }
    }

    public void exercise5(){
        // Write a method that takes an array of integers and returns the maximum value
        int[] arr = {3, 5, 7, 2, 8};
        System.out.println(maxValue(arr));  // should print 8
    }

    public int maxValue(int[] arr){
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    public void exercise6(){
        // Write a method that takes an array of integers and returns the sum of the elements
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(sumArray(arr));  // should print 15
    }

    public int sumArray(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }

    public void exercise7(){
        // Write a method that takes an array of integers and returns true if it contains a specific number
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(containsNumber(arr, 3));  // should print true
    }

    public boolean containsNumber(int[] arr, int target){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target){
                return true;
            }
        }
        return false;
    }

    public void exercise8(){
        // Write a method that takes a String array and returns the longest string
        String[] words = {"apple", "banana", "cherry"};
        System.out.println(longestString(words));  // should print "banana"
    }

    public String longestString(String[] arr){
        String longest = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i].length() > longest.length()){
                longest = arr[i];
            }
        }
        return longest;
    }

    public void exercise9(){
        // Write a method that reverses an array of integers
        int[] arr = {1, 2, 3, 4, 5};
        int[] reversed = reverseArray(arr);
        for(int i : reversed){
            System.out.println(i);  // should print 5, 4, 3, 2, 1
        }
    }

    public int[] reverseArray(int[] arr){
        int[] reversed = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }

    public void exercise10(){
        // Write a method that takes two arrays of the same length and returns a new array containing their sums
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6};
        int[] sumArr = sumArrays(arr1, arr2);
        for(int i : sumArr){
            System.out.println(i);  // should print 5, 7, 9
        }
    }

    public int[] sumArrays(int[] arr1, int[] arr2){
        int[] sumArr = new int[arr1.length];
        for(int i = 0; i < arr1.length; i++){
            sumArr[i] = arr1[i] + arr2[i];
        }
        return sumArr;
    }

    public void exercise11(){
        // Write a method that takes an array of doubles and returns the average value
        double[] arr = {1.0, 2.0, 3.0, 4.0, 5.0};
        System.out.println(averageValue(arr));  // should print 3.0
    }

    public double averageValue(double[] arr){
        double sum = 0;
        for(double value : arr){
            sum += value;
        }
        return sum / arr.length;
    }

    public void exercise12(){
        // Write a method that takes an array of integers and returns a new array with the values squared
        int[] arr = {1, 2, 3, 4, 5};
        int[] squaredArr = squareArray(arr);
        for(int i : squaredArr){
            System.out.println(i);  // should print 1, 4, 9, 16, 25
        }
    }

    public int[] squareArray(int[] arr){
        int[] squaredArr = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            squaredArr[i] = arr[i] * arr[i];
        }
        return squaredArr;
    }

    public void exercise13(){
        // Write a method that finds and returns the index of a specific number in an array, or -1 if not found
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println(findIndex(arr, 30));  // should print 2
    }

    public int findIndex(int[] arr, int target){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }

    public void exercise14(){
        // Write a method that merges two arrays into one and returns the new array
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6};
        int[] mergedArr = mergeArrays(arr1, arr2);
        for(int i : mergedArr){
            System.out.println(i);  // should print 1, 2, 3, 4, 5, 6
        }
    }

    public int[] mergeArrays(int[] arr1, int[] arr2){
        int[] mergedArr = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, mergedArr, 0, arr1.length);
        System.arraycopy(arr2, 0, mergedArr, arr1.length, arr2.length);
        return mergedArr;
    }

    public void exercise15(){
        // Write a method that takes a String array and prints each element in uppercase
        String[] words = {"hello", "world"};
        printUppercase(words);
    }

    public void printUppercase(String[] arr){
        for(String word : arr){
            System.out.println(word.toUpperCase());
        }
    }
}
