package model;

import view.InputView;

public class UserInputRepeatNumber {
    private static String errCode = CerfStatus.NORMER;

    public static int getUserInputNumber() {
        int vailedRepeatNumber = 0;
        errCode = CerfStatus.NORMER;

        Integer paringRepeatNumber = wrappingRepeatNumber(InputView.repeatNumber());

        if (paringRepeatNumber != null){
            return paringRepeatNumber;
        }

        return vailedRepeatNumber;
    }

    public static Integer wrappingRepeatNumber(String repeatNumber) {
        try{
            int paringRepeatNumber = inputStringToInteger(repeatNumber);
            return inputStringBigerThenZero(paringRepeatNumber);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    //숫자형인지 확인하다.
    private static int inputStringToInteger(String repeatNumber) {
        int parsingRepeatNumber = 0;
        try {
            parsingRepeatNumber = Integer.parseInt(repeatNumber);
        } catch (NumberFormatException e) {
            errCode = CerfStatus.ERROR;
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }
        return parsingRepeatNumber;
    }

    //0보다 큰지 확인한다.
    private static int inputStringBigerThenZero(int parsingRepeatNumber) {
        int verifiedRepeatNumber = 0;

        if (parsingRepeatNumber <= 0) {
            errCode = CerfStatus.ERROR;
            throw new IllegalArgumentException("[ERROR] 0보다 큰 회차를 입력해주세요");
        }

        verifiedRepeatNumber = parsingRepeatNumber;

        return verifiedRepeatNumber;
    }

    //사용자가 입력한이름의 값의 ERROR여부 물어본다.
    //인스턴스 변수에 직접 접근하는건 최대한 방지한다.
    public static String getRepeatNumberErrCode() {
        String result = CerfStatus.NORMER;

        if (errCode.equals(CerfStatus.ERROR)) {
            result = CerfStatus.ERROR;
        }

        return result;
    }
}

