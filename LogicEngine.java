public class LogicEngine {
    private InputEngine inputEngine;
    private OutputEngine outputEngine;
    private CentralEngine centralEngine;

    public LogicEngine(OutputHandler outputHandler){
        this.inputEngine = new InputEngine();
        this.outputEngine = new OutputEngine(outputHandler);
        this.centralEngine = new CentralEngine(inputEngine, outputEngine);

        this.inputEngine.setCentralEngine(centralEngine);
    }

    public InputEngine getInputEngine(){
        return inputEngine;
    }
}
