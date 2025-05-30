import java.util.*;

public class YutEngine {
    private CentralEngine central;

    private String testingStr;
    
    //launch()에서 스위치 조작용 변수
    private int switchnum;

    //플레이어 정보 저장 변수
    private int PlayerNum;
    private List<Player> players;

    //보드 전용 변수
    private int sideNum;
    private Board board;

    private Board_Interface BoardUi;
    private PlayerPanel_Interface playerPanel;
    



    public YutEngine(){
        switchnum = 0;
        players = new ArrayList<>();
    }

    public void launch(){
        
        switch (switchnum) {
            case 0:
                //setting game
                //윷 던지기 버튼 disabled
                central.sendStringToOutputEngine("==== 윷놀이 Player Setting ====");
                getPlayers();
                break;
            case 1:
                //게임 세팅
                central.sendStringToOutputEngine("==== 윷놀이 Game Setting ====");
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
                    if(tempInt <= 1){
                        central.sendStringToOutputEngine("2 이상의 수를 입력하세요");
                        return;
                    }
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
            central.sendStringToOutputEngine("모든 플레이어 입력이 완료되었습니다.");
            for (int i = 0; i < index; i++){
                central.sendStringToOutputEngine(players.get(i).getName());
            }
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
                players.add(p);
                playerPanel.updatePlayerPanel(players);
                central.sendStringToOutputEngine((index + 1)+ "번 플레이어 \""+p.getName() + "\" 추가 완료.");
                addPlayers(cAdd1, index+1, pNum);
            }
        });
    }

    public void setGame(){
        central.sendStringToOutputEngine("변의 수를 입력하세요");

        central.setYutCallBack(new CentralEngine.YutCallback() {
            @Override
            public void onInput(CentralEngine c1){
                try{
                    int tempInt = Integer.parseInt(central.getString());
                    if(tempInt <= 2){
                        central.sendStringToOutputEngine("3 이상의 수를 입력하세요");
                        return;
                    }
                    central.sendStringToOutputEngine("변의 수: " + tempInt);
                    sideNum = tempInt;
                    drawBoard(c1, sideNum);
                    
                } catch (NumberFormatException e){
                    central.sendStringToOutputEngine("정수를 입력하세요.");
                }
                
                
                
            }
        });
    }

    public void drawBoard(CentralEngine centralEngine, Integer sideNum){
        //보드의 접근 경로를 알아야 한다.

        this.board = new Board(sideNum);
        BoardUi.setBoard(board);    
        //BoardUI(=BoardPanel)이 board를 자신의 this.board로 가지게 되었다.
        //이제 

        //여기서 직접 보드ui를 업데이트 하는 게 아니다. 센트럴에게 요청을 하고, 센트럴이 로직에게..
        //결국 연결하는 선은 있어야 한다. 프로그램 내에 보드가 2개 이상 있을 수도 있는데,
        //어느 보드의 ui를 업데이트 하는지는 알아야 할 거 아니냐.
        //특정 보드의 ui와 지금 이 함수는 연결되어야 하는 게 맞다.
        //연결의 방식만 조금 고민하면 된다.
        //지금 로직이 ui를 모른다. LogicEngine은 Window를 모른다.
        //inputEngine, OutputEngine에게 ui쪽 핸들러를 연결하기 위해 inputPanel, outputPanel만 알고 있다.
        //그렇다면 같은 방식으로 해야 하나? 아니다. 이번엔 반대다.
        //로직에서 보드 객체를 만들고, 이에 따라서 ui가 바뀌어야 한다.
        //YutEngine에서 update인터페이스 메소드를 사용할 수 있어야 한다.
        //

        
        //BoardUi.
        central.sendStringToOutputEngine("게임보드가 생성되었습니다.");
        launch();


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

    //================ 필요한 함수들 ================

    public void setCentralEngine(CentralEngine centralEngine){
        this.central = centralEngine;
    }

    public void setSwitchNum(Integer number){
        this.switchnum = number;
    }

    public Board getBoard(){
        return board;
    }
    
    public void setBoardUI(Board_Interface BoardUI){
        this.BoardUi = BoardUI;
    }

    public void setPlayerPanel(PlayerPanel_Interface playerPanel){
        this.playerPanel = playerPanel;
    }
}