public class OutputEngine {
    private OutputHandler handler;

    public OutputEngine(){

    }

    public void setOutputHandler(OutputHandler outputHandler){
        this.handler = outputHandler;
    }

    public void showMessage(String msg){
        handler.show(msg);
    }
}
