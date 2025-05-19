public class SwingAppUI implements ApplicationUI{
    private LogicEngine engine;
    
    public SwingAppUI(LogicEngine engine){
        this.engine = engine;
    }

    @Override
    public void launch(){
        OutputPanel outputPanel = new OutputPanel();
        InputPanel inputPanel = new InputPanel();
    }
}
