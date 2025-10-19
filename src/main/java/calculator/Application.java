package calculator;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = InputConsole.readLine();
        if(input.isBlank()) return;

        DelimiterResolver.DelimiterResult resultRecord = DelimiterResolver.addCustomDelimiter(input);
        input = resultRecord.input();
        String delimiter = resultRecord.delimiter();

        String[] tokenList = input.split(delimiter, -1);

        System.out.println("결과 : " + NumberValidator.processStringNumber(tokenList));

        }
}
