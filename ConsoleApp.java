public class ConsoleApp {
    

    public ConsoleApp(){
        OutputHandler consoleOutput = new ConsoleOutput();
        ConsoleInput consoleInput = new ConsoleInput();


        LogicEngine engine = new LogicEngine(consoleInput, consoleOutput);
        consoleInput.setInputEngine(engine.getInputEngine());
        
        

        consoleInput.handle("THIS IS  TEST TEXT FROM CONSOLEAPP ");
    }
}
