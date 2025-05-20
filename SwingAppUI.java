public class SwingAppUI implements ApplicationUI{
    //로직단계
    //엔진을 모두 생성, 연결하는 클래스
    //UI구성은 Window.java의 역할
    private LogicEngine engine;
    private OutputPanel outputPanel;
    private InputPanel inputPanel;
    private Window window;
    
    public SwingAppUI(){
        InputPanel inputPanel = new InputPanel(); //<--핸들러
        OutputPanel outputPanel = new OutputPanel();

        LogicEngine engine = new LogicEngine(inputPanel, outputPanel);
        inputPanel.setInputEngine(engine.getInputEngine());
        //패널들을 만들고 로직엔진에만 연결한 상태


        window = new Window(inputPanel, outputPanel);
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
