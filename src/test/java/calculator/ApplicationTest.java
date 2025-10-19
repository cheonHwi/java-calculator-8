package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
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

    @Test
    void 구분자_단일_구분자_검증() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 구분자_복수_구분자_검증() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 구분자_잘못된_구분자_검증() {
        assertThatThrownBy(() -> runException("1,2'3"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 덧셈_음수_예외() {
        assertThatThrownBy(() -> runException("1,2,-3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 덧셈_입력값_0일때_예외() {
        assertThatThrownBy(() -> runException("1,2,0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
