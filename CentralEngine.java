//YutEngine입장에서는 CentralEngine이 Callee다.
//YutEngine이 Central을 부르는 거다.

public class CentralEngine {
    private InputEngine inputEngine;
    private OutputEngine outputEngine;
    private YutEngine yutEngine;
    private String handlingString;
    private YutCallback callback;

    public interface YutCallback {
        public void onInput(CentralEngine centralEngine);
    }
    
    public CentralEngine(InputEngine inputEngine, OutputEngine outputEngine){
        this.inputEngine = inputEngine;
        this.outputEngine = outputEngine;
        handlingString = "nullString";
        this.callback = null;
    }

    public void onInput(String input){
        System.out.println("Central Engine accepted: '" + input + "'");
        System.out.println("Now, Central will pass it to OutputEngine");
        nextTest(input);
    }

    public void nextTest(String input){
        outputEngine.showMessage(input);
    }

    

    public void sendStringToOutputEngine(String string){
        outputEngine.showMessage(string);
    }

    

    
    //============= Communication with YutEngine =============

    public void initializeGame(){
        sendStringToOutputEngine("환영합니다");
        yutEngine = new YutEngine();
        yutEngine.setCentralEngine(this);
        yutEngine.launch();        
    }

    public void setYutCallBack(YutCallback callback){
        this.callback = callback;
    }

    public String getString(){
        return this.handlingString;
    }

    public void executeYut(){
        if (this.callback != null) {
            this.callback.onInput(CentralEngine.this);
        }
    }

    



}
