package model;

public class Car {
    private String carName = "";

    private static final int NAME_MIN_SIZE = 1;
    private static final int NAME_MAX_SIZE = 5;

    public static boolean validNameLength(String carName) {

        if(NAME_MIN_SIZE > carName.trim().length() || NAME_MAX_SIZE < carName.trim().length()){
            return false;
        }
        return true;
    }

}
