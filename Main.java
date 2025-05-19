public class Main {
    public static void main(String[] args) {

        OutputHandler consoleOutput = new ConsoleOutput();
        ConsoleInput consoleInput = new ConsoleInput();


        LogicEngine engine = new LogicEngine(consoleInput, consoleOutput);
        consoleInput.setInputEngine(engine.getInputEngine());
        
        engine.getInputEngine().handleInput("hi directly from Main");
        //엔진의 인풋엔진에 직접 접근함
        //

        consoleInput.handle("this is from consoleInput");


    }
}
