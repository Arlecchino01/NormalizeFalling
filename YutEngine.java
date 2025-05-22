import java.util.*;

public class YutEngine {
    private CentralEngine central;

    private String testingStr;
    
    private int switchnum = 0;
    private int PlayerNum;
    List<Player> players;

    public void launch(){
        
        switch (switchnum) {
            case 0:
                central.sendStringToOutputEngine("==== 윷놀이 Game Start ====");
                getPlayers();
                break;
            case 1:
                central.sendStringToOutputEngine("==== 턴 시작! ====");
                setGame();
                break;
            case 2:
                initializeCallback();
                break;
            default:
                initializeCallback();
                break;
        }
    }

    //================ 각 스테이지에 맞게 오버라이딩한 콜백 함수들  ================

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
                    addPlayers(tempInt);
                    setSwitchNum(1);
                } catch (NumberFormatException e){
                    central.sendStringToOutputEngine("정수를 입력하세요.");
                }
                
                launch();
            }
        });
    }

    public void addPlayers(Integer num){
        this.PlayerNum = num;
        central.setYutCallBack(new CentralEngine.YutCallback() {
            @Override
            public void onInput(CentralEngine centralEngine){
                central.sendStringToOutputEngine("am i activated");
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
