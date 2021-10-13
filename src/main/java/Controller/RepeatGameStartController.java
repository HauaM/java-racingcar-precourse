package Controller;

import model.GameStatusList;
import model.StatusGoAndStop;
import nextstep.utils.Randoms;
import view.OutputView;

import java.util.*;

public class RepeatGameStartController {

    public static final int MIN_INT = 0;
    public static final int MAX_INT = 9;

    /**
     * 지정 횟수만큼 게임을 진행하고 그 결과를 GameStatusList에 저장한다.
     */
    public static void gameStart(String[] userInputCarName, int userInputRepeatNumer) {

        List<String> carNames = Arrays.asList(userInputCarName);

        //모든 게임의 상태가 담겨있다.
        ArrayList<Map> gamingStatus = new ArrayList<>();

        for (int i = 0; i <= userInputRepeatNumer; i++) {
            //게임진행 결과를 담는다.
            gamingStatus.add(sigleGameStatus(carNames, gamingStatus));
            OutputView.emptyLine();
        }

        GameStatusList gameStatusList = new GameStatusList(gamingStatus);

        OutputView.gameEnd(gameStatusList.getVictorList());

    }

    //모든 자동차들이 차례대로 게임을 1판 진행하고 그 결과값을 프린트한다.
    private static Map sigleGameStatus(List<String> carNames, ArrayList<Map> gamingStatus) {
        Map<String, Integer> thisRoundGameState = new HashMap<>();

        for (String carName : carNames) {
            int previousGameStatus = getPreviousStatus(gamingStatus, carName);

            new StatusGoAndStop(Randoms.pickNumberInRange(MIN_INT, MAX_INT));
            int status = previousGameStatus + StatusGoAndStop.isGo();

            thisRoundGameState.put(carName, status);
        }
        thisRoundGameState.forEach((key, value) -> OutputView.thisGameState(key, value));

        return thisRoundGameState;
    }

    //이전까지의 상태 값을 가져온다.
    private static int getPreviousStatus(ArrayList<Map> gamingStatus, String carName) {
        int previousGameStatus = 0;

        if (!gamingStatus.isEmpty()) {
            previousGameStatus = (int) gamingStatus.get(gamingStatus.size() - 1).get(carName);
        }

        return previousGameStatus;
    }
}
