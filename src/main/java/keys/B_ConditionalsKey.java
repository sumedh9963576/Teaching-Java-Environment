package keys;

public class B_ConditionalsKey {

    public B_ConditionalsKey(){}

    public boolean isPositive(int number){
        // returns if a number is positive
        return number > 0;
    }

    public boolean isEven(int num){
        //  Check if a number is even or not and return that value
		return num % 2 == 0;
    }

    public boolean canVote(int age){
        // Return if a person can vote (age >= 18)
        return age >= 18;
    }

    public String dayName(int day){
        // Write a switch statement that checks the value of a variable 'day' (1-7) and prints the name of that day
        // Return "Invalid Day" if the value doesn't corospond to any day
        switch(day){
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
            default:
                return "Invalid day";
        }
    }

    public boolean withinSetRange(double number){
        // Write an if statement that checks if a number is between 10 and 20 (inclusive)
        return number >= 10 && number <= 20;
    }

    public boolean withinRange(double number, double lowerBound, double upperBound){
        // Check if a number is between an upper and lower bound (inclusive)
        return number >= lowerBound && number <= upperBound;
    }

    public boolean isErrorAcceptable(double number1, double number2, double acceptableError){
        // Check if the difference between numbers 'number1' and 'number2' is under the acceptable error (non inclusive)
        return Math.abs(number1 - number2) < acceptableError;
    }

    public char letterGrade(double score){
        // Return the letter grade (A,B,C,D,F)of a variable 'score' as a character
        if(score >= 90){
            return 'A';
        } else if(score >= 80){
            return 'B';
        } else if(score >= 70){
            return 'C';
        } else if(score >= 60){
            return 'D';
        } else {
            return 'F';
        }
    }

    public boolean isLeapYear(int year){
        // Return if the variable 'year' is a leap year
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public String monthName(int month){
        // Write a switch statement that checks the month number and prints the corresponding month name
        // Return "Invalid Month" if the value doesn't corospond to any month
        switch(month){
            case 1: return "January";
            case 2: return "Feuary";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: return "Invalid Month"; 
        }
    }

    public String positiveOrNegative(double number){
        // Return if a number is "positive", "negative", or "zero"
        if(number > 0){
            return "positive";
        } else if(number < 0){
            return "negative";
        } else {
            return "zero";
        }
    }

    public boolean isDivisable(int number){
        // Return if a number is divisible by both 3 and 5
        return number % 3 == 0 && number % 5 == 0;
    }

    public boolean isDivisableBy(int number, int[] divisors){
        // Return if a number is divisible by all posible values inside of 'divisors'
        for (int divisor : divisors){
            if (number % divisor != 0) return false;
        }
        return true;
    }

    public boolean isVowel(char letter){
        // Return if a character is a vowel or not
        return letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U' ||
           letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u';        
    }

    public String lifeStage(int age){
        // Write an if statement that checks if a person is a "Child", a "Teenager", or an "Adult" (over 20 inclusive)
        if(age < 13){
            return "Child";
        } else if(age < 20){
            return "Teenager";
        } else {
            return "Adult";
        }
    }
}

