package calculator;

public class Application {
    public static void main(String[] args) {
        String delimiter = "[,:]";
        int result = 0;

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = InputConsole.readLine();
        if(input.isBlank()) return;
        String[] tokenList = input.split(delimiter);

        for (String token : tokenList) {
            try {
                int parsedToken = Integer.parseInt(token);
                if(parsedToken < 0) throw new NumberFormatException();
                else result += parsedToken;
            }
            catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid Input data");
            }
        }

        System.out.println("결과 : " + result);
        }
}
