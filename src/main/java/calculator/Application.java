package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
        public static void main(String[] args) {
            String delimiter = "[,:]";

            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();

            String[] tokenList = input.split(delimiter);


            for (String token : tokenList) {
                System.out.println(token);
            }
        }
}
