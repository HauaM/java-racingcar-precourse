# 자동차 경주 게임

## 기능목록
* 사용자정보(자동차이름, 반복횟수)를 비지니스 로직에 맞게 Warpping하여 입력받는다.
* 랜덤 인수(0~9)에 대한 전진혹은정지를 판단한다.
* 입력받은 자동차이름과 자동차의 진행상태를 자료구조에 담는다.
* 최종 결과값을 1급컬렉션으로 만들어서 원본값 변경없이 필요한 값만을 가공출력 한다.

## 파일구조
* Controller
  * GameStartController : 게임을 시작하기 위한 input값들을 입력받는다.
  * RepeatGameStartController : 입력받은 값을 가지고 게임을 유저가 입력한 만큼 반복한다.
* Model
  * CerfStatusEnum : 공통으로 쓰일 ERROR 코드에 대한 Enum이다.
  * StatusEnum : 게임진행 상태에 대한 Enum이다.
  * UserInputCarName : 자동차이름을 사용자에 입력 받고 비지니스에 필요하게 Warpping한다.
  * UserInputRepeatNumber : 게임의 반복횟수를 사용자에게 입력받고 비지니스에 필요하게 Warpping한다.
  * StatusGoAndStop : 랜덤인수를 받고 거기에 해당되는 go와 stop을 판단한다.
  * GameStatusList : 게임의 최종 결과값을 1급 컬렉션으로 지정하고 필요한 값을 가공하여 반환한다.
* View
  * InputView : 입력을 받기 위한 뷰
  * OutputView : 게임내용과 게임결과를 출력해주기 위한 뷰
