package model;

import nextstep.utils.Console;
import view.InputView;

import java.util.ArrayList;

public class UserInputCarNames {
    private String chkString = NameCerfStatus.NORMER;
    private String userInputCarNames = "";

    //사용자가 입력한 이름의 숫자를 담고 있다.
    public int usrInputNameCount = 0;

    //사용자가 입력한 값을 분리하여 각각 검증 후 값을 반환한다.
    public UserInputCarNames() {
        String localUserInputName = "";
        try{
            String[] names = seperateName(InputView.carName());
            validationNameLength(names);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        this.userInputCarNames = localUserInputName;
    }

    //검증을 위해 사용자가 입력한값을 String[]배열 형태로 반환한다.
    private String[] seperateName(String userInputCarNames){
        return userInputCarNames.split(",");
    }

    //사용자가 모든 값을 차례대로 검증한다.
    public void validationNameLength(String[] names) {
        ArrayList<Boolean> chkValue = new ArrayList<>();
        for(String name : names){
            System.out.println("모재윤 테스트 name === " + name);
            chkValue.add(Car.validNameLength(name));
        }
        if(chkValue.contains(false)){
            this.chkString = NameCerfStatus.ERROR;
            throw new IllegalArgumentException("[ERROR] 자동차이름은 1~5글자까지만 입력가능합니다.");
        }
    }

    //사용자가 입력한이름의 값의 ERROR여부 물어본다.
    //인스턴스 변수에 직접 접근하는건 최대한 방지한다.
    public String chkStringIsErr(){
        String result = NameCerfStatus.NORMER;

        if(this.chkString.equals(NameCerfStatus.ERROR)){
            result = NameCerfStatus.ERROR;
        }
        
        return result;
    }

    //사용자가 입력한 이름을 반환한다.
    public String getUserInputCarNames(){
        return this.userInputCarNames;
    }

    //검증을 위해 사용자가 입력한 이름의 숫자를 카운트 한다.
    public int userInputNameCount(){
        String[] str = this.userInputCarNames.split(",");
        return str.length;
    }
}
