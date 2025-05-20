import java.util.*;

public class YutEngine {
    private InputEngine inputEngine;
    private OutputEngine outputEngine;

    int switchnum;
    int PlayerNum;
    List<Player> players;


    public YutEngine(InputEngine inputEngine, OutputEngine outputEngine){
        this.inputEngine = inputEngine;
        this.outputEngine = outputEngine;
    }

    public void launch(){
        outputEngine.showMessage("게임을 시작합니다");
        switchnum = 0;
        
    }

    public void getPlayers(){
        outputEngine.showMessage("플레이어의 수를 입력하세요");
    }

    public void setGame(){
        outputEngine.showMessage("보드의 변의 수를 입력하세요:");
    }
}
