package model;

import java.util.*;

/**
 * 게임의 상태를 보관하고 있는 1급 컬랙션
 */
public class GameStatusList {
    public static final int INIT_NUMBER = 0;
    private Map<String,Integer> gameStatusList;

    public GameStatusList(List<Map> gamingStatus) {
        this.gameStatusList = gamingStatus.get(getGamingStatusListIndex(gamingStatus));

    }

    public int getGamingStatusLength() {
        return this.gameStatusList.size();
    }
    
    //gamingStatus의 마지막 배열 넘버를 반환한다.
    private int getGamingStatusListIndex(List<Map> gamingStatus){
        return  gamingStatus.size() - 1;
    }

    //정렬하여 가장 큰 값을 찾는다.
    public int biggestNumber (){
        List<Integer> statusList = setValueList();
        statusList.sort(Comparator.reverseOrder());
        return statusList.get(INIT_NUMBER);
    }

    //Map을 list 형태로 변환해준다.
    private List setValueList() {
        ArrayList<Integer> status = new ArrayList<>();
        this.gameStatusList.forEach((key,value) -> status.add(value));
        return status;
    }

    //승자리스트를 반환한다.
    public ArrayList<String> getVictorList(){
        int biggestNumber = biggestNumber();

        ArrayList<String> victorList = new ArrayList();

        Iterator iterator = this.gameStatusList.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> entry = (Map.Entry)iterator.next();
            victorList.add(compareValue(entry.getKey(), entry.getValue(), biggestNumber));
        }
        return victorList;
    }

    //승자정보를 찾는다.
    private String compareValue(String key, int value, int biggestNumber){
        String victor = "";

        if(biggestNumber == value){
            victor = key;
        }

        return victor;
    }
}
