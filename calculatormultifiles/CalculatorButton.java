package calculatormultifiles;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class CalculatorButton{
    // Create a JButton, adding a name, a listener and coloring it.  
    // Return the JButton.
    JButton createButton(String buttonName, ActionListener listener) {
        JButton button = new JButton(buttonName);
        button.setForeground(Color.RED);
        button.addActionListener(listener);
        return(button);
    }
}
