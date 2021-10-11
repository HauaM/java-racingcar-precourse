package model;

import view.InputView;

import java.util.*;

public class UserInputCarNames {
    private String chkString = CerfStatusEnum.NORMER;
    private String userInputCarNames;
    private String[] carNames;

    //사용자가 입력한 이름의 숫자를 담고 있다.
    public int usrInputNameCount = 0;

    //사용자가 입력한 값을 분리하여 각각 검증 후 값을 반환한다.
    public UserInputCarNames() {
        try {
            this.carNames = seperateName(InputView.carName());
            validationNameLength(this.carNames);
            chkNameDuplicate(this.carNames);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //검증을 위해 사용자가 입력한값을 String[]배열 형태로 반환한다.
    private String[] seperateName(String userInputCarNames) {
        return userInputCarNames.split(",");
    }

    //사용자가 모든 자동차이름 길이를 차례대로 검증한다.
    public void validationNameLength(String[] names) {

        ArrayList<Boolean> chkValue = new ArrayList<>();
        for (String name : names) {
            chkValue.add(Car.validNameLength(name));
        }
        if (chkValue.contains(false)) {
            this.chkString = CerfStatusEnum.ERROR;
            throw new IllegalArgumentException("[ERROR] 자동차이름은 1~5글자까지만 입력가능합니다.");
        }
    }

    //사용자가 입력한이름의 값의 ERROR여부 물어본다.
    //인스턴스 변수에 직접 접근하는건 최대한 방지한다.
    public String chkStringIsErr() {
        String result = CerfStatusEnum.NORMER;

        if (this.chkString.equals(CerfStatusEnum.ERROR)) {
            result = CerfStatusEnum.ERROR;
        }

        return result;
    }

    //검증을 위해 사용자가 입력한 이름의 숫자를 카운트 한다.
    public int userInputNameCount() {
        String[] str = this.userInputCarNames.split(",");
        return str.length;
    }

    //자동차 이름에 중복값이 있는지 확인
    public void chkNameDuplicate(String[] args) {
        List<String> stringList = Arrays.asList(args);
        Set<String> verifySet = new HashSet<>(stringList);//set은 중복을 허용하지 않는다.

        if (verifySet.size() != args.length) {
            this.chkString = CerfStatusEnum.ERROR;
            throw new IllegalArgumentException("[ERROR]자동차 이름이 중복되었습니다. 다시 입력해주세요.");
        }
    }

    public String[] getCarNames() {
        return this.carNames;
    }
}
