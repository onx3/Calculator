package calculatormultifiles;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class ThirdLine {
    private JPanel coreButtons;
    private CalculatorButton buttonCreator;

    ThirdLine(){
        coreButtons = new JPanel();
    }
    public List<JButton> createButtons(ActionListener listener) {
        buttonCreator = new CalculatorButton();
        List<JButton> buttonList = new ArrayList<>();
        JButton b4 = buttonCreator.createButton("4", listener);
        JButton b5 = buttonCreator.createButton("5", listener);
        JButton b6 = buttonCreator.createButton("6", listener);
        JButton mult = buttonCreator.createButton("*", listener);
        JButton prop = buttonCreator.createButton("1/x", listener);

        
        buttonList.add(b4);
        buttonList.add(b5);
        buttonList.add(b6);
        buttonList.add(mult);
        buttonList.add(prop);

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