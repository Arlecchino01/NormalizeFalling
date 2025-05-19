public class ConsoleOutput implements OutputHandler{
    @Override
    public void show(String msg){
        System.out.println("From ConsoleOutput Class: " + msg);
    }
}
