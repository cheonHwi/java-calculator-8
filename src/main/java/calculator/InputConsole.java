package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

//Console.readLine()에서 빈 값이 들어왔을 때 NoSuchElementException이 발생함을 확인
//    - 빈 입력값도 사용자가 의도할 수 있다고 판단되어 예외 처리 로직 구현
//    - 이 과정에서 같은 로직이 반복적으로 작성되지 않도록 Console.readLine() 메서드를 래핑

public class InputConsole {
    public static String readLine() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            return "";
        }
    }
}
