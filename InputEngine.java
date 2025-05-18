public class InputEngine {
    private CentralEngine central;

    public void setCentralEngine(CentralEngine central){
        this.central = central;
    }

    public void handleInput(String input){
        central.onInput(input);
    }

    

}
