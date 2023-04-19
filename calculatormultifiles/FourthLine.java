package calculatormultifiles;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class FourthLine {
    private JPanel coreButtons;
    private CalculatorButton buttonCreator;
    FourthLine(){
        coreButtons = new JPanel();
    }
    public List<JButton> createButtons(ActionListener listener) {
        buttonCreator = new CalculatorButton();
        List<JButton> buttonList = new ArrayList<>();
        JButton b1 = buttonCreator.createButton("1", listener);
        JButton b2 = buttonCreator.createButton("2", listener);
        JButton b3 = buttonCreator.createButton("3", listener);
        JButton sub = buttonCreator.createButton("-", listener);
        JButton pm = buttonCreator.createButton("+/-", listener);

        
        buttonList.add(b1);
        buttonList.add(b2);
        buttonList.add(b3);
        buttonList.add(sub);
        buttonList.add(pm);

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

