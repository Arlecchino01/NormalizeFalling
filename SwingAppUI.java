public class SwingAppUI implements ApplicationUI{
    private LogicEngine engine;
    private OutputPanel outputPanel;
    private InputPanel inputPanel;
    private Window window;
    
    public SwingAppUI(){
        outputPanel = new OutputPanel();
        inputPanel = new InputPanel();
        window = new Window();

        
    }

    public void setEngine(LogicEngine logicEngine){
        this.engine = logicEngine;
    }

    @Override
    public void launch(){
        
    }
}
