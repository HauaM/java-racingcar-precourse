package model;

public class StatusGoAndStop {
    public static final int BOUNDARY_VALUE = 4;
    public static final int MAX_INT = 9;
    public static final int MIN_INT = 0;
    private static String status = "";

    //랜덤숫자에 대한 자동자차의 상태값을 반환한다.
    public StatusGoAndStop(int randomNumer) {
        if(randomNumer >= BOUNDARY_VALUE && randomNumer <= MAX_INT) {
            status = StatusEnum.GO;
        }
        if(randomNumer < BOUNDARY_VALUE && randomNumer >= MIN_INT){
            status = StatusEnum.STOP;
        }
    }

    //GO상태인지 확인하여 알려준다.
    //인스턴스 내부 값을 자주 참조하면 안좋음
    public static int isGo(){
        int goState = 0;

        if(status.equals(StatusEnum.GO)){
            goState = 1;
        }

        return goState;
    }
}
