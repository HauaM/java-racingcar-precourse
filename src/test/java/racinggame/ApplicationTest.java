package racinggame;

import model.*;
import nextstep.test.NSTest;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

public class ApplicationTest extends NSTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final String ERROR_MESSAGE = "[ERROR]";

    @BeforeEach
    void beforeEach() {
        setUp();
    }

    @Test
    void 전진_정지() {
        assertRandomTest(() -> {
            run("pobi,woni", "1");
            verify("pobi : -", "woni : ", "최종 우승자는 pobi 입니다.");
        }, MOVING_FORWARD, STOP);
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() -> {
            runNoLineFound("pobi,javaji");
            verify(ERROR_MESSAGE);
        });
    }

    /**
     * 경계값 테스트
     * 입력 6 - > 검증 false
     * 입력 5 - > 검증 true
     * 입력 0 - > 검증 false
     * 입력 1 - > 검증 true
     */
    @Test
    @DisplayName("자동자 이름 5글자 확인")
    void 자동차이름5글자확인() {
        assertThat(Car.validNameLength("123456")).isFalse();
        assertThat(Car.validNameLength("12345")).isTrue();
        assertThat(Car.validNameLength("")).isFalse();
        assertThat(Car.validNameLength("1")).isTrue();
    }

    /**
     * 경계값 테스트
     * 입력 [a, bbbbbb ] -> 검증 true
     */
    @Test
    @DisplayName("모든 이름들이 규칙에 맞게 들어왔는지 확인")
    void 자동차이름검증기능확인() {
        UserInputCarNames userInputCarNames = new UserInputCarNames();

        userInputCarNames.validationNameLength((new String[]{"a", "bbbbb"}));
        assertThat(userInputCarNames.chkStringIsErr()).isEqualTo(CerfStatus.NORMER);
    }

    @Test
    @DisplayName("이름 잘못 입력했을 때 예외 처리나오는지에 대한 검증")
    void 이름_예외처리_테스트() {
        UserInputCarNames userInputCarNames = new UserInputCarNames();

        assertThatThrownBy(() -> {
            userInputCarNames.validationNameLength((new String[]{"aaaaaa"}));
        }).isInstanceOf(Exception.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 최종자동차상테확인_0() {
        int[] randomValues = new int[]{1, 1, 3, 3, 3};
        int count = 0;
        for (int i = 0; i < randomValues.length; i++) {
            new StatusGoAndStop(randomValues[i]);
            if (StatusGoAndStop.getStatus().equals(StatusEnum.GO)) {
                count++;
            }
        }
        assertThat(count).isEqualTo(0);
    }

    @Test
    void 최종자동차상테확인_4() {
        int[] randomValues = new int[]{1, 2, 3, 4, 5, 9, 9};
        int count = 0;
        for (int i = 0; i < randomValues.length; i++) {
            new StatusGoAndStop(randomValues[i]);
            if (StatusGoAndStop.getStatus().equals(StatusEnum.GO)) {
                count++;
            }
        }
        assertThat(count).isEqualTo(4);
    }

    /**
     * String 0 -> null
     * String -1 -> null
     * String param -> null
     * String 1 -> int 1
     */
    @Test
    @DisplayName("숫자를 재대로 입력했는지 확인")
    void 숫자입력_테스트() {
        assertThat(UserInputRepeatNumber.wrappingRepeatNumber("0")).isNull();
        assertThat(UserInputRepeatNumber.wrappingRepeatNumber("-1")).isNull();
        assertThat(UserInputRepeatNumber.wrappingRepeatNumber("StringType")).isNull();
        assertThat(UserInputRepeatNumber.wrappingRepeatNumber("1")).isEqualTo(1);
    }

    /**
     * {"test", "test1"} -> true
     */
    @Test
    @DisplayName("차 이름 중복확인")
    void 자동차이름_중복_체크() {
        UserInputCarNames userInputCarNames = new UserInputCarNames();
        userInputCarNames.chkNameDuplicate(new String[]{"test", "test1"});
        assertThat(userInputCarNames.chkStringIsErr()).isEqualTo("NORMER");
    }

    /**
     * {"test", "test"} -> false
     */

    @Test
    @DisplayName("자동차이름을 중복으로 입력햇을 때 나오는 오류")
    void 자동차이름_중복_예외처리_테스트() {
        UserInputCarNames userInputCarNames = new UserInputCarNames();

        assertThatThrownBy(() -> {
            userInputCarNames.chkNameDuplicate(new String[]{"test", "test"});
        }).isInstanceOf(Exception.class)
                .hasMessageContaining("중복");
    }

    @AfterEach
    void tearDown() {
        outputStandard();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
