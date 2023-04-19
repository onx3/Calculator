package calculatormultifiles;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;

// This panel contains calculator managmenet buttons like 
//  Clear ("C")
//  Clear Entry ("CE")
//  Delete ("Delete")
//  A JPanel is created as are the calculator management buttons. 
//  The buttons are added to the panel and a list is returned to be used by the 
//  CalculatorDemo calling class (we hope to improve on this later)

public class ManagementPanel {
    private JPanel mgntJPanel;
    private CalculatorButton buttonCreator;
    private JButton clearButton, clearEntryButton, deleteButton;

    // Constructor that creates the JPanel
    ManagementPanel(){
        mgntJPanel = new JPanel();
    }

    // Method for creating the management button and adding them to a list to be returned to caller
    // The method calls addButtonsToPanel() to add them to the management panel
    public List<JButton> createButtons(ActionListener listener) {
        buttonCreator = new CalculatorButton();
        List<JButton> buttonList = new ArrayList<>();
        JButton clearEntryButton = buttonCreator.createButton("CE", listener);
        JButton clearButton = buttonCreator.createButton("C", listener);
        JButton deleteButton = buttonCreator.createButton("Delete", listener);
        
        buttonList.add(clearEntryButton);
        buttonList.add(clearButton);
        buttonList.add(deleteButton);
        addButtonsToPanel(buttonList);
        return buttonList;
    }
    
    // Private method for adding buttons to the mgnt panel.
    private void addButtonsToPanel(List<JButton> buttonList){
        for (JButton button : buttonList) {
            mgntJPanel.add(button);
        }
    }

    // Getter for use by a caller
    public JPanel getJPanel(){
        return(mgntJPanel);
    }

    // This method can be ignored but can be used for debugging.
    public void isSourceAMgntButton(Object source) {
        if (source == clearButton || source == clearEntryButton || source == deleteButton) {
                System.out.println("This is a management button\n");
        }
    }
}
