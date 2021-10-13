package Controller;

import model.CerfStatusEnum;
import model.UserInputCarNames;
import model.UserInputRepeatNumber;

public class GameStartController {

    public static final int ZERO = 0;

    public static void run() {

        //자동차이름 입력받기 Wrapping
        String[] userInputCarNames = nameLengthException();
        //개임횟수 입력받기 Wrapping
        int userInputRepeatNumer = repeatNumberLengthException();

        RepeatGameStartController.gameStart(userInputCarNames, userInputRepeatNumer);
    }

    //자동차 입력의 입력을 위한 Excetption 처리
    private static String[] nameLengthException() {
        String errCode = CerfStatusEnum.ERROR;
        String[] carNames = new String[] {};

        while (CerfStatusEnum.ERROR.equals(errCode)) {
            UserInputCarNames userInputCarNames = new UserInputCarNames();
            carNames = userInputCarNames.getCarNames();
            errCode = userInputCarNames.chkStringIsErr();
        }
        return carNames;
    }

    //반복횟수 입력을 위한 Excetption 처리
    private static int repeatNumberLengthException() {
        String errCode = CerfStatusEnum.ERROR;

        int inputRepeatNumber = ZERO;

        while (CerfStatusEnum.ERROR.equals(errCode)) {
            inputRepeatNumber = UserInputRepeatNumber.getUserInputNumber();
            errCode = UserInputRepeatNumber.getRepeatNumberErrCode();
        }
        return inputRepeatNumber;
    }
}
