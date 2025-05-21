import java.util.*;

public class YutEngine {
    private InputEngine inputEngine;
    private OutputEngine outputEngine;
    private Callback callback;

    int switchnum = 0;
    int PlayerNum;
    List<Player> players;


    public YutEngine(InputEngine inputEngine, OutputEngine outputEngine){
        this.inputEngine = inputEngine;
        this.outputEngine = outputEngine;
    }

    public void launch(){
        if (switchnum == 0) {
            outputEngine.showMessage("게임을 시작합니다");

        }
        
        switch (switchnum) {
            case 0:
                getPlayers();
                break;
            case 1:
                setGame();
        
            default:
                break;
        }
    }

    public void getPlayers(){
        outputEngine.showMessage("플레이어의 수를 입력하세요");
        //여기서 뭘 호출? or 실행하고 입력 대기

    }

    public void setGame(){
        outputEngine.showMessage("보드의 변의 수를 입력하세요:");
    }
}
