package model;

public class StatusGoAndStop {
    public static final int BOUNDARY_VALUE = 4;
    public static final int MAX_INT = 9;
    public static final int MIN_INT = 0;
    private static String status = "";

    //랜덤숫자에 대한 자동자차의 상태값을 반환한다.
    public StatusGoAndStop(int randomNumer) {
        if(randomNumer >= BOUNDARY_VALUE && randomNumer <= MAX_INT) {
            this.status = StatusEnum.GO;
        }
        if(randomNumer < BOUNDARY_VALUE && randomNumer >= MIN_INT){
            this.status = StatusEnum.STOP;
        }
    }

    public static String getStatus(){
        return status;
    }
}
