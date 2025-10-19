package calculator;

import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        String delimiter = "[,:]";
        int result = 0;

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = InputConsole.readLine();
        if(input.isBlank()) return;

        if (input.startsWith("//")) {
            int delimiterEnd = input.indexOf("\\n");
            if (delimiterEnd == -1) {
                throw new IllegalArgumentException("Invalid Delimiter format");
            }

            String customDelimiter = input.substring(2, delimiterEnd);
            if(customDelimiter.length() != 1)
                throw new IllegalArgumentException("Custom Delimiter length must be 1");

            delimiter = "[,:|" + Pattern.quote(customDelimiter) + "]";
            input = input.substring(delimiterEnd + 2);
        }

        String[] tokenList = input.split(delimiter);

        for (String token : tokenList) {
            try {
                int parsedToken = Integer.parseInt(token);
                if(parsedToken <= 0) throw new NumberFormatException();
                else result += parsedToken;
            }
            catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid Input data");
            }
        }

        System.out.println("결과 : " + result);
        }
}
