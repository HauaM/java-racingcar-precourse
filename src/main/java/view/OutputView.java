package view;

import java.util.ArrayList;

public class OutputView {
    //해당 라운드의 게임상태 출력
    public static void thisGameState(String carName, Integer status) {
        System.out.println(carName + " : " + intToString(status));
    }

    //출력을 위한 포멧팅
    private static String intToString(int status){
        String ouputString = "";
        for(int i = 0 ; i < status ; i++){
            ouputString = ouputString + "-";
        }
        return ouputString;
    }

    //최종 우승자 출력 메시지
    public static void gameEnd(ArrayList<String> victorList) {
        System.out.println("최종 우승자는 " + arrayListToString(victorList) + " 입니다." );
    }
    private static String arrayListToString(ArrayList<String> victorList){
        String outputStirng = "";
        for(String victor : victorList){
            outputStirng = isNotEmptyValue(outputStirng, victor);
        }

        return outputStirng.substring(1, outputStirng.length());
    }

    //출력을 위해 String을 포멧팅한다.
    private static String isNotEmptyValue(String outputStirng, String victor) {
        if(!"".equals(victor))
            outputStirng = outputStirng + "," + victor;
        return outputStirng;
    }

    //공백 라인을 그려준다
    public static void emptyLine() {
        System.out.println();
    }
}
