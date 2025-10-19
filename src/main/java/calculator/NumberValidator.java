package calculator;

public class NumberValidator {
    static int processStringNumber(String[] tokenList) {
        int result = 0;

        for (String token : tokenList) {
            token = token.trim();
            try {
                if(token.isBlank()) throw new NumberFormatException();
                int parsedToken = Integer.parseInt(token);

                if(parsedToken <= 0) throw new NumberFormatException();
                else result += parsedToken;
            }
            catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid Input data");
            }
        }
        return result;
    }

}
