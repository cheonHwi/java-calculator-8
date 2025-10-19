package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }


    // 입출력 요구사항 - 구분자와 양수로 구성된 문자열
    @Test
    void 입력값_검증() {
        assertSimpleTest(() -> {
            run("1,2:3");
        });
    }

    @Test
    void 입력값_빈값_검증() {
        assertSimpleTest(() -> {
            run("");
        });
    }

    @Test
    void 입력값_공백_검증() {
        assertSimpleTest(() -> {
            run("   ");
        });
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
