package keys;

public class D_ArraysKey {

    public D_ArraysKey(){}

    public void exercise1(){
        // Declare an array of integers with values 1, 2, 3, 4, 5
        int[] numbers = {1, 2, 3, 4, 5};
    }

    public void exercise2(){
        // Declare a String array with the names of the days of the week, (EX: "Monday", "Friday")
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    }

    public int[][] exercise3(int[][] array2D){
        // Increase every element in a 2D array by one, and return the new modified array
        for(int i = 0; i < array2D.length; i++){
            for(int j = 0; j < array2D[i].length; j++){
                System.out.print(array2D[i][j] + " ");
            }
        }
        return array2D;
    }

    public void exercise4(){
        // Declare an array of 5 integers and initialize all elements to 5
        int[] arr = new int[5];
        for(int i = 0; i < arr.length; i++){
            arr[i] = 5;
        }
    }
    
    public int maxValue(int[] arr){
        // Write a method that takes an array of integers and returns the maximum value
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    
    public int sumArray(int[] arr){
        // Write a method that takes an array of integers and returns the sum of the elements
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }

    public double averageValue(double[] arr){
        // Write a method that takes an array of doubles and returns the average value
        double sum = 0;
        for(double value : arr){
            sum += value;
        }
        return sum / arr.length;
    }

    public boolean containsNumber(int[] arr, int target){
        // Write a method that takes an array of integers and a target number and returns if the array contains the target value or not
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target){
                return true;
            }
        }
        return false;
    }
    
    public String longestString(String[] arr){
        // Write a method that takes a String array and returns the longest string
        String longest = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i].length() > longest.length()){
                longest = arr[i];
            }
        }
        return longest;
    }
    
    public int[] reverseArray(int[] arr){
        // Write a method that reverses an array of integers
        int[] reversed = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }
    
    public int[] sumArrays(int[] arr1, int[] arr2){
        // Write a method that takes two arrays of the same length and returns a new array containing their sums
        int[] sumArr = new int[arr1.length];
        for(int i = 0; i < arr1.length; i++){
            sumArr[i] = arr1[i] + arr2[i];
        }
        return sumArr;
    }
    
    public int findIndexOf(int[] arr, int target){
        // Write a method that finds and returns the index of a specific number in an array, or -1 if not found
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }
    
    public int[] mergeArrays(int[] arr1, int[] arr2){
        // Write a method that merges two arrays into one and returns the new array
        int[] mergedArr = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, mergedArr, 0, arr1.length);
        System.arraycopy(arr2, 0, mergedArr, arr1.length, arr2.length);
        return mergedArr;
    }
}
