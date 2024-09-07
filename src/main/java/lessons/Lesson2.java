package lessons;

public class Lesson2 {

	public Lesson2(){}

	public double exercise1(){
		// return a value of 8.0
		return 8.0;
	}

	public String exercise2(){
		// return the text "Hello World"
		return "Hello World";
	}

	public boolean exercise3(){
		// return false
		return false;
	}

	public double exercise4(boolean trueOrFalse){
		// return 2.0 if the variable 'trueOrFalse' is true, and return 4.0 if it is false
		if (trueOrFalse){
			return 2.0;
		} else {
			return 4.0;
		}
	}

	public boolean isEven(int number){
		// return true if the variable 'number' is even, and return false if it is odd
		return number%2 == 0;
	}
}