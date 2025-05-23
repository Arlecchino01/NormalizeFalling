import java.util.*;

public class YutEngine {
    private CentralEngine central;

    private String testingStr;
    
    private int switchnum;
    private int PlayerNum;
    List<Player> players;

    public YutEngine(){
        switchnum = 0;
        players = new ArrayList<>();
    }

    public void launch(){
        
        switch (switchnum) {
            case 0:
                //setting game
                //윷 던지기 버튼 disabled
                central.sendStringToOutputEngine("==== 윷놀이 Game Start ====");
                getPlayers();
                break;
            case 1:
                //게임 세팅
                //윷 던지기 
                central.sendStringToOutputEngine("==== 턴 시작! ====");
                setGame();
                break;
            case 2:
                initializeCallback();
                break;
            case 109:
                central.sendStringToOutputEngine("==== Entered Testing Mode ====");
                test();
                break;
            default:
                initializeCallback();
                break;
        }
    }

    //================ 각 스테이지에 맞게 오버라이딩한 콜백 함수들  ================

    public void test(){
        central.setYutCallBack(new CentralEngine.YutCallback() {
            @Override
            public void onInput(CentralEngine centralEngine){
                String str1 = central.getString();
                central.sendStringToOutputEngine(str1);

                centralEngine.setYutCallBack(new CentralEngine.YutCallback() {
                    @Override
                    public void onInput(CentralEngine centralEngine){
                        central.sendStringToOutputEngine("제대로 되냐...");
                    }
                });

            }
        });
    }
    
    
    public void initializeCallback(){
        central.setYutCallBack(new CentralEngine.YutCallback() {
            @Override
            public void onInput(CentralEngine centralEngine){
            }
        });
    }

    public void getPlayers(){
        central.sendStringToOutputEngine("플레이어 수를 입력하세요");

        central.setYutCallBack(new CentralEngine.YutCallback() {
            @Override
            public void onInput(CentralEngine centralEngine){
                try{
                    int tempInt = Integer.parseInt(central.getString());
                    central.sendStringToOutputEngine("플레이어 수: " + tempInt);
                    PlayerNum = tempInt;
                    addPlayers(centralEngine, 0, PlayerNum);
                } catch (NumberFormatException e){
                    central.sendStringToOutputEngine("정수를 입력하세요.");
                }
            }
        });
    }

    public void addPlayers(CentralEngine centralEngine, Integer index, Integer pNum){
        if (index >= pNum) {
            central.sendStringToOutputEngine("모든 입력이 완료되었습니다.");
            setSwitchNum(1);
            launch();
            return;
        }

        central.sendStringToOutputEngine((index + 1) + "번째 플레이어의 이름을 입력하세요: ");
        
        centralEngine.setYutCallBack(new CentralEngine.YutCallback() {
            @Override
            public void onInput(CentralEngine cAdd1){
                //생성자로 플레이어 생성 + 리스트에 플레이어 추가하는 거 구현
                Player p = new Player(central.getString());
                central.sendStringToOutputEngine("추가 완료.");
                addPlayers(cAdd1, index+1, pNum);
            }
        });
    }

    public void setPieces(){
        central.sendStringToOutputEngine("말의 수를 입력하세요");
        central.setYutCallBack(new CentralEngine.YutCallback() {
            @Override
            public void onInput(CentralEngine c1){                
                try{
                    int tempInt = Integer.parseInt(central.getString());
                    central.sendStringToOutputEngine("말의 수: " + tempInt);
                    //생성자로 말 생성, 리스트의
                } catch (NumberFormatException e){
                    central.sendStringToOutputEngine("정수를 입력하세요.");
                }
                
            }
        });
    }


    public void setGame(){
        central.setYutCallBack(new CentralEngine.YutCallback() {
            @Override
            public void onInput(CentralEngine centralEngine){
                central.sendStringToOutputEngine("2nd");
                central.sendStringToOutputEngine(central.getString());
                setSwitchNum(2);
                launch();
            }
        });
    }

    //================ 필요한 함수들 ================

    public void setCentralEngine(CentralEngine centralEngine){
        this.central = centralEngine;
    }

    public void setSwitchNum(Integer number){
        this.switchnum = number;
    }

    
    
}
