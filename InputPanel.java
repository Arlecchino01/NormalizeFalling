import javax.swing.*;
import java.awt.*;

public class InputPanel extends JPanel implements InputHandler{
    private JTextField inputField;
    private JButton submitButton;
    private InputEngine inputEngine;

    public InputPanel(){
        setLayout(new FlowLayout());

        inputField = new JTextField(20);
        submitButton = new JButton("제출");

        add(new JLabel("입력: "));
        add(inputField);
        add(submitButton);
    }

    public JTextField getInputField() {
        return inputField;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public String getInputText() {
        return inputField.getText();
    }

    

    public void clearInput() {
        inputField.setText("");
    }

    public void setInputEngine(InputEngine inputEngine){
        this.inputEngine = inputEngine;
    }

    @Override
    public void handle(String input){
        inputEngine.handleInput(input);
    }
}
