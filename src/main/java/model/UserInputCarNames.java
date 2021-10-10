package model;

import nextstep.utils.Console;
import view.InputView;

import java.util.ArrayList;

public class UserInputCarNames {
    public static final String ERROR = "ERROR";
    public static final String NORMER = "NORMER";

    private String chkString = "TRUE";
    private String userInputCarNames = "";

    public UserInputCarNames() {
        String localUserInputName = "";
        try{
            localUserInputName = InputView.CarName();

            String[] names = seperateName(localUserInputName);
            validationNameLength(names);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        this.userInputCarNames = localUserInputName;
    }

    private String[] seperateName(String userInputCarNames){
        return userInputCarNames.split(",");
    }

    public void validationNameLength(String[] names) {
        ArrayList<Boolean> chkValue = new ArrayList<>();
        for(String name : names){
            System.out.println("모재윤 테스트 name === " + name);
            chkValue.add(Car.validNameLength(name));
        }
        if(chkValue.contains(false)){
            this.chkString = ERROR;
            throw new IllegalArgumentException("[ERROR] 자동차이름은 1~5글자까지만 입력가능합니다.");
        }
    }

    public String chkStringIsErr(){
        String result = NORMER;

        if(this.chkString.equals(ERROR)){
            result = ERROR;
        }
        
        return result;
    }

    public String getUserInputCarNames(){
        return this.userInputCarNames;
    }
}
