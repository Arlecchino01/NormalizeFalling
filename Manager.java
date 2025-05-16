public class Manager {
    private OutputPanel outputPanel;
    private int step = 1;

    private String name;
    private int age;

    public Manager(OutputPanel outputPanel){
        this.outputPanel = outputPanel;
        outputPanel.showMessage("Manager in operation");
    }

    public void handleInput(String input){
        outputPanel.showMessage("Hi");
        outputPanel.showMessage("Your input = " + input);
    }
}
