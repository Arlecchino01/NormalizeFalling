public class CentralEngine {
    private InputEngine inputEngine;
    private OutputEngine outputEngine;

    public CentralEngine(InputEngine inputEngine, OutputEngine outputEngine){
        this.inputEngine = inputEngine;
        this.outputEngine = outputEngine;
    }

    public void onInput(String input){
        System.out.println("Central Engine accepted: '" + input + "'");
        System.out.println("Now, Central will pass it to OutputEngine");
        nextTest(input);
    }

    public void nextTest(String input){
        System.out.println("nextTest is activated");
        outputEngine.showMessage(input);
    }
}
