import java.util.*;

public class YutEngine {
    private CentralEngine central;

    int switchnum = 0;
    int PlayerNum;
    List<Player> players;

    

    public void launch(){
        if (switchnum == 0) {


            central.sendStringToOutputEngine("Yut Game Start");

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
        central.sendStringToOutputEngine("플레이어 수를 입력하세요");

        central.setYutCallBack(new CentralEngine.YutCallback() {
            @Override
            public void onInput(CentralEngine centralEngine){
                central.sendStringToOutputEngine("I got: ");
                central.sendStringToOutputEngine(central.getString());
                switchnum = 1;
            }
        });
    }

    public void setGame(){
        central.setYutCallBack(new CentralEngine.YutCallback() {
            @Override
            public void onInput(CentralEngine centralEngine){
                central.sendStringToOutputEngine("2nd");
            }
        });
    }

    public void setCentralEngine(CentralEngine centralEngine){
        this.central = centralEngine;
    }





}
