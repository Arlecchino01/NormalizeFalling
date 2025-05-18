public class OutputEngine {
    private OutputHandler handler;

    public OutputEngine(OutputHandler handler){
        this.handler = handler;
    }

    public void showMessage(String msg){
        handler.show(msg);
    }
}
