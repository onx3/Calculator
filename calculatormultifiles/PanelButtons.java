package calculatormultifiles;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class PanelButtons {
    private JPanel coreButtons;
    private CalculatorButton buttonCreator;
    PanelButtons(){
        coreButtons = new JPanel();
    }
    public List<JButton> createButtons(ActionListener listener) {
        buttonCreator = new CalculatorButton();
        List<JButton> buttonList = new ArrayList<>();
        JButton b7 = buttonCreator.createButton("7", listener);
        JButton b8 = buttonCreator.createButton("8", listener);
        JButton b9 = buttonCreator.createButton("9", listener);
        JButton div = buttonCreator.createButton("/", listener);
        JButton sqrt = buttonCreator.createButton("x^2", listener);

        buttonList.add(b7);
        buttonList.add(b8);
        buttonList.add(b9);
        buttonList.add(div);
        buttonList.add(sqrt);

        addButtonsToPanel(buttonList);
        return buttonList;
    }
    private void addButtonsToPanel(List<JButton> buttonList){
        for (JButton button : buttonList) {
            coreButtons.add(button);
        }
    }
    public JPanel getJPanel(){
        return(coreButtons);
    }

}

