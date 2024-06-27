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

        private final String code;

		ColorCodes(String code) {
			this.code = code;
		}

		public String getCode() {
			return code;
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
        report(fileName, fileIsValid, 0);

        for (ValidatedMethod method : methods){
            report(method.getMethodName(), method.isMethodValid(), 1);
        }
    }

    private static void report(String name, boolean pass, int indentationLevel){
        StringBuilder report = new StringBuilder();
        report.append(pass ? ColorCodes.GREEN.getCode() : ColorCodes.RED.getCode());
        for (int i = 0; i < indentationLevel; i++){
            report.append("\t");
        }
        report.append(name + ": ");
        report.append(pass ? "PASS" : "FAIL");
        report.append(ColorCodes.RESET.getCode());

        System.out.println(report.toString());
    }

}
