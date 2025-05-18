public class CentralEngine {
    private InputEngine inputEngine;
    private OutputEngine outputEngine;

    public CentralEngine(InputEngine inputEngine, OutputEngine outputEngine){
        this.inputEngine = inputEngine;
        this.outputEngine = outputEngine;
    }

    public void onInput(String input){
        System.out.println("Central Engine accepted: '" + input + "'");
        nextTest();
    }

    public void nextTest(){
        System.out.println("nextTest is activated");
    }
}
