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
        REPORT_MESSAGE(2);

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
            if (method.getReportMessage() != ""){
                System.out.println(method.getReportMessage());
            }  
        }
    }

    public static void report(String name, boolean pass, IndentationLevel indentationLevel){
        StringBuilder report = new StringBuilder();
        report.append(pass ? ColorCodes.GREEN.code : ColorCodes.YELLOW.code);
        for (int i = 0; i < indentationLevel.level; i++) report.append("\t");
        report.append(name + ": ");
        report.append(pass ? "PASS" : "FAIL");
        report.append(ColorCodes.RESET.code);

        System.out.println(report.toString());
    }

    // CHANGE TO GET FORMAT
    public static String formatErrorMessage(String errorMessage){
        StringBuilder report = new StringBuilder();
        report.append(ColorCodes.RED.code);
        for (int i = 0; i < IndentationLevel.REPORT_MESSAGE.level; i++) report.append("\t");
        report.append("ERROR: " + errorMessage.toString());
        report.append(ColorCodes.RESET.code);

        return report.toString();
    }

    public static String formatTestCaseReport(Object[][] testCases, boolean[] passedTestCases, String[] errorMessages){
        StringBuilder report = new StringBuilder();
        for (int i = 0; i < testCases.length; i++){
            report.append(passedTestCases[i] ? ColorCodes.GREEN.code : ColorCodes.RED.code);
            for (int l = 0; l < IndentationLevel.REPORT_MESSAGE.level; l++) report.append("\t");
            report.append("{" );
            for (int p = 0; p < testCases[i].length; p++){
                report.append(testCases[i][p].getClass().getSimpleName().toUpperCase() + ":");
                report.append(testCases[i][p]);
                if (p < testCases[i].length - 1) report.append(", ");
            }
            report.append(passedTestCases[i] ? "}: PASS" : "}: FAIL (" + errorMessages[i] + ")");
            report.append(ColorCodes.RESET.code);
            if (i < testCases.length - 1) report.append("\n");
        }
        return report.toString();
    }
}
