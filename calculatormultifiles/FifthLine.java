package calculatormultifiles;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class FifthLine {
    private JPanel coreButtons;
    private CalculatorButton buttonCreator;

    FifthLine(){
        coreButtons = new JPanel();
    }
    public List<JButton> createButtons(ActionListener listener) {
        buttonCreator = new CalculatorButton();
        List<JButton> buttonList = new ArrayList<>();
        JButton b0 = buttonCreator.createButton("0", listener);
        JButton dot = buttonCreator.createButton(".", listener);
        JButton pow = buttonCreator.createButton("sqrt", listener);
        JButton add = buttonCreator.createButton("+", listener);
        JButton equal = buttonCreator.createButton("=", listener);

        
        buttonList.add(b0);
        buttonList.add(dot);
        buttonList.add(pow);
        buttonList.add(add);
        buttonList.add(equal);

        addButtonsToPanel(buttonList);
        return buttonList;
    }
    
    // Private method for adding buttons to the mgnt panel.
    private void addButtonsToPanel(List<JButton> buttonList){
        for (JButton button : buttonList) {
            coreButtons.add(button);
        }
    }

    // Getter for use by a caller
    public JPanel getJPanel(){
        return(coreButtons);
    }

}

