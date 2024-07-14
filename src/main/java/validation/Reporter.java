package validation;

public class Reporter {
    
    public enum ColorCodes{

        GREEN("\033[0;32m"),
        RED("\033[0;31m"),
        WHITE("\033[0;37m"), 
        BLACK("\033[0;30m"),
        YELLOW("\033[0;33m"),
        BLUE("\033[0;34m"),
        CYAN("\033[0;36m"),
        PURPLE("\033[0;35m"),
        RESET("\033[0m");

        public final String code;

		ColorCodes(String code) {
			this.code = code;
		}
    }

    public enum IndentationLevel{
        
        FILE(0),
        METHOD(1),
        ERROR_MESSAGE(2);

        public final int level;

        IndentationLevel(int level){
            this.level = level;
        }
    }

    public static void reportFile(String fileName, ValidatedMethod[] methods){
        boolean fileIsValid = true;
        for (ValidatedMethod method : methods){
            if (!method.isMethodValid()){
                fileIsValid = false;
                break;
            }
        }
        report(fileName, fileIsValid, IndentationLevel.FILE);

        for (ValidatedMethod method : methods){
            report(method.getMethod().getName(), method.isMethodValid(), IndentationLevel.METHOD);
            if (method.getErrorMessage() != ""){
                reportErrorMessage(fileName);
            }  
        }
    }

    public static void report(String name, boolean pass, IndentationLevel indentationLevel){
        StringBuilder report = new StringBuilder();
        report.append(pass ? ColorCodes.GREEN.code : ColorCodes.RED.code);
        for (int i = 0; i < indentationLevel.level; i++){
            report.append("\t");
        }
        report.append(name + ": ");
        report.append(pass ? "PASS" : "FAIL");
        report.append(ColorCodes.RESET.code);

        System.out.println(report.toString());
    }

    public static void reportErrorMessage(String errorMessage){
        StringBuilder report = new StringBuilder();
        report.append(ColorCodes.YELLOW.code);
        for (int i = 0; i < IndentationLevel.ERROR_MESSAGE.level; i++){
            report.append("\t");
        }
        report.append("ERROR: " + errorMessage.toString());
        report.append(ColorCodes.RESET.code);

        System.out.println(report.toString());
    }

    /*-
    public static void reportTestCase(Object[] testCase, boolean pass){
        StringBuilder report = new StringBuilder();
        report.append(pass ? ColorCodes.GREEN.code : ColorCodes.RED.code);
        for (int i = 0; i < IndentationLevel.TESTCASE.level; i++){
            report.append("\t");
        }
        report.append("The test case of " + testCase.toString() + " ");
        report.append(pass ? "PASSES" : "FAILS");
        report.append(ColorCodes.RESET.code);

        System.out.println(report.toString());
    }
    */
}
