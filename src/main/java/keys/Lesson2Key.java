package keys;

public class Lesson2Key {

	public Lesson2Key(){}

	public double exercise1(){
		return 8.0;
	}

	public String exercise2(){
		return "Hello World";
	}

	public boolean exercise3(){
		return false;
	}

	public double exercise4(boolean t){
		if (t){
			return 2.0;
		} else {
			return 4.0;
		}
	}

	public boolean exercise5(double i){
        //double:0,100
		if (i/2.0 > 2.0){
			return true;
		} else {
			return false;
		}
	}
}