public class SwingAppUI implements ApplicationUI{
    //로직단계
    //엔진을 모두 생성, 연결하는 클래스
    //UI구성은 Window.java의 역할
    private LogicEngine logicEngine;
    private UI_Connection_Interface hub;
    private OutputPanel outputPanel;
    private InputPanel inputPanel;
    private Window window;
    
    public SwingAppUI(){
        //inputPanel = new InputPanel(); //<--핸들러
        //outputPanel = new OutputPanel();


        //허브 생성
        hub = new UI_Connection_Interface();

        //로직 생성 + 허브 연결
        logicEngine = new LogicEngine();
        hub.setLogicEngine(logicEngine);

        //윈도우 생성 + 허브 연결
        window = new Window();
        hub.setUI(window);

        hub.connectUI();
        //inputPanel.setInputEngine(logicEngine.getInputEngine());
        //패널들을 만들고 로직엔진에만 연결한 상태
        
        hub.launchYut();


        //window = new Window(inputPanel, outputPanel);
        //window에서 YutEngine까지 접근해서 .setBoardPanel을 해야 하는 상태
        //예상 코드
        //window.setLogicEngine(logicEngine);
        //BoardPanel에서) this.logicEngine.centralEngine.yutEngine.setBoardPanel(this);
        //window.setLogicEngine(logicEngine);

        //Testing
        //1. App레벨에서 inputPanel에 스트링값 주기: 작동
        //inputPanel.handle("hi");

        //2. 로직엔진에서 아웃풋엔진에게 직접 명령하기: 작동
        //engine.getOutputEngine().showMessage("hi2");






        //UI생성후, UI에 패널, 로직엔진을 연결해야 한다.
        //아니다! 로직엔진을 연결할 필요 없다. 핸들러만 연결하면 된다!

        //아래 거는 전부 틀린 거다!
        //window.setLogicEngine(engine); <--이거 이렇게 하면 순서가 안 맞을 거 같은데?
        //로직엔진을 Window에게 전달했으니, 남은 건 UI구성, 그리고
        //Window클래스 내부에서 로직엔진의 패널들을 InOutSection에게 세팅해줘야 한다.

        
    }

    

    @Override
    public void launch(){
        
    }
}
