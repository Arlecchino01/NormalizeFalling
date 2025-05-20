import javax.swing.*;
import java.awt.*;

public class InputOutputSection extends JPanel {
    private InputPanel inputPanel;
    private OutputPanel outputPanel;

    public InputOutputSection(InputPanel inputPanel, OutputPanel outputPanel){
        setLayout(new GridBagLayout()); 
        GridBagConstraints gbc = new GridBagConstraints();

        this.inputPanel = inputPanel;
        this.outputPanel = outputPanel;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(outputPanel,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(inputPanel,gbc);

        // 버튼에 액션 붙이기
        inputPanel.getSubmitButton().addActionListener(e -> {
            String text = inputPanel.getInputText();
            if (!text.isEmpty()) {
                inputPanel.handle(text);
                //outputPanel.showMessage(text);
                inputPanel.clearInput();
            }
        });
    }
    
}
