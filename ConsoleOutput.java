public class ConsoleOutput implements OutputHandler{
    @Override
    public void show(String msg){
        System.out.println("This is from ConsoleOutput: " + msg);
    }
}
